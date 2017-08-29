/*
 * Created at 24-ago-2017 by Fran Periago
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.interfaces.FNEntity;

/**
 * The Interface EntityDAO.
 *
 * @param <E>
 *            the element type
 * @param <ID>
 *            the generic type
 */
@Service
public interface EntityDAO<E extends FNEntity, ID extends Serializable> {

	/**
	 * Find all.
	 *
	 * @return the iterable
	 */
	Iterable<E> findAll();

	/**
	 * Find by id.
	 *
	 * @param id
	 *            the id
	 * @return the e
	 */
	E findOne(ID id);

	/**
	 * Save.
	 *
	 * @param ids
	 *            the ids
	 * @return the e
	 */
	Iterable<E> findAll(Iterable<ID> ids);

	/**
	 * Save.
	 *
	 * @param e
	 *            the e
	 * @return the e
	 */
	<S extends E> S save(S entity);

	/**
	 * Save.
	 *
	 * @param es
	 *            the es
	 * @return the iterable
	 */
	<S extends E> Iterable<S> save(Iterable<S> es);

	/**
	 * Removes the.
	 *
	 * @param e
	 *            the e
	 */
	void delete(E e);
}