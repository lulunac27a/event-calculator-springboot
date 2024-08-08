package com.lulunac27a.eventcalculator.entity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Event {// event class with name, event start date, event repeat interval, event repeat
                    // often and list of events
    private String name = "";// event name
    private LocalDate startDate = LocalDate.now();// event start date
    private RepeatInterval repeatInterval = RepeatInterval.DAILY;// event repeat interval
    private int repeatOften = 1;// event repeat often

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public RepeatInterval getRepeatInterval() {
        return repeatInterval;
    }

    public int getRepeatOften() {
        return repeatOften;
    }

    public LocalDate getNextEventDate(LocalDate eventStartDate, RepeatInterval repeatInterval, int repeatOften) {
        LocalDate currentDate = LocalDate.now();// current date
        LocalDate nextEventDate = null;// calculate next event date based on event start date, repeat interval and
                                       // repeat often
        switch (repeatInterval) {
            case DAILY:// daily events
                int dayDifference = (int) ChronoUnit.DAYS.between(eventStartDate, currentDate);// calculate date
                                                                                               // difference
                int dailyTimes = (dayDifference + repeatOften - 1) / repeatOften;// calculate number of times event
                                                                                 // happened
                nextEventDate = eventStartDate.plusDays((long) repeatOften * dailyTimes);// calculate next event date by
                                                                                         // adding date
                break;
            case WEEKLY:// weekly events
                int weekDifference = (int) ChronoUnit.WEEKS.between(eventStartDate, currentDate);
                int weeklyTimes = (weekDifference + repeatOften - 1) / repeatOften;
                nextEventDate = eventStartDate.plusWeeks((long) repeatOften * weeklyTimes);
                break;
            case MONTHLY:// monthly events
                int monthDifference = (int) ChronoUnit.MONTHS.between(eventStartDate, currentDate);
                int monthlyTimes = (monthDifference + repeatOften - 1) / repeatOften;
                nextEventDate = eventStartDate.plusMonths((long) repeatOften * monthlyTimes);
                break;
            case YEARLY:// yearly events
                int yearDifference = (int) ChronoUnit.YEARS.between(eventStartDate, currentDate);
                int yearlyTimes = (yearDifference + repeatOften - 1) / repeatOften;
                nextEventDate = eventStartDate.plusYears((long) repeatOften * yearlyTimes);
                break;
        }
        return nextEventDate;// return next event date
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setRepeatInterval(RepeatInterval repeatInterval) {
        this.repeatInterval = repeatInterval;
    }

    public void setRepeatOften(int repeatOften) {
        this.repeatOften = repeatOften;
    }

    public enum RepeatInterval {
        DAILY, WEEKLY, MONTHLY, YEARLY
    }
}
