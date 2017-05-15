package com.icluj.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.icluj.models.Event;

/**
 * Created by g on 22.03.2017.
 */
@Repository
public interface EventDAO extends CrudRepository< Event , Integer> {
}
