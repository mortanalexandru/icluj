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

    public void saveUser(User user){
        userDAO.save(user);
    }
}
