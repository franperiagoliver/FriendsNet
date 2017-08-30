/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.manager.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.EventDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.dao.PersonDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Event;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.AbstractManager;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.EventManager;

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
	public Event addPersons(final List<Long> personsId, final Long eventId) {
		final Set<Person> persons = (Set<Person>) this.personDao.findAll(personsId);
		final Event event = this.getEntityDAO().findOne(eventId);
		event.getPersonsInEvent().addAll(persons);
		return this.getEntityDAO().save(event);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * EventManager#getByPersonId(java.lang.Long)
	 */
	@Override
	@Query("SELECT")
	public Set<Event> getByPersonId(Long personId) {
		final Person person = this.personDao.findOne(personId);
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