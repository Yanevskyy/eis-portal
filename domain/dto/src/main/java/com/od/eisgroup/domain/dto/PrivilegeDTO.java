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
public class PrivilegeDTO implements Serializable {
    private static final long serialVersionUID = 2L;

    private Long id;
    @Size(max = 255)
    @NotNull
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PrivilegeDTO)) {
            return false;
        }
        PrivilegeDTO that = (PrivilegeDTO) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "PrivilegeDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
