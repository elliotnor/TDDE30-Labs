package se.liu.ellno907.tetris;


import javax.swing.*;
import java.awt.*;
import java.util.EnumMap;

public class TetrisComponent extends JComponent implements BoardListener
{
    private Board board;
    private final EnumMap<SquareType, Color> colorMap = createColorMap();
    private final static int SQUARE_SIZE = 30;

    public TetrisComponent(final Board board) {
	this.board = board;
    }

    @Override
    protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	final Graphics2D g2d = (Graphics2D) g;
	for (int i = 0; i < board.getWidth(); i++) {
	    for (int j = 0; j < board.getHeight(); j++) {
		SquareType square = board.getVisibleSquareAt(i,j);
		g2d.setColor(colorMap.get(square));
		g2d.fillRect(i*SQUARE_SIZE,j*SQUARE_SIZE,SQUARE_SIZE,SQUARE_SIZE);
	    }
	}
    }

    private static EnumMap<SquareType, Color> createColorMap() {
	final EnumMap<SquareType, Color> colorMap = new EnumMap<>(SquareType.class);
	colorMap.put(SquareType.I,Color.cyan);
	colorMap.put(SquareType.O,Color.yellow);
	colorMap.put(SquareType.T,Color.pink);
	colorMap.put(SquareType.S,Color.green);
	colorMap.put(SquareType.Z,Color.red);
	colorMap.put(SquareType.J,Color.blue);
	colorMap.put(SquareType.L,Color.orange);
	colorMap.put(SquareType.OUTSIDE,Color.black);
	colorMap.put(SquareType.EMPTY,Color.black);

	return colorMap;
    }

    public Dimension getPreferredSize(){
	Dimension dimension = new Dimension();
	dimension.setSize(board.getWidth()*SQUARE_SIZE,board.getHeight()*SQUARE_SIZE);
	return dimension;
    }

    public static void main(String[] args) {
	Board board = new Board(200,200);
	TetrisComponent component = new TetrisComponent(board);
    }

    @Override public void boardChanged() {
	repaint();
    }


}
