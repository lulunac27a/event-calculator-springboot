package com.lulunac27a.eventcalculator.wrapper;

import com.lulunac27a.eventcalculator.entity.Event;
import java.util.ArrayList;
import java.util.List;

public class EventWrapper {

    private List<Event> events = new ArrayList<>(); // list of events

    public List<Event> getEvents() {
        return events; // get the list of events
    }

    public void setEvents(List<Event> events) {
        this.events = events; // set the list of events
    }

    public void addEvent(Event event) {
        this.events.add(event); // add event
    }
}
