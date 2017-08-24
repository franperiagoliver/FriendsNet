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
	E findById(final ID id);

	void save(final E e);

	void save(final Iterable<E> es);

	void update(final E e);

	/**
	 * Update.
	 *
	 * @param es the es
	 */
	void update(final Iterable<E> es);

	/**
	 * Removes the.
	 *
	 * @param e the e
	 */
	void remove(final E e);
}
