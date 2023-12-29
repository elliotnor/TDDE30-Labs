package se.liu.ellno907.lab1;

import java.time.LocalDate;
import java.time.Period;

public class Person{
    private String name;
    private LocalDate birthDay;


    //Person constructor
    public Person(String name, LocalDate birthDay) {
    	this.name = name;
	this.birthDay = birthDay;

    }


    public int getAge(){
	Period theAge = Period.between(birthDay, LocalDate.now());
	int yearAge = theAge.getYears();
	return yearAge;

    }

    @Override public String toString() {
	return name + " " +getAge();
    }

    public static void main(String[] args) {

	LocalDate bDay = LocalDate.of(2001, 9, 25); //Bday variable

	//Create some persons
	Person person1 = new Person("Elliot", bDay); //Alt. 1
	Person person2 = new Person("Adam", LocalDate.of(1990,7,10)); //Alt. 2
	Person person3 = new Person("Elise", LocalDate.of(1578, 12,1));
	Person person4 = new Person("Kalle", LocalDate.of(2001,12,4));


	//Print the persons
	System.out.println ("The persons age is " + person1.getAge());
	System.out.println(person1);
	System.out.println(person2);
	System.out.println(person3);
	System.out.println(person4);

    }
}

