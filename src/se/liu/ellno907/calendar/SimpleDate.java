package se.liu.ellno907.calendar;

public class SimpleDate {
    private int year;
    private Month month;
    private int day;

    @Override public String toString() {
	return getDay() + " / " + month.getNumber() + " - " + getYear();
    }

    public SimpleDate(final int year, final Month month, final int day) {
	this.year = year;
	this.month = month;
	this.day = day;
    }

    public int getYear() {
	return year;
    }

    public Month getMonth() {
	return month;
    }

    public int getDay() {
	return day;
    }

}


