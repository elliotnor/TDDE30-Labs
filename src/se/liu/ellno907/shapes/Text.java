package se.liu.ellno907.shapes;


import java.awt.*;

public class Text extends AbstractShape{
    private int size;
    private String text;

    public Text(final int x, final int y,final int size, final Color color,final String text) {
	super(x,y,color);
	this.size = size;
	this.text = text;
    }
    @Override public String toString() {
	return "Text{" + "x=" + getX() + ", y=" + getY() + ", color=" + getColor() + '}';
    }

    public void draw(final Graphics g) {
	//System.out.println("Ritar " + this);
	g.setColor(getColor());
	g.setFont(new Font("serif", Font.PLAIN, size));
	g.drawString(text,getX(),getY());
    }
}
