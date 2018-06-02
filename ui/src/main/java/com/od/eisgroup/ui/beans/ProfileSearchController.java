package com.od.eisgroup.ui.beans;

import com.od.eisgroup.domain.dto.UserDTO;
import com.od.eisgroup.service.api.ViewerProfiles;
import com.od.eisgroup.ui.utils.MessageUtils;

import java.util.List;
import javax.faces.application.FacesMessage;
import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.context.annotation.SessionScope;

/**
 * Stores the text entered by the user in the search field.
 *
 * @author Yanevskyy Igor i.yanevskyy@gmail.com., Osipov Dmitriy
 * @since 2.0
 */
@Getter
@Setter
@Controller
@SessionScope
public class ProfileSearchController {
    /**
     * The text line entered by the user.
     */
    private String searchName;

    private final String notFoundMessage = "User does not exist";

    private final String emptySearchMessage = "Your search input is not allowed";

    @Autowired
    private AdminProfileController adminProfileController;

    @Autowired
    private ViewerProfiles profilesService;

    /**
     * Calls searching for users profiles and updates profiles list in AdminProfileController.
     * If there no users were found specified message will be displayed.
     *
     */
    public void searchProfiles() {
        if (StringUtils.isEmpty(searchName)) {
          MessageUtils.printMessage(emptySearchMessage, FacesMessage.SEVERITY_ERROR);
        } else {
          this.updateProfiles(profilesService.displayFoundUsers(searchName));
        }
    }

  /**
   * Updates profiles list in admin profile controller (and profiles tab)
   * @param profilesList updated list of profiles to show
   */
  private void updateProfiles(List<UserDTO> profilesList) {
        if (profilesList == null || profilesList.isEmpty()) {
            MessageUtils.printMessage(notFoundMessage, FacesMessage.SEVERITY_INFO);
        } else {
            adminProfileController.setProfiles(profilesList);
        }
    }
}

