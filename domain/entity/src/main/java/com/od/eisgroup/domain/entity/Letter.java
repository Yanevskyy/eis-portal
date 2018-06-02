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

/**
 * Entity that keep data about letters
 *
 * @author Parpalak Oleksandr
 * @since 1.1
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Letters")
public class Letter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Status status;

    @ManyToOne
    private TemplateType templateType;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        Letter letter = (Letter) o;

        if (!employee.equals(letter.employee)) { return false; }
        if (!status.equals(letter.status)) { return false; }
        return templateType.equals(letter.templateType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int result = employee.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + templateType.hashCode();
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Letter{" +
                "employee=" + employee +
                ", status=" + status +
                ", templateType=" + templateType +
                '}';
    }
}
