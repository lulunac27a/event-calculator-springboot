package com.lulunac27a.eventcalculator;

import com.lulunac27a.eventcalculator.entity.Event;
import com.lulunac27a.eventcalculator.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
public class EventController {
    private EventService eventService;

    @GetMapping("/")
    public String getNextEvent(Model model) {
        Event eventInfo = new Event();
        model.addAttribute("eventInfo", eventInfo);
        LocalDate nextEventDate = eventInfo.getNextEventDate(eventInfo.getStartDate(), eventInfo.getRepeatInterval(),
                eventInfo.getRepeatOften());
        model.addAttribute("nextEventDate", nextEventDate);
        return "index";
    }

    @GetMapping("/event-list")
    public String getEventsList(Model model) {
        model.addAttribute("eventList", eventService.findAll());
        return "events-list";
    }

    @PostMapping("create-event")
    public String addEvent(@ModelAttribute("eventInfo") Event eventInfo, Model model) {
        Event eventList = new Event();
        eventList.addEvent(eventInfo);
        model.addAttribute("eventList", eventList);
        model.addAttribute("eventInfo", eventInfo);
        LocalDate nextEventDate = eventInfo.getNextEventDate(eventInfo.getStartDate(), eventInfo.getRepeatInterval(),
                eventInfo.getRepeatOften());
        model.addAttribute("nextEventDate", nextEventDate);
        return "add-event";
    }

    @RequestMapping("/")
    public String showHomePage() {
        return "index";
    }
}
