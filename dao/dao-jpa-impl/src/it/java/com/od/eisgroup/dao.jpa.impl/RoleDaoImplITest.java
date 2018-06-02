package com.od.eisgroup.dao.jpa.impl;

import com.od.eisgroup.dao.api.RoleDAO;
import com.od.eisgroup.domain.entity.Role;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/dao-jpa-impl-spring-context.xml")
public class RoleDaoImplITest {

    @Autowired
    private RoleDAO roleDAO;

    @Test
    public void read() {
        Role role = new Role();
        role.setName("User");
        roleDAO.persist(role);
        Role newRole = roleDAO.findById(role.getId());
        assertEquals(role, newRole);
    }

    @Test
    public void update() {
        Role role = new Role();
        role.setName("User");
        roleDAO.persist(role);

        Role newRole = new Role();
        newRole.setId(role.getId());
        newRole.setName("New User");
        roleDAO.update(newRole);

        Role dbRole = roleDAO.findById(role.getId());
        assertEquals(role, dbRole);
    }

    @Test
    public void findAll() {
        Role role = new Role();
        role.setName("User");
        roleDAO.persist(role);
        List<Role> roles = roleDAO.findAll();
        assertFalse(roles.isEmpty());
    }

    @Test
    public void remove() {
        Role role = new Role();
        role.setName("User");
        roleDAO.persist(role);
        roleDAO.delete(role);

        List<Role> roles = roleDAO.findAll();
        assertTrue(roles.isEmpty());
    }
}