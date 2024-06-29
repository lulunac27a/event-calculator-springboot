package com.lulunac27a.eventcalculator;

import com.lulunac27a.eventcalculator.entity.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
public class EventController {
    @GetMapping("/")
    public String getNextEvent(Model model) {
        Event eventInfo = new Event();
        model.addAttribute("eventInfo", eventInfo);
        LocalDate nextEventDate = eventInfo.getNextEventDate(eventInfo.getStartDate(), eventInfo.getRepeatInterval(),
                eventInfo.getRepeatOften());
        model.addAttribute("nextEventDate", nextEventDate);
        return "index";
    }

    @PostMapping("create-event")
    public String addEvent(@ModelAttribute("eventInfo") Event eventInfo, Model model) {
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
