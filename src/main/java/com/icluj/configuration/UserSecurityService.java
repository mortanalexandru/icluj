package com.icluj.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.icluj.models.User;
import com.icluj.repositories.UserDAO;

@Repository
public class UserSecurityService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;
    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDAO.findByEmail(username);
		UserDetails userDetails = new UserSession(user);
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		return userDetails;
	}

}
