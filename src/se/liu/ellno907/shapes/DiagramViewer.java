package se.liu.ellno907.shapes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DiagramViewer
{
    private final static List<Color> COLORS =
	    List.of(Color.BLACK, Color.RED, Color.GREEN, Color.BLUE,
		    Color.CYAN, Color.YELLOW, Color.MAGENTA);

    // Set a fixed seed 0 so you always get the same
    // shapes (for debugging)
    private final static Random RANDOM = new Random();

    private static Color getRandomColor() {
	return COLORS.get(RANDOM.nextInt(COLORS.size()));
    }

    private static Circle getRandomCircle() {
	return new Circle(RANDOM.nextInt(400), RANDOM.nextInt(400),
			  RANDOM.nextInt(200), getRandomColor());
    }

    private static Rectangle getRandomRectangle() {
	return new Rectangle(RANDOM.nextInt(400), RANDOM.nextInt(400),
			     RANDOM.nextInt(200), RANDOM.nextInt(200),
			     getRandomColor());
    }

    private static Text getRandomText() {
	return new Text(RANDOM.nextInt(400), RANDOM.nextInt(400), RANDOM.nextInt(400), getRandomColor(), "Hello");
    }

    public static void main(String[] args) {
	final List<Shape> shapes = new ArrayList<>();

	DiagramComponent comp = new DiagramComponent(shapes);

	final Random rnd = new Random();

	for (int i = 0; i < 10; i++) {
	    switch (rnd.nextInt(3)) {
		case 0:
		    comp.addShape(getRandomCircle());
		    break;
		case 1:
		    comp.addShape(getRandomRectangle());
		    break;
		case 2:
		    comp.addShape(getRandomText());
		    break;
	    }
	}

	//Set the parameters of the window, then show it!
	JFrame frame = new JFrame("Mitt fönster");
	frame.setLayout(new BorderLayout());
	frame.add(comp, BorderLayout.CENTER);
	frame.setSize(800, 600);
	frame.setVisible(true);
    }
}

