/*
 * Created at 24-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces;

import java.io.Serializable;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.interfaces.FNEntity;

/**
 * The Interface Manager.
 *
 * @param <E>
 *            the element type
 * @param <ID>
 *            the generic type
 */
public interface Manager<E extends FNEntity, ID extends Serializable> {

	/**
	 * Find all.
	 *
	 * @return the iterable
	 */
	public Iterable<E> findAll();

	/**
	 * Find by id.
	 *
	 * @param id
	 *            the id
	 * @return the e
	 */
	public E findById(final ID id);

	/**
	 * Save.
	 *
	 * @param ids
	 *            the ids
	 * @return the e
	 */
	public Iterable<E> findByIds(final Iterable<ID> ids);

	/**
	 * Save.
	 *
	 * @param e
	 *            the e
	 * @return the e
	 */
	public E save(final E e);

	/**
	 * Save.
	 *
	 * @param es
	 *            the es
	 * @return the iterable
	 */
	public Iterable<E> save(final Iterable<E> es);

	/**
	 * Update.
	 *
	 * @param e
	 *            the e
	 * @return the e
	 */
	public E update(final E e);

	/**
	 * Update.
	 *
	 * @param es
	 *            the es
	 * @return the iterable
	 */
	public Iterable<E> update(final Iterable<E> es);

	/**
	 * Removes the.
	 *
	 * @param e
	 *            the e
	 */
	public void remove(final E e);
}