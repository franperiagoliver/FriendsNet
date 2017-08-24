/*
 * Created at 24-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.manager;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;

/**
 * The Interface Manager.
 *
 * @param <E> the element type
 */
public interface Manager<E> {
	
	/**
	 * Find all.
	 *
	 * @return the iterable
	 */
	Iterable<E> findAll();
	
	/**
	 * Find by id.
	 *
	 * @param e the e
	 * @return the e
	 */
	E findById(final Long id);
	
	/**
	 * Save.
	 *
	 * @param e the e
	 * @return 
	 */
	E save(final E e);
	
	/**
	 * Save.
	 *
	 * @param es the es
	 */
	void save(final Iterable<E> es);
	
	/**
	 * Update.
	 *
	 * @param e the e
	 */
	void update(final E e);
	
	/**
	 * Update.
	 *
	 * @param es the es
	 */
	void update(final Iterable<E> es) ;
	
	/**
	 * Removes the.
	 *
	 * @param e the e
	 */
	void remove(final E e);
}
