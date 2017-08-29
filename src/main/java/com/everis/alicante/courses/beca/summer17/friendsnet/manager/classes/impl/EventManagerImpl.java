/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.manager.classes.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.EventDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.PersonDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Event;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Person;
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

	/** The person dao. */
	@Autowired
	private PersonDAO personDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * EventManager#addPerson(java.lang.Long, java.lang.Long)
	 */
	@Override
	public Event addPerson(Long personId, Long eventId) {
		final Person person = this.personDao.findById(personId);
		final Event event = this.getEntityDAO().findById(eventId);
		event.setPersonInEvent(person);
		return this.getEntityDAO().save(event);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * EventManager#getByPersonId(java.lang.Long)
	 */
	@Override
	public Set<Event> getByPersonId(Long personId) {
		final Person person = this.personDao.findById(personId);
		return person.getEvents();
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