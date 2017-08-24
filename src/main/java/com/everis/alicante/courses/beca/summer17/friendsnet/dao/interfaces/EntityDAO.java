/*
 * Created at 24-ago-2017 by Fran Periago
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces;

public interface EntityDAO<E, ID> {

	Iterable<E> findAll();

	/**
	 * Find by id.
	 *
	 * @return the e
	 */
	E findById(ID id);

	void save(E e);

	void save(Iterable<E> es);

	void update(E e);

	/**
	 * Update.
	 *
	 * @param es the es
	 */
	void update(Iterable<E> es);

	/**
	 * Removes the.
	 *
	 * @param e the e
	 */
	void remove(E e);
}
