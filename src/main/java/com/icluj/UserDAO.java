package com.icluj;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Alexandru on 31/01/2017.
 */
@Transactional
public interface UserDAO extends CrudRepository<User, String> {

    public User findByEmail(String email);
}
