/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.manager;

import java.util.Set;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Event;

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
	Event addPerson(final Long personId, final Long eventId);

	/**
	 * Gets the by person id.
	 *
	 * @param personId
	 *            the person id
	 * @return the by person id
	 */
	Set<Event> getByPersonId(final Long personId);
}