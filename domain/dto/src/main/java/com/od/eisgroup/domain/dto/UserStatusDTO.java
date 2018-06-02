package com.od.eisgroup.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Yanevskyy Igor i.yanevskyy@gmail.com.
 * @version 1.1
 */
@Getter
@AllArgsConstructor
public enum  UserStatusDTO {
    /**
     * "not available" users who can't do something in the system
     */
    NOT_AVAILABLE("Not available"),

    /**
     * Simple users to whom actions are available
     */
    AVAILABLE("Available");

    private final String value;
}
