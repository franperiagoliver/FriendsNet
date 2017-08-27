/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces;

import java.util.List;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Event;

/**
 * The Interface EventDAO.
 */
public interface EventDAO extends EntityDAO<Event, Long> {

	/**
	 * Adds the persons.
	 *
	 * @param ids
	 *            the ids
	 * @return the event
	 */
	public Event addPersons(final List<Long> ids);

	/**
	 * Adds the person.
	 *
	 * @param ids
	 *            the ids
	 * @return the event
	 */
	public Event addPerson(final List<Long> ids);

	/**
	 * Gets the by person id.
	 *
	 * @param id
	 *            the id
	 * @return the by person id
	 */
	public List<Event> getByPersonId(final Long id);
}