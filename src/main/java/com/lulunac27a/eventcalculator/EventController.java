package com.lulunac27a.eventcalculator;

import com.lulunac27a.eventcalculator.entity.Event;
import com.lulunac27a.eventcalculator.entity.Event.RepeatFrequency;
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
    public String getNextEvent(@ModelAttribute("eventInfo") Event eventInfo, Model model){
        model.addAttribute("eventInfo", eventInfo);
        LocalDate eventStartDate = eventInfo.getStartDate();
        RepeatFrequency repeatFrequency = eventInfo.getRepeatFrequency();
        int repeatOften = eventInfo.getRepeatOften();
        LocalDate nextEventDate = eventInfo.getNextEventDate(eventStartDate, repeatFrequency, repeatOften);
        model.addAttribute("nextEventDate", nextEventDate);
        return "index";
    }
    @GetMapping("add-event")
    public String createNewEvent(Model model){
        model.addAttribute("eventInfo", new Event());
        return "add-event";
    }



    @PostMapping("create-event")
    public String addEvent(@ModelAttribute("eventInfo") Event eventInfo, Model model){
        model.addAttribute("eventInfo", eventInfo);
        LocalDate nextEventDate = eventInfo.getNextEventDate(eventInfo.getStartDate(), eventInfo.getRepeatFrequency(), eventInfo.getRepeatOften());
        model.addAttribute("nextEventDate", nextEventDate);
        return "add-event";
    }
    @RequestMapping("/")
    public String showHomePage(){
        return "index";
    }
}
