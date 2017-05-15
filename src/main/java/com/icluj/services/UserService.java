package com.icluj.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.icluj.json.UserJSON;
import com.icluj.models.Event;
import com.icluj.models.User;
import com.icluj.repositories.EventDAO;
import com.icluj.repositories.UserDAO;

/**
 * Created by Alexandru on 31/01/2017.
 */
@Service
public class UserService {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private EventDAO eventDAO;

    public void saveUser(UserJSON userJSON){
        User user = new User();
        user.setEmail(userJSON.getEmail());
        user.setPassword(userJSON.getPassword());
        user.setNickname(userJSON.getNickname());
        userDAO.save(user);
    }
    public boolean login(UserJSON userJSON){
        User userDB=userDAO.findOne(userJSON.getEmail());
        if(userDB!=null){
            String passwordDB = userDB.getPassword();
            String passwordJson = userJSON.getPassword();
            if(passwordJson.equals(passwordDB)) {
                return true;
            }
        }
        return false;
    }
    public User getUser( String email ){
    	return userDAO.findOne(email);
    }
    public boolean claimEvent(String email, Integer eventId){
    	User user=getUser(email);
    	Event event=eventDAO.findOne(eventId);
    	user.getEvents().add(event);
    	user.setiCoins(event.getiCoins()+user.getiCoins());
    	userDAO.save(user);
		return true;
    	
    }
}
