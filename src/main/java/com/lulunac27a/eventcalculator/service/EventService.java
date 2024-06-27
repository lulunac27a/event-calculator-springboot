package com.lulunac27a.eventcalculator.service;

import com.lulunac27a.eventcalculator.entity.Event;

import java.time.LocalDate;

public interface EventService {
    Event getEvent(LocalDate eventDate);
}
