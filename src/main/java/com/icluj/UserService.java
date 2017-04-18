package com.icluj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Alexandru on 31/01/2017.
 */
@Service
public class UserService {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private UserDAO userDAO;

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
}
