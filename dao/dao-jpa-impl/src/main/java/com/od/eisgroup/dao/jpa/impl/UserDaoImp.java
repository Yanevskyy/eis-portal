package com.od.eisgroup.dao.jpa.impl;

import com.od.eisgroup.dao.api.UserDAO;
import com.od.eisgroup.domain.entity.User;
import org.springframework.stereotype.Repository;

/**
 * User Data-Access Object class
 *
 * @author Ievgen Rudenko
 *
 */
@Repository
public class UserDaoImp extends AbstractJpaDao<User, Long> implements UserDAO {

    public UserDaoImp() {
        super(User.class);
    }
}
