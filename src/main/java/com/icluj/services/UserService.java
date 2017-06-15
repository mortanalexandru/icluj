package com.icluj.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icluj.json.DateJSON;
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

	public void saveUser(UserJSON userJSON) {
		User user = new User();
		user.setEmail(userJSON.getEmail());
		user.setPassword(userJSON.getPassword());
		user.setNickname(userJSON.getNickname());
		user.setImageUrl(userJSON.getImage());
		try {
			user.setDate_of_birth(adaptDate(userJSON.getDob()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		userDAO.save(user);
	}

	private Date adaptDate(DateJSON date) throws ParseException {
		String startDateString = date.getDay() + "/" + date.getMonth() + "/" + date.getYear();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		return df.parse(startDateString);
	}

	public boolean login(UserJSON userJSON) {
		User userDB = userDAO.findOne(userJSON.getEmail());
		if (userDB != null) {
			String passwordDB = userDB.getPassword();
			String passwordJson = userJSON.getPassword();
			if (passwordJson.equals(passwordDB)) {
				return true;
			}
		}
		return false;
	}

	public User getUser(String email) {
		return userDAO.findOne(email);
	}

	public boolean claimEvent(String email, Integer eventId) {
		User user = getUser(email);
		Event event = eventDAO.findOne(eventId);
		user.getEvents().add(event);
		user.setiCoins(event.getiCoins() + user.getiCoins());
		userDAO.save(user);
		return true;

	}
}
