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
 * Entity that keep data about locations
 *
 * @author Parpalak Oleksandr
 * @since 1.1
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String cityName;

    @ManyToOne
    private Country country;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        Location location = (Location) o;

        if (!cityName.equals(location.cityName)) { return false; }
        return country.equals(location.country);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int result = cityName.hashCode();
        result = 31 * result + country.hashCode();
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Location{" +
                "cityName='" + cityName + '\'' +
                ", country=" + country +
                '}';
    }
}
