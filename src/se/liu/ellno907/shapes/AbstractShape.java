package se.liu.ellno907.shapes;

import java.awt.*;
import java.util.Objects;

public abstract class AbstractShape implements Shape
{
    //Protected fields to be filled in by each shape
    protected int x;
    protected int y;
    protected Color color;

    //Things that each shape contains. Unique shape fields are not included (ex. radius of circle)
    protected AbstractShape(final int x, final int y, final Color color) {
	this.x = x;
	this.y = y;
	this.color = color;
    }

    //Return the x-coordinate of a shape (method shell)
    public int getX() {
	return x;
    }

    //Return the y-coordinate of a shape (method shell)
    public int getY() {
	return y;
    }

    //Return the color of a shape (method shell)
    public Color getColor() {
	return color;
    }

    //Compare if two shapes are "identical". Ovverides equals() in Shape
    @Override public boolean equals(final Object o) {
	if (this == o) {
	    return true;
	}
	if (o == null || getClass() != o.getClass()) {
	    return false;
	}
	final AbstractShape that = (AbstractShape) o;
	return x == that.x && y == that.y && Objects.equals(color, that.color);
    }

    //We don't care about this one
    @Override public int hashCode() {
	return Objects.hash(x, y, color);
    }
}
