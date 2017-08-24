/*
 * Created at 24-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.manager;

import java.io.Serializable;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.FNEntity;

/**
 * The Interface Manager.
 *
 * @param <E> the element type
 * @param <ID> the generic type
 */
public interface Manager<E extends FNEntity, ID extends Serializable> {
	
	/**
	 * Find all.
	 *
	 * @return the iterable
	 */
	Iterable<E> findAll();
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the e
	 */
	E findById(final ID id);
	
	/**
	 * Save.
	 *
	 * @param id the id
	 * @return the e
	 */
	Iterable<E> findByIds(final Iterable<ID> id);
	
	/**
	 * Save.
	 *
	 * @param e the e
	 * @return the e
	 */
	E save(final E e);
	
	/**
	 * Save.
	 *
	 * @param es the es
	 * @return the iterable
	 */
	Iterable<E> save(final Iterable<E> es);
	
	/**
	 * Update.
	 *
	 * @param e the e
	 * @return the e
	 */
	E update(final E e);
	
	/**
	 * Update.
	 *
	 * @param es the es
	 * @return the iterable
	 */
	Iterable<E> update(final Iterable<E> es) ;
	
	/**
	 * Removes the.
	 *
	 * @param id the e
	 */
	void remove(final ID id);
}