package com.od.eisgroup.domain.dto;

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
    private UserStatusDTO userStatusDTO;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(firstName, userDTO.firstName) &&
                Objects.equals(lastName, userDTO.lastName) &&
                Objects.equals(email, userDTO.email) &&
                Objects.equals(role, userDTO.role) &&
                userStatusDTO == userDTO.userStatusDTO;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, role, userStatusDTO);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", userStatusDTO=" + userStatusDTO +
                '}';
    }
}
