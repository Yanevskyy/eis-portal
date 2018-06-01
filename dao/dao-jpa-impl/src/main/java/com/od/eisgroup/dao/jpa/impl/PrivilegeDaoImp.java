package com.od.eisgroup.dao.jpa.impl;

import com.od.eisgroup.domain.entity.Privilege;
import org.springframework.stereotype.Repository;

/**
 * Privilege Data-Access Object class
 *
 * @author Ievgen Rudenko
 *
 */
@Repository
public class PrivilegeDaoImp extends AbstractJpaDao<Privilege, Long>  {

    public PrivilegeDaoImp() {
        super(Privilege.class);
    }
}
