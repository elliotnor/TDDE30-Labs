package se.liu.ellno907.lab1;

public class Exercise10 {
    public static void main(String[] args) {
	int number = 16777216;
	double decimal = number;
	System.out.println("This is the number: " + number);
	System.out.println("This is the decimal: " + decimal);
    	System.out.println("---------------------------------");
	int interAgain = (int)decimal;
	System.out.println("This is the number: " + number);
	System.out.println("This is the decimal: " + decimal);
	System.out.println("This is the interAgain: " + interAgain);
	System.out.println("---------------------------------");
//Inget händer när konversion på decimal (float => double)
	int big = 2147483647;
	int bigger = big + 1;
	System.out.println("This is big: " + big);
	System.out.println("This is bigger: " + bigger);
	System.out.println("---------------------------------");
	long bigger2 = (long)bigger;

	System.out.println("This is bigger: "+ bigger2);
	System.out.println("---------------------------------");
	long bigger3 = big + 1L;
	System.out.println("This is bigger: " + bigger3);
	long bigger4 = (long)big+1;
	System.out.println("This is bigger: " + bigger4);

    }
}
