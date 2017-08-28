/*
 * Created at 24-ago-2017 by Fran Periago
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.manager.classes.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.PersonDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.classes.AbstractManager;
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
	public Person relatePersons(final Long personId, final Long newFriendId) {
		final Person person = this.getEntityDAO().findById(personId);
		final Person friend = this.getEntityDAO().findById(newFriendId);
		person.getFriends().add(friend);
		friend.getFriends().add(person);
		return this.getEntityDAO().save(friend);
	}

	@Override
	protected final PersonDAO getEntityDAO() {
		return this.personDao;
	}
}