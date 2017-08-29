/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces;

import java.util.Set;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Event;

/**
 * The Interface EventManager.
 */
public interface EventManager extends Manager<Event, Long> {

	/**
	 * Adds the person.
	 *
	 * @param personId
	 *            the person id
	 * @param eventId
	 *            the event id
	 * @return the event
	 */
	public Event addPerson(final Long personId, final Long eventId);

	/**
	 * Gets the by person id.
	 *
	 * @param personId
	 *            the person id
	 * @return the by person id
	 */
	public Set<Event> getByPersonId(final Long personId);
}