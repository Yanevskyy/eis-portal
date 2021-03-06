package com.od.eisgroup.dao.jpa.impl;

import com.od.eisgroup.dao.api.RoleDAO;
import com.od.eisgroup.domain.entity.Role;
import org.springframework.stereotype.Repository;

/**
 * Role Data-Access Object class
 *
 * @author Ievgen Rudenko
 *
 */
@Repository
public class RoleDaoImp extends AbstractJpaDao<Role, Long> implements RoleDAO {

    public RoleDaoImp() {
        super(Role.class);
    }
}
