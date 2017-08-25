/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.dao.classes.impl;

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
	
	@Override
	public List<Event> getByPersonId(final Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event addPersons(final List<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event addPerson(List<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

}