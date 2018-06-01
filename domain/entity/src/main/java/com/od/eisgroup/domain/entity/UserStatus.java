package com.od.eisgroup.domain.entity;

/**
 * An enum for user status in {@link com.od.eisgroup.domain.entity.User} entity
 *
 * @author Dmitriy Osipov
 * @since 1.1
 */

public enum UserStatus {
  /**
   * "not available" users who can't do something in the system
   */
  NOT_AVAILABLE,

  /**
   * Simple users to whom actions are available
   */
  AVAILABLE
}
