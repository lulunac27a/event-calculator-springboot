package com.lulunac27a.eventcalculator.wrapper;

import java.util.ArrayList;
import java.util.List;

import com.lulunac27a.eventcalculator.entity.Event;

public class EventWrapper {
    private List<Event> events = new ArrayList<>();

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public void addEvent(Event event) {
        this.events.add(event);
    }

}
