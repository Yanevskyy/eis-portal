package com.od.eisgroup.service.impl;

import com.od.eisgroup.dao.api.RoleDAO;
import com.od.eisgroup.domain.dto.RoleDTO;
import com.od.eisgroup.domain.entity.Role;
import com.od.eisgroup.service.api.RoleService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service which implements {@link com.od.eisgroup.service.api.RoleService} to work with Role entities
 * and RoleDTOs.
 *
 * @author Alice Klochkova
 * @since 1.1
 */

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
    /**
     * {@link org.modelmapper.ModelMapper} helps to convert Entity to DTO and vice versa.
     */
    @Autowired
    private ModelMapper modelMapper;

    /**
     * {@link com.od.eisgroup.dao.api.RoleDAO} bean to work with JPA Entities.
     */
    @Autowired
    private RoleDAO roleDAO;

    /**
     * Method implemented from {@link com.od.eisgroup.service.api.RoleService} to get all Roles
     * and convert to RoleDROs
     */
    public List<RoleDTO> findAll() {
        logger.debug("Searching for all Roles in database.");
        List<Role> roles = roleDAO.findAll();
        return roles.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Method to convert Role Entity to RoleDTO via {@link org.modelmapper.ModelMapper}
     */
    private RoleDTO convertToDTO(Role role) {
        logger.debug("Converting {} to DTO.", role);
        return modelMapper.map(role, RoleDTO.class);
    }

}
