package com.od.eisgroup.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Entity that keep data about employees
 *
 * @author Parpalak Oleksandr
 * @since 1.1
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;

    private String lastName;

    private Date hireDate;

    private Date birthDate;

    private String email;

    @ManyToOne
    private Location location;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        Employee employee = (Employee) o;

        if (!firstName.equals(employee.firstName)) { return false; }
        if (!lastName.equals(employee.lastName)) { return false; }
        if (!hireDate.equals(employee.hireDate)) { return false; }
        if (!birthDate.equals(employee.birthDate)) { return false; }
        if (!email.equals(employee.email)) { return false; }
        return location.equals(employee.location);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + hireDate.hashCode();
        result = 31 * result + birthDate.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + location.hashCode();
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", hireDate=" + hireDate +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", location=" + location +
                '}';
    }
}
