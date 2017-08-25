/*
 * Created at 24-ago-2017 by Fran Periago
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.manager.classes.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.EntityDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.PersonDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.PersonManager;

/**
 * The Class PersonManager.
 */
@Service
public class PersonManagerImpl extends AbstractManager<Person, Long> implements PersonManager {

	/** The person dao. */
	@Autowired
	private PersonDAO personDao;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.everis.alicante.courses.beca.summer17.friendsnet.manager.PersonManager#
	 * relatePersons(java.lang.Long, java.lang.Iterable)
	 */
	@Override
	public Person relatePersons(final Long personId, final Iterable<Long> ids) {
		return this.personDao.relatePersons(personId, ids);
	}

	@Override
	public EntityDAO<Person, Long> getEntityDAO() {
		return this.personDao;
	}
}