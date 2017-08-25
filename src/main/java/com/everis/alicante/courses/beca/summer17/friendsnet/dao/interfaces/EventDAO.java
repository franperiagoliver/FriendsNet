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
	
	public Event addPersons(final List<Long> ids);
	
	public Event addPerson(final List<Long> ids);
	
	public List<Event> getByPersonId(final Long id);
}