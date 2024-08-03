package com.lulunac27a.eventcalculator.service;

import com.lulunac27a.eventcalculator.entity.Event;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface EventService {
    Event getEvent(LocalDate eventDate);// get list of events

    List<Event> findAll();// find all events

}
