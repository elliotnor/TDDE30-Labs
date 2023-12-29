package se.liu.ellno907.shapes;

import javax.swing.*;
import java.awt.*;
import java.util.List;

//Start of the graphical interface
public class DiagramComponent extends JComponent
{

    private List<Shape> shapes;

    //DiagramComponenet constructor
    public DiagramComponent(final List<Shape> shapes) {
	this.shapes = shapes;
    }

    //Iterate through the shapes and draw them on the screen
    @Override protected void paintComponent(final Graphics g) {
	for (Shape shape : shapes){
	    shape.draw(g);
	}
	super.paintComponent(g);
    }

    //Add a shape to the end of the list
    public void addShape(Shape s){
	shapes.add(s);
    }

}

