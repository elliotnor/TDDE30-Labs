package se.liu.ellno907.calendar;

public class TimePoint {
    private int hour;
    private int minute;


    public int getHour() {
	return hour;
    }

    public int getMinute() {
	return minute;
    }

    public TimePoint(final int hour, final int minute) {
	this.hour = hour;
	this.minute = minute;
    }

    @Override public String toString() {
	return getHour() + ":" + getMinute();
    }
}
