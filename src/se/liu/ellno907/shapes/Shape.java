package se.liu.ellno907.shapes;

import java.awt.*;

//Shape interface
public interface Shape
{
    //Methods that are implemented in AbstractShape
    int getX();
    int getY();
    Color getColor();
    public void draw(final Graphics g);
}
