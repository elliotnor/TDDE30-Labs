
package se.liu.ellno907.calendar;
import java.util.Map;
public class Month {
    private String name;
    private int number;
    private int days;
    public Month(final String name, final int number, final int days) {
	this.name = name;
	this.number = number;
	this.days = days;
    }
    final static Map<String, Integer> MONTH_NAME_TO_LENGTH = Map.ofEntries(
	    Map.entry("january", 31),
	    Map.entry("february", 28),
	    Map.entry("march", 31),
	    Map.entry("april", 30),
	    Map.entry("may", 31),
	    Map.entry("june", 30),
	    Map.entry("july", 31),
	    Map.entry("august", 31),
	    Map.entry("september", 30),
	    Map.entry("october", 31),
	    Map.entry("november", 30),
	    Map.entry("december", 31));
    private static Map<String,Integer> MONTH_NAME_TO_NUMBER= Map.ofEntries(
	    Map.entry("january", 1),
	    Map.entry("february", 2),
	    Map.entry("march", 3),
	    Map.entry("april", 4),
	    Map.entry("may", 5),
	    Map.entry("june", 6),
	    Map.entry("july", 7),
	    Map.entry("august", 8),
	    Map.entry("september", 9),
	    Map.entry("october", 10),
	    Map.entry("november", 11),
	    Map.entry("december", 12));
    public static int getMonthNumber(String name){
	String key = name;
	return MONTH_NAME_TO_NUMBER.get(key);
    }
    public static int getMonthDays(String name){
	String key = name;
	return MONTH_NAME_TO_LENGTH.get(key);
    }
    public String getName() {
	return name;
    }
    public int getNumber() {
	return number;
    }
    public int getDays() {
	return days;
    }
    public static void main(String[] args) {
	System.out.println(Month.getMonthDays("september"));
	System.out.println(Month.getMonthNumber("september"));
    }
}
