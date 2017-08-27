/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.dao.classes.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.classes.AbstractDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.EventDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Event;

/**
 * The Class EventDAOImpl.
 */
@Service
public class EventDAOImpl extends AbstractDAO<Event, Long> implements EventDAO {

	private List<Event> listEvents = new ArrayList<>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.EventDAO#
	 * getByPersonId(java.lang.Long)
	 */
	@Override
	public List<Event> getByPersonId(final Long id) {
		return listEvents;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.EventDAO#
	 * addPersons(java.util.List)
	 */
	@Override
	public Event addPersons(final List<Long> ids) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.EventDAO#
	 * addPerson(java.util.List)
	 */
	@Override
	public Event addPerson(List<Long> ids) {
		return null;
	}
}