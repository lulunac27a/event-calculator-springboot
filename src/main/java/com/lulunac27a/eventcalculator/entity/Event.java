package com.lulunac27a.eventcalculator.entity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static com.lulunac27a.eventcalculator.entity.Event.RepeatInterval.DAILY;

public class Event {
    private String name;
    private LocalDate startDate = LocalDate.now();
    private RepeatInterval repeatInterval = DAILY;
    private int repeatOften = 1;

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
    public LocalDate getNextEventDate(LocalDate eventStartDate, RepeatInterval repeatFrequency, int repeatOften) {
        LocalDate nextEventDate = null;
        switch (repeatFrequency) {
            case DAILY:
                int dayDifference = (int) ChronoUnit.DAYS.between(eventStartDate, LocalDate.now());
                int dailyTimes = (dayDifference + repeatOften - 1) / repeatOften;
                nextEventDate = eventStartDate.plusDays(repeatOften * dailyTimes);
                break;
            case WEEKLY:
                int weekDifference = (int) ChronoUnit.WEEKS.between(eventStartDate, LocalDate.now());
                int weeklyTimes = (weekDifference + repeatOften - 1) / repeatOften;
                nextEventDate = eventStartDate.plusWeeks(repeatOften * weeklyTimes);
                break;
            case MONTHLY:
                int monthDifference = (int) ChronoUnit.MONTHS.between(eventStartDate, LocalDate.now());
                int monthlyTimes = (monthDifference + repeatOften - 1) / repeatOften;
                nextEventDate = eventStartDate.plusMonths(repeatOften * monthlyTimes);
                break;
            case YEARLY:
                int yearDifference = (int) ChronoUnit.YEARS.between(eventStartDate, LocalDate.now());
                int yearlyTimes = (yearDifference + repeatOften - 1) / repeatOften;
                nextEventDate = eventStartDate.plusYears(repeatOften * yearlyTimes);
                break;
        }
        return nextEventDate;
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


    public enum RepeatInterval{
        DAILY, WEEKLY, MONTHLY, YEARLY
    }
}
