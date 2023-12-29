package se.liu.ellno907.calendar;
import java.util.ArrayList;
import java.util.List;

public class Cal
{
    private List<Appointment> appointments;

    public Cal() {
        this.appointments = new ArrayList<>();
    }

    public void book(int year, String month, int day, int startHour, int startMinute, int endHour, int endMinute, String subject) {
        if (year < 1970) {
            throw new IllegalArgumentException("Invalid year number");
        } else if (0 <= startHour && startHour >= 23) {
            throw new IllegalArgumentException("Invalid starting hour");
        } else if (0 <= startMinute && startMinute >= 59) {
            throw new IllegalArgumentException("Invalid starting minute");
        } else if (0 <= endHour && endHour >= 23) {
            throw new IllegalArgumentException("Invalid ending hour");
        } else if (0 <= endMinute && endMinute >= 59) {
            throw new IllegalArgumentException("Invalid ending minute");
        } else if (Month.getMonthDays(month) < day) {
            throw new IllegalArgumentException("Invalid date");
        } else if (!Month.MONTH_NAME_TO_LENGTH.containsKey(month)) {
            throw new IllegalArgumentException("Invalid month");}

        else{
            int monthNum = Month.getMonthNumber(month);
            int monthDays = Month.getMonthDays(month);
            Month theMonth = new Month(month, monthNum, monthDays);
            SimpleDate theDate = new SimpleDate(year, theMonth, day);

            TimePoint startingPoint = new TimePoint(startHour, startMinute);
            TimePoint endPoint = new TimePoint(endHour, endMinute);
            TimeSpan theTimespan = new TimeSpan(startingPoint, endPoint);

            Appointment newAppointment = new Appointment(subject, theDate,theTimespan);
            appointments.add(newAppointment);
        }
    }

    public static void main(String[] args) {
        Cal calendar = new Cal();
        calendar.book(2022,"january",29,10,1,11,1,"Padel med Jennifer");
        calendar.book(2023, "september", 25, 9, 1,10,2,"22nd birthday");
        //calendar.book(2022,"january", 28, 13,30,14,1,"Dinner with Emily");

        calendar.show();
    }

    public void show(){
        for (Appointment appointment : appointments) {
            System.out.println(appointment.getSubject() + " : " + appointment.toString());

        }
    }
}

