package com.icluj;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by g on 08.03.2017.
 */
@Transactional
public interface LocationDAO extends CrudRepository < Location , Integer> {

}
