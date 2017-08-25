/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.manager.classes.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.EntityDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.EventDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Event;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.EventManager;

/**
 * The Class EventManagerImpl.
 */
@Service
public class EventManagerImpl extends AbstractManager<Event, Long> implements EventManager {

	/** The event dao. */
	@Autowired
	private EventDAO eventDao;

	@Override
	public EntityDAO<Event, Long> getEntityDAO() {
		return this.eventDao;
	}

	@Override
	public Event addPersons(List<Long> ids) {
		return this.eventDao.addPersons(ids);
	}

	@Override
	public Event addPerson(final List<Long> ids) {
		return this.eventDao.addPerson(ids);
	}

	@Override
	public List<Event> getByPersonId(Long id) {
		return this.eventDao.getByPersonId(id);
	}
}