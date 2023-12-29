package se.liu.ellno907.tetris;

import java.util.Arrays;

public class Poly
{
    private SquareType[][] polySquares;

    public Poly(final SquareType[][] polySize) {
        this.polySquares = polySize;
    }

    public SquareType[][] getPolySquares() {
        return polySquares;
    }

    public int getPolyLength(){
        return getPolySquares().length;
    }

    public SquareType getTypeAtCord(int x,int y){
        return polySquares[y][x];
    }

    public Poly rotateLeft() {
        Poly newPoly = new Poly(new SquareType[getPolyLength()][getPolyLength()]);

        for (int r = 0; r < getPolyLength(); r++) {
            for (int c = 0; c < getPolyLength(); c++){
                newPoly.getPolySquares()[c][getPolyLength() - 1 - r] = this.getPolySquares()[r][c];
            }
        }

        return newPoly;
    }

    @Override public String toString() {
        return "Poly{" + "polySize=" + Arrays.toString(polySquares) + '}';
    }
}
