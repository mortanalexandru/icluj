package com.icluj.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.icluj.models.User;

/**
 * Created by Alexandru on 31/01/2017.
 */
@Transactional
@Repository
public interface UserDAO extends CrudRepository<User, String> {

    public User findByEmail(String email);
}
