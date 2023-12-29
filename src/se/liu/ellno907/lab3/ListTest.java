package se.liu.ellno907.lab3;

import se.liu.ellno907.lab1.Person;
import java.time.LocalDate;

public class ListTest
{
    public static void main(String[] args) {
	//Create some new persons
	Person jennifer = new Person("Jennifer",LocalDate.of(2010, 4, 21));
	Person henrik = new Person("Henrik", LocalDate.of(2001, 4, 21));
	Person pelle = new Person("Pelle",LocalDate.of(1998,3,16));
	Person eric = new Person("Eric",LocalDate.of(2002,4,10));
	Person jacob = new Person("Jacob",LocalDate.of(2000, 4, 21));

	Stack persons = new Stack(); //Create a new stack

	//Add the people to the stack, "in stack order"
	persons.push(jennifer);
	persons.push(henrik);
	persons.push(pelle);
	persons.push(eric);
	persons.push(jacob);

	Queue personsque = new Queue(); //Create a new queue

	//Enqueue the people, "in queue order"
	personsque.enqueue(jennifer);
	personsque.enqueue(henrik);
	personsque.enqueue(pelle);
	personsque.enqueue(eric);
	personsque.enqueue(jacob);

	//while (!persons.isEmpty()){
	//    System.out.println(persons.pop());
	//}

	while (!personsque.isEmpty()){
	    System.out.println(personsque.dequeue());
	}
    }
}
