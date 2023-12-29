package se.liu.ellno907.lab3;
import se.liu.ellno907.lab1.Person;

import java.util.ArrayList;
import java.util.List;

public class Queue extends ListManipulator
{
    public void enqueue(Person person){
	add(person); //Add a person to the queue
    }
    public Person dequeue(){
	if (elements.isEmpty()){
	    return null; //Can't remove a person from an empty list :P
	}
	else{
	    return elements.remove(0); //If the list isn't empty -> remove the first person
	}
    }

}