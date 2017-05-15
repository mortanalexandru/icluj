package com.icluj.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.icluj.models.Color;

/**
 * Created by g on 22.03.2017.
 */
@Transactional
public interface ColorDAO extends CrudRepository < Color , Integer> {
}
