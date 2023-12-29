package se.liu.ellno907.shapes;

import java.awt.*;

public class Circle extends AbstractShape
{
    private int radius;

    //Standard circle constructor
    public Circle(final int x, final int y, final int radius, final Color color) {
	super(x, y, color); //Sets the x,y and color fields mentioned in "AbstractShape"
	if (radius < 0) {
	    throw new IllegalArgumentException("Negativ radie!"); //Can't have a negative radius!
	}
	this.radius = radius; //Set the radius
    }

    //Returns the radius of a circle
    public int getRadius() {
	return radius;
    }

    //Print out the attributes of a circle
    @Override public String toString() {
	return "Circle{" + "x=" + getX() + ", y=" + getY() + ", radius=" + radius + ", color=" + getColor() + '}';
    }

    //Draw a circle from given parameters
    @Override public void draw(final Graphics g) {
	int width = radius*2;
	int height = radius*2;
	g.setColor(getColor());
	g.drawOval(getX(), getY(), width, height); // calc. from radius!
    }
}

