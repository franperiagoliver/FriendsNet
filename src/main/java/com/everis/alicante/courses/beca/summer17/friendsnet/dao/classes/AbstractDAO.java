/*
 * Created at 24-ago-2017 by Fran Periago
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.dao.classes;

import java.io.Serializable;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.EntityDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.FNEntity;

/**
 * The Class AbstractDAO.
 *
 * @param <E> the element type
 * @param <ID> the generic type
 */
public abstract class AbstractDAO<E extends FNEntity, ID extends Serializable> implements EntityDAO<E, ID> {

	/** The persistent class. */
	private Class<E> persistentClass;
	
	/**
	 * Instantiates a new abstract DAO.
	 */
	@SuppressWarnings("unchecked")
	public AbstractDAO() {
		this.persistentClass = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];		
	}
	
	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Gets the entity manager.
	 *
	 * @return the entity manager
	 */
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	/* (non-Javadoc)
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.EntityDAO#findAll()
	 */
	public Iterable<E> findAll() {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<E> cq = cb.createQuery(this.persistentClass);
		Root<E> rootEntry = cq.from(this.persistentClass);
		CriteriaQuery<E> all = cq.select(rootEntry);
		TypedQuery<E> allQuery = this.entityManager.createQuery(all);
		return allQuery.getResultList();
	}

	/* (non-Javadoc)
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.EntityDAO#findById(java.io.Serializable)
	 */
	public E findById(final ID id) {
		return entityManager.find(persistentClass, id);
	}
	
	/* (non-Javadoc)
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.EntityDAO#findByIds(java.lang.Iterable)
	 */
	public Iterable<E> findByIds(final Iterable<ID> ids) {
		return (Iterable<E>) entityManager.find(persistentClass, ids);
		
	}

	/* (non-Javadoc)
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.EntityDAO#save(com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.FNEntity)
	 */
	public E save(final E e) {
		entityManager.persist(e);
		return e;
	}

	/* (non-Javadoc)
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.EntityDAO#save(java.lang.Iterable)
	 */
	public Iterable<E> save(final Iterable<E> es) {
		entityManager.persist(es);
		return es;
	}

	/* (non-Javadoc)
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.EntityDAO#update(java.lang.Object)
	 */
	public E update(final E e) {
		return entityManager.merge(e);
	}

	/* (non-Javadoc)
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.EntityDAO#update(java.lang.Iterable)
	 */
	public Iterable<E> update(final Iterable<E> es) {
		return entityManager.merge(es);
	}

	/* (non-Javadoc)
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.EntityDAO#remove(java.io.Serializable)
	 */
	public void remove(final ID id) {
		entityManager.remove(id);
	}

}