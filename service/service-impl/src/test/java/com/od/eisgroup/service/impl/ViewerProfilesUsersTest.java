package com.od.eisgroup.service.impl;

import com.od.eisgroup.dao.api.UserDAO;
import com.od.eisgroup.dao.jpa.impl.UserDaoImp;
import com.od.eisgroup.domain.dto.UserDTO;
import org.junit.Assert;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Yanevskyy Igor i.yanevskyy@gmail.com.
 */
public class ViewerProfilesUsersTest {
    private UserDAO userDao = mock( UserDaoImp.class );
    private ViewerProfilesUsers viewerProfiles = new ViewerProfilesUsers();
    private UsersCreator usersCreator = new UsersCreator();


    @Test
    public void displayAllUsers() throws Exception {
        viewerProfiles.setUserDao(userDao);
        viewerProfiles.setModelMapper(new ModelMapper());
        when(userDao.findAll()).thenReturn( usersCreator.getUsers() );
        List<UserDTO> usersDTOResult = viewerProfiles.displayAllUsers();
        for (int i = 0; i < usersDTOResult.size(); i++) {
            Assert.assertEquals(usersCreator.getUsersDTO().get(i).getId(), usersDTOResult.get(i).getId());
        }
    }

}