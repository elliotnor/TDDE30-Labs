package se.liu.ellno907.lab1;
import javax.swing.*;

public class Exercise3 {
    private final static int TABELL = 1;

    public static void main(String[] args) {
	String input =
		JOptionPane.showInputDialog("Please input a value");
	int tabell = Integer.parseInt(input);
	for(int i = 1; i <= 12; i++) {
	    System.out.println(tabell * i);
	}
    }
}
