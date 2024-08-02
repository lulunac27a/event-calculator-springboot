package com.lulunac27a.eventcalculator.service;

import com.lulunac27a.eventcalculator.entity.Event;

import java.time.LocalDate;
import java.util.List;

public interface EventService {
    Event getEvent(LocalDate eventDate);

    List<Event> findAll();

}
