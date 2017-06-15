package com.icluj.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventPageController {
	@RequestMapping("/event")
	public String getEventPage(){
		return "event_page";
	}
		

}
