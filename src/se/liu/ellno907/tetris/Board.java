package se.liu.ellno907.tetris;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Board
{
    private SquareType[][] squares;
    private int height;
    private int width;
    private final static Random RND = new Random();
    private Poly falling;
    private Point fallingPos;
    private ArrayList<BoardListener> listeners;
    private TetrominoMaker maker;
    final private static int MARGIN = 2;
    final private static int DOUBLE_MARGIN = 4;
    private int gameover;



    /**
     * Board constructor
     * Creates a new Board with a height of height and
     * the width of width.
     **/
    public Board(final int height, final int width) {

        squares = new SquareType[height + DOUBLE_MARGIN][width + DOUBLE_MARGIN];
        this.height = height;
        this.width = width;

        for (int i = 0; i < width + DOUBLE_MARGIN; i++) {
            for (int j = 0; j < height + DOUBLE_MARGIN; j++) {
                if (i < MARGIN || i > width + MARGIN - 1 || j < MARGIN || j > height + MARGIN - 1){
                    squares[j][i] = SquareType.OUTSIDE; //Set the borders of the board
                }
                else{
                    squares[j][i] = SquareType.EMPTY;
                }
            }
        }
        maker = new TetrominoMaker();
        this.falling = null;
        this.fallingPos = new Point(0, 3);
        this.listeners = new ArrayList<>();
        gameover = 0;
    }

    public int getMargin(){
        return MARGIN;
    }

    public int getActualWidth(){
        return height + DOUBLE_MARGIN;
    }

    public int getActualHeight(){
        return width + DOUBLE_MARGIN;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Poly getFalling() {
        return falling;
    }

    public Point getFallingPos() {
        return fallingPos;
    }

    public SquareType[][] getSquares() {
        return squares;
    }

    public void addBoardListener(BoardListener bl) {
        listeners.add(bl);
    }

    private void notifyListeners() {
        for (BoardListener listener : listeners) {
            listener.boardChanged();
        }
    }

    /**
     * Checks if a row is full. If yes -> it removes the row
     */
    public void checkFullRow(){
        for (int y = 0; y < getHeight(); y++) {
            boolean isFull = true;
            for (int x = 0; x < getWidth(); x++) {
                if(getTypeAtCord(x,y) == SquareType.EMPTY){
                    isFull = false;
                    break;
                }
            }
            if (isFull){
                removeRow(y);
                moveDownRows(y);
            }
        }
    }


    public void removeRow(int y){
        for(int x = 0; x < width; x++) {
            squares[y+MARGIN][x+MARGIN] = SquareType.EMPTY;
        }
    }

    private void moveDownRows(int ycord) {
        for(int y = ycord - 1; 0 <= y; y--) {
            for(int x = 0; x < width; x++) {
                squares[y + MARGIN + 1][x + MARGIN] = getTypeAtCord(x, y);
            }
        }
        notifyListeners();
    }

    public void fallingToBoard(){
        for (int y = 0; y < falling.getPolyLength(); y++) {
            for (int x = 0; x < falling.getPolyLength(); x++) {
                if (falling.getTypeAtCord(x,y) != SquareType.EMPTY){
                    squares[y+fallingPos.y+MARGIN][x+fallingPos.x+MARGIN] = falling.getTypeAtCord(x,y);
                }
            }

        }
    }

    /**
     * Checks for collisions between a falling
     * tetromino and a still block or border
     */
    private boolean hasCollision(){
        if (falling != null) {
            for (int x = 0; x < falling.getPolyLength(); x++) {
                for (int y = 0; y < falling.getPolyLength(); y++) {
                    if (falling.getTypeAtCord(x, y) != SquareType.EMPTY &&
                        getTypeAtCord (fallingPos.x + x,fallingPos.y + y+MARGIN) != SquareType.EMPTY) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void randomizePoly() {
        maker = new TetrominoMaker();
        SquareType[] a = SquareType.values();
        int randomsquarenumber = RND.nextInt(1,a.length-1);
        falling = maker.getPoly(randomsquarenumber);
        notifyListeners();
    }

    /**
     * Gets a random poly type from randomizePoly()
     * Sets the
     */
    public void setFalling() {
        randomizePoly();
        fallingPos.x = 3;
        fallingPos.y = -1;
        notifyListeners();

    }

    public void moveFalling() {
            fallingPos.y += 1;
            notifyListeners();
    }

    public void randomizeBoard() {
        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                SquareType[] a = SquareType.values();
                SquareType randomsquare = a[RND.nextInt(a.length)];
                squares[i][j] = randomsquare;
                notifyListeners();
            }
        }
    }

    /**
     * Used to move a falling tetromino either left or right
     * Also checks for a collision before moving
     */
    public void move(Direction direction) {
        if (direction == Direction.LEFT) {
            fallingPos.x -= 1;
            if (hasCollision()){
                fallingPos.x +=1;
            }
        }
        if (direction == Direction.RIGHT) {
            fallingPos.x += 1;
            if (hasCollision()){
                fallingPos.x -=1;
            }
        }
        notifyListeners();
    }

    public SquareType getTypeAtCord(int width,int height) {
        return squares[height+MARGIN][width+MARGIN];
    }

    public SquareType getVisibleSquareAt(int x, int y) {
        if (falling != null) {
            int x1 = fallingPos.x;
            int y1 = fallingPos.y;
            int x2 = fallingPos.x + falling.getPolyLength();
            int y2 = fallingPos.y + falling.getPolyLength();

            if (x < x1 || y < y1 || x >= x2 || y >= y2 || falling.getTypeAtCord(x - x1,y - y1) == SquareType.EMPTY) {
                return
                        squares[y+MARGIN][x+MARGIN];
            }
            else {
                return falling.getTypeAtCord(x - x1,y - y1);
            }
        }
        else{
            return squares[y][x];
        }
    }

    @Override public String toString() {
        return Arrays.toString(squares) + ", width=" + height + ", height=" + width + '}';
    }

    /**
     * Handles one game-tick.
     * performs actions such as checking for full rows and moving
     * the falling tetromino
     */
    public void tick() {
        if (gameover == 0){
            if (falling == null){
                setFalling();
                checkFullRow();
            }
            if (hasCollision()) {
                fallingPos.y += 1;
                fallingToBoard();
                setFalling();
                checkFullRow();
                if (hasCollision()){ //You want to fill the entire board, not to get gameover when one column is filled
                    System.out.println("Game Over");
                    gameover = 1;
                    fallingPos.y += 1;
                }
            }
            else {
                moveFalling();
            }
            notifyListeners();
        }
    }

    /**
     * Rotates a falling poly, either left or right
     */
    public void rotate(Direction dir){
        Poly originalpoly = falling;
        if (dir == Direction.RIGHT){
            for (int i = 0; i < 3; i++) {
                falling = falling.rotateLeft();
            }
        }
        if (dir == Direction.LEFT){
            falling = falling.rotateLeft();
        }
        if (hasCollision()){
            falling = originalpoly;
        }
        notifyListeners();
    }
}
