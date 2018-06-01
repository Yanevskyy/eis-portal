package com.od.eisgroup.dao.jpa.impl;

import com.od.eisgroup.dao.api.GenericDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Abstract Data-Access Object class to be implemented by all DAO's.
 *
 * @author Ievgen Rudenko
 *
 */
public abstract class AbstractJpaDao<E,K> implements GenericDao<E,K> {

    private final Class<E> clazz;

    @PersistenceContext
    private EntityManager entityManager;

    public AbstractJpaDao(Class<E> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void persist(E entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(E entity) {
        entityManager.merge(entity);
    }

    @Override
    public E findById(K id) {
        return entityManager.find(clazz, id);
    }

    @Override
    public List<E> findAll() {
        return entityManager.createQuery( "from " + clazz.getName() )
                .getResultList();
    }

    @Override
    public void delete(E entity) {
        entityManager.remove(entity);
    }

    @Override
    public void deleteById(K entityId) {
        delete(findById(entityId));
    }
}
