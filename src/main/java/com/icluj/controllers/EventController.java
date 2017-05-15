package com.icluj.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.icluj.json.EventJSON;
import com.icluj.services.EventService;
import com.icluj.services.UserService;

@RestController
public class EventController {

	@Autowired
	private EventService eventService;
	@Autowired
	private UserService userService;
	
	
    @RequestMapping("/getEvents")
    public List<EventJSON> getEvents() {
       return eventService.getEvents();
    }
    
    
    @RequestMapping("/getEvent")
    public EventJSON getEvent(@RequestParam(name="id") Integer id){
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	String currentPrincipalName = authentication.getName();
    	EventJSON eventJSON=eventService.getEventForUser(id, currentPrincipalName);
		return eventJSON;
    }
    
    @RequestMapping("/claimEvent")
    public boolean claimEvent(@RequestBody Integer id){
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	String currentPrincipalName = authentication.getName();
    	EventJSON eventJSON=eventService.getEventForUser(id, currentPrincipalName);
    	if(!eventJSON.isAttended()){
    		return userService.claimEvent("sergiu@yahoo.com", id);
    	}
    	return false;
    }
    
    
    
}

