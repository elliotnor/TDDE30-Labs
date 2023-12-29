package se.liu.ellno907.lab1;

import javax.swing.*;
public class Exercise9 {

    public static void main(String[] args){
	String x =
		JOptionPane.showInputDialog("Please input a value");
	double xString = Double.parseDouble(x);

	System.out.println(findRoot(xString));
    }


    public static double findRoot(double x) {
	double guess = x;
	int count = 1;

	while (count <= 10){
	    count++;
	    guess -= (guess * guess - x) / (2 * guess);
	}
	return guess;
    }
}

