package com.icluj;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

	@Autowired
	private EventService eventService;
	
    @RequestMapping("/getEvents")
    public List<EventJSON> getEvents() {
       return eventService.getEvents();
    }
    
    
    @RequestMapping("/getEvent")
    public EventJSON getEvent(@RequestParam(name="id") Integer id){
    	EventJSON eventJSON=eventService.getEventForUser(id, "sergiu@yahoo.com");
		return eventJSON;
    }
    
    
    
    
}

