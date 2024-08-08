package com.lulunac27a.eventcalculator;

import com.lulunac27a.eventcalculator.entity.Event;
import com.lulunac27a.eventcalculator.wrapper.EventWrapper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
public class EventController {
    private EventWrapper eventWrapper = new EventWrapper();

    @GetMapping("/") // index page
    public String getNextEvent(Model model) {
        Event eventInfo = new Event();// get event info based on list of events
        model.addAttribute("eventInfo", eventInfo);
        LocalDate nextEventDate = eventInfo.getNextEventDate(eventInfo.getStartDate(), eventInfo.getRepeatInterval(),
                eventInfo.getRepeatOften());// get next event date based on entered values
        model.addAttribute("nextEventDate", nextEventDate);
        return "index";// show index page
    }

    @GetMapping("/event-list") // events list page
    public String getEventsList(Model model) {
        model.addAttribute("eventList", eventWrapper);// get list of all events
        return "events-list";// show list of events
    }

    @PostMapping("create-event") // create event page
    public String addEvent(@ModelAttribute Event eventInfo, Model model) {
        eventWrapper.addEvent(eventInfo);// add event based on entered form values
        model.addAttribute("eventInfo", eventInfo);
        LocalDate nextEventDate = eventInfo.getNextEventDate(eventInfo.getStartDate(), eventInfo.getRepeatInterval(),
                eventInfo.getRepeatOften());// calculate next event date based on input form values
        model.addAttribute("nextEventDate", nextEventDate);
        return "add-event";// show add new event page
    }

    @RequestMapping("/") // home page
    public String showHomePage() {
        return "index";// show home page
    }
}
