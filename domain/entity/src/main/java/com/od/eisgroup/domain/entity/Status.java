package com.od.eisgroup.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Entity that keep data about statuses
 *
 * @author Parpalak Oleksandr
 * @since 1.1
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Statuses")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String statusName;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        Status status = (Status) o;

        return statusName.equals(status.statusName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return statusName.hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Status{" +
                "statusName='" + statusName + '\'' +
                '}';
    }
}
