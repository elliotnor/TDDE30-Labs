package se.liu.ellno907.lab1;

import javax.swing.*;

public class Exercise2{
	public static int sumFor(int min, int max){
	    int sum = 0;
	    for (int i = min; i <= max; i++) {
		sum +=i;
	    }
	    return sum;
	}

	public static void main(String[] args) {
	    final int min = 10;
	    final int max = 20;

	    String method = JOptionPane.showInputDialog("Please select while or for");

	    switch (method){
		case "for":
		    System.out.println(sumFor(min, max));
		    break;

		case "while":
		    System.out.println(whileFor(min, max));
		    break;
		default:
		    System.out.println("Invalid method!");
	    }
	}

	public static int whileFor(int min, int max){
	    int count = min;
	    int sum = 0;
	    while(count <= max){
		sum +=count;
		count++;

	    }
	    return sum;

	}
}


