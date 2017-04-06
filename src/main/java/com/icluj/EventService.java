package com.icluj;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
	@SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private EventDAO eventDAO;
	
	public List<EventJSON> getEvents(){
		List<EventJSON> events = new ArrayList<EventJSON>(); 
		for(Event event : eventDAO.findAll()){
			events.add(adaptEvent(event));
		}
		return events;
		
	}
	
	private EventJSON adaptEvent(Event event){
		EventJSON eventJSON = new EventJSON();
		eventJSON.setName(event.getName());
		eventJSON.setDescription(event.getDescription());
		eventJSON.setLocation(event.getLocation());
		eventJSON.setiCoins(event.getiCoins());
		eventJSON.setImageUrl(event.getImageUrl());
		eventJSON.setColor(event.getColor().getColor());
		return eventJSON;
	}
	
	
	
	public EventJSON getEvent(Integer id){
		Event event = eventDAO.findOne(id);
		EventJSON eventJSON=adaptEvent(event);
		return eventJSON;
	}
}
