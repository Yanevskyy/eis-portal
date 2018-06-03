package com.od.eisgroup.ui.beans;

import com.od.eisgroup.domain.dto.UserDTO;
import com.od.eisgroup.service.api.ViewerProfiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.util.List;
import javax.faces.event.ComponentSystemEvent;
import lombok.Getter;
import lombok.Setter;

/**
 * This is controller for the data table in the profiles tab in admin application.
 * This controller interacts with profiles service and SearchController.
 * It can return information about all profiles or specified by search parameter
 * (executed in ProfileSearchController).
 * @author Dmitriy Osipov
 * @since 1.2
 */

@Controller
@Getter
@Setter
@SessionScope
public class AdminProfileController implements Serializable {

  @Autowired
  private ViewerProfiles profilesService;

  private List<UserDTO> profiles;

  /**
   * Gets user login from email
   * @param userDTO an UserDTO object
   * @return email login or empty String if email is empty
   */
  public String getUserLogin(UserDTO userDTO) {
    if (userDTO != null && !StringUtils.isEmpty(userDTO.getEmail())) {
      return (userDTO.getEmail().contains("@")) ?
          userDTO.getEmail().substring(0, userDTO.getEmail().lastIndexOf('@')) : userDTO.getEmail();
    } else {
      return "";
    }
  }

  private void loadProfiles() {
    this.profiles = profilesService.displayAllUsers();
  }

  public void adminFormRenderEventListener(ComponentSystemEvent event) {
    this.loadProfiles();
  }
}
