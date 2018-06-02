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
 * Entity that keep data about template types
 *
 * @author Parpalak Oleksandr
 * @since 1.1
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TemplateTypes")
public class TemplateType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String templateName;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        TemplateType that = (TemplateType) o;

        return templateName.equals(that.templateName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return templateName.hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "TemplateType{" +
                "templateName='" + templateName + '\'' +
                '}';
    }
}
