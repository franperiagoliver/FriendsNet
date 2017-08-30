/*
 * Created at 24-ago-2017 by Fran Periago
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.PersonDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.AbstractManager;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.PersonManager;

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
	public Person relatePersons(final Long personId, final Long newFriendId) {
		final Person person = this.getEntityDAO().findOne(personId);
		final Person friend = this.getEntityDAO().findOne(newFriendId);
		person.getFriends().add(friend);
		friend.getFriends().add(person);
		return this.getEntityDAO().save(friend);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.classes.
	 * AbstractManager#getEntityDAO()
	 */
	@Override
	protected final PersonDAO getEntityDAO() {
		return this.personDao;
	}
}