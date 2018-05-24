package com.od.eisgroup.ui.beans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

/**
 * Stores the text entered by the user in the search field.
 *
 * @author Yanevskyy Igor i.yanevskyy@gmail.com.
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
}

