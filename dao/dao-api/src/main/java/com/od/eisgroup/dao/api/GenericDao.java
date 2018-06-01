package com.od.eisgroup.dao.api;

import java.util.List;

/**
 * Interface for a Data Access Object that can be used for a single specified
 * type domain object. A single instance implementing this interface can be used
 * only for the type of domain object specified in the type parameters.
 *
 * @author Ievgen Rudenko
 *
 * @param <E>
 *            The type of the domain object for which this instance is to be
 *            used.
 * @param <K>
 *            The type of the id of the domain object for which this instance is
 *            to be used.
 */
public interface GenericDao<E,K> {

    /**
     Make an instance managed and persistent.
     */
    void persist(E entity);

    /**
     Merge the state of the given entity into the current persistence context.
     */
    void update(E entity);

    /**
     * Get the entity with the specified type and id from the datastore.
     */
    E findById(K id);

    /**
     * Get all entities of the specified type from the datastore.
     */
    List<E> findAll();

    /**
     * Remove the specified entity from the datastore.
     */
    void delete(E entity);

    /**
     *  Remove the entity with the specified type and id from the datastore.
     */
    void deleteById(K entityId);

}

