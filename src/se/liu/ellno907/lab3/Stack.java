package se.liu.ellno907.lab3;

import se.liu.ellno907.lab1.Person;

import java.util.ArrayList;
import java.util.List;

public class Stack extends ListManipulator
{
    //Add a person to the top of the stack
    public void push(Person person){
	elements.add(person);
    }

    //Removes the top element of the stack
    public Person pop(){
	return elements.remove(elements.size()-1);
    }

}
