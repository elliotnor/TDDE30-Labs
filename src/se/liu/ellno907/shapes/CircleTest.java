package se.liu.ellno907.shapes;

import java.awt.*;
import java.util.ArrayList;

public class CircleTest
{
    public static void main(String[] args) {
	final ArrayList<Circle> circles = new ArrayList<>(); //Create a list containing circles
	//Create some circles
	Circle circle1 = new Circle(2, 2, 4, Color.blue);
	Circle circle2 = new Circle(3, 3, 5, Color.black);
	Circle circle3 = new Circle(2, 2, 4, Color.pink);

	//Add the circles to the list
	circles.add(0,circle1);
	circles.add(0,circle2);
	circles.add(0,circle3);

	//Print the circles in the list, using iterators
	for (Circle circle : circles) {
	    System.out.println(circle);
	}
    }
}

