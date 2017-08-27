/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.manager.classes.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.EventDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Event;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.classes.AbstractManager;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.EventManager;

/**
 * The Class EventManagerImpl.
 */
@Service
public class EventManagerImpl extends AbstractManager<Event, Long> implements EventManager {

	/** The event dao. */
	@Autowired
	private EventDAO eventDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * EventManager#addPersons(java.util.List)
	 */
	@Override
	public Event addPersons(final List<Long> ids) {
		return this.getEntityDAO().addPersons(ids);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * EventManager#addPerson(java.util.List)
	 */
	@Override
	public Event addPerson(final List<Long> ids) {
		return this.getEntityDAO().addPerson(ids);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * EventManager#getByPersonId(java.lang.Long)
	 */
	@Override
	public List<Event> getByPersonId(final Long id) {
		return this.getEntityDAO().getByPersonId(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.classes.
	 * AbstractManager#getEntityDAO()
	 */
	@Override
	protected final EventDAO getEntityDAO() {
		return this.eventDao;
	}
}