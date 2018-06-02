package com.od.eisgroup.service.impl;

import com.od.eisgroup.service.impl.configuration.ServiceConfig;
import com.od.eisgroup.dao.api.RoleDAO;
import com.od.eisgroup.domain.dto.RoleDTO;
import com.od.eisgroup.domain.entity.Role;
import com.od.eisgroup.service.api.RoleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServiceConfig.class, TestConfig.class})
public class RoleServiceImplTest {

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private RoleService roleService;

    @Test
    public void findAll() {
        Role role = mock(Role.class);
        when(role.getName()).thenReturn("User");
        when(roleDAO.findAll()).thenReturn(Collections.singletonList(role));
        List<RoleDTO> roleDTOS = roleService.findAll();
        RoleDTO roleDTO = roleDTOS.get(0);

        Assert.assertEquals(roleDTO.getName(), role.getName());
    }
}