package com.icluj.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.icluj.models.Location;

/**
 * Created by g on 08.03.2017.
 */
@Transactional
public interface LocationDAO extends CrudRepository < Location , Integer> {

}
