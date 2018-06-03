package com.od.eisgroup.dao.api;

import com.od.eisgroup.domain.entity.User;

/**
 * Interface to be implemented by DAOs that wish
 * to work with JPA User entity.
 *
 * @author Dmitriy Osipov
 * @since 1.2
 */
public interface UserDAO extends GenericDao<User, Long> {

}
