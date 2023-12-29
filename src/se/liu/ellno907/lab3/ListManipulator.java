package se.liu.ellno907.lab3;

import se.liu.ellno907.lab1.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ListManipulator
{
    //Create a new arraylist with person inside
    protected List<Person> elements = new ArrayList<>();

    //Returns the number of elements in list
    protected int size() {
	return elements.size();
    }

    //Returns true if the list is empty
    protected boolean isEmpty() {
	return elements.isEmpty();
    }

    //Checks if list contains a given element
    protected boolean contains(final Object o) {
	return elements.contains(o);
    }

    //Returns an iterator of the elemnts in
    protected Iterator<Person> iterator() {
	return elements.iterator();
    }

    //Adds a person to the end of the list
    protected boolean add(final Person person) {
	return elements.add(person);
    }

    //Removes a person from the list
    protected boolean remove(final Object o) {
	return elements.remove(o);
    }

    //Removes all elements from a given list
    protected void clear() {
	elements.clear();
    }
}
