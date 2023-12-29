package se.liu.ellno907.calendar;

public class TimeSpan
{
    private TimePoint start;
    private TimePoint end;

    @Override public String toString() {
	return getStart() + " - " + getEnd();
    }

    public TimeSpan(final TimePoint start, final TimePoint end) {
	this.start = start;
	this.end = end;
    }

    public TimePoint getStart() {
	return start;
    }

    public TimePoint getEnd() {
	return end;
    }


}
