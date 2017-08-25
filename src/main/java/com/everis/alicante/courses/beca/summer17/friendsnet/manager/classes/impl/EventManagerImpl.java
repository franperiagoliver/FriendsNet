/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.manager.classes.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.EventDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Event;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.EventManager;

/**
 * The Class EventManagerImpl.
 */
@Service
public class EventManagerImpl implements EventManager {

	/** The event dao. */
	@Autowired
	private EventDAO eventDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * Manager#findAll()
	 */
	@Override
	public Iterable<Event> findAll() {
		return this.eventDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * Manager#findById(java.io.Serializable)
	 */
	@Override
	public Event findById(Long id) {
		return this.eventDao.findById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * Manager#findByIds(java.lang.Iterable)
	 */
	@Override
	public Iterable<Event> findByIds(Iterable<Long> ids) {
		return this.eventDao.findByIds(ids);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * Manager#save(com.everis.alicante.courses.beca.summer17.friendsnet.entity.
	 * interfaces.FNEntity)
	 */
	@Override
	public Event save(Event event) {
		return this.eventDao.save(event);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * Manager#save(java.lang.Iterable)
	 */
	@Override
	public Iterable<Event> save(Iterable<Event> events) {
		return this.eventDao.save(events);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * Manager#update(com.everis.alicante.courses.beca.summer17.friendsnet.entity.
	 * interfaces.FNEntity)
	 */
	@Override
	public Event update(Event event) {
		return this.eventDao.update(event);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * Manager#update(java.lang.Iterable)
	 */
	@Override
	public Iterable<Event> update(Iterable<Event> events) {
		return this.eventDao.update(events);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * Manager#remove(com.everis.alicante.courses.beca.summer17.friendsnet.entity.
	 * interfaces.FNEntity)
	 */
	@Override
	public void remove(Event event) {
		this.eventDao.remove(event);
	}
}