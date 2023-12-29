package se.liu.ellno907.lab1;
import javax.swing.*;

public class Exercise8 {

    public static void main(String[] args) {
	boolean status = true;
	while (status == true) {
	    if (askUser("Quit?") && askUser("Really?")) {
		status = false;
	    }
	}
	return;
    }

    public static boolean askUser(String question){
	return JOptionPane.showConfirmDialog(null, question, "",
					     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

    }

}
