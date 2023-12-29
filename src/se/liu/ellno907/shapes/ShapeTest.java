package se.liu.ellno907.shapes;

import java.awt.*;
import java.util.ArrayList;

public class ShapeTest
{
    public static void main(String[] args) {
	//Create a list of shapes
	final ArrayList<Shape> Shapes = new ArrayList<>();

	//Create some circles
	Circle circle1 = new Circle(2, 2, 4, Color.blue);
	Circle circle2 = new Circle(3, 3, 5, Color.black);
	Circle circle3 = new Circle(2, 2, 4, Color.green);

	//Add the circles to the Shapes-list
	Shapes.add(0,circle1);
	Shapes.add(0,circle2);
	Shapes.add(0,circle3);

	//Create some rectangles
	Rectangle rectangle1 = new Rectangle(3,3,4,5,Color.pink);
	Rectangle rectangle2 = new Rectangle(3,3,4,5,Color.red);
	Rectangle rectangle3 = new Rectangle(3,3,4,5,Color.blue);

	//Add the rectangles to the Shapes-list
	Shapes.add(0,rectangle1);
	Shapes.add(0,rectangle2);
	Shapes.add(0,rectangle3);

	//Create some text
	Text text1 = new Text(2,2,4,Color.green,"TSEA22");
	Text text2 = new Text(2,2,4,Color.green,"TATA41");
	Text text3 = new Text(2,2,4,Color.green,"TDDE30");

	//Add the text to the Shapes-list
	Shapes.add(0,text1);
	Shapes.add(0,text2);
	Shapes.add(0,text3);

	//Iterate through the shapes in the Shapes-list (Used to draw them as well in previous implementation)
	for (Shape shape : Shapes) {
	    //shape.draw();
	}
    }
}
