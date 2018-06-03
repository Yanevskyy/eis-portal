package com.od.eisgroup.domain.dto;

import com.od.eisgroup.domain.entity.UserStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 3L;

    private Long id;
    @Size(max = 30)
    private String firstName;
    @Size(max = 30)
    private String lastName;
    @NotNull
    @Size(max = 50)
    private String email;
    @NotNull
    private RoleDTO role;
    @NotNull
    private UserStatus status;

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof UserDTO)) {
        return false;
      }
      UserDTO userDTO = (UserDTO) o;
      return Objects.equals(email, userDTO.email);
    }

    @Override
    public int hashCode() {
      return Objects.hash(email);
    }

    @Override
    public String toString() {
      return "UserDTO{" +
          "firstName='" + firstName + '\'' +
          ", lastName='" + lastName + '\'' +
          ", email='" + email + '\'' +
          ", status='" + status + '\'' +
          ", role=" + role +
          '}';
    }
}
