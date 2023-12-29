package se.liu.ellno907.shapes;

import java.awt.*;

public class Rectangle extends AbstractShape
{
    private int width;
    private int height;

    //Standard rectangle constructor
    public Rectangle(final int x, final int y, final int width, final int height, final Color color) {
	super(x,y,color); //Sets the x,y and color fields mentioned in "AbstractShape"
	this.width = width;
	this.height = height;
    }

    //Used to print out the attributes of a rectangle
    @Override public String toString() {
	return "Rectangle{" + "x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + ", color=" + color + '}';
    }

    //Draw the rectangle
    public void draw(final Graphics g) {
	//System.out.println("Ritar: " + this);
	g.setColor(getColor());
	g.drawRect(getX(), getY(), width, height);
    }
}
