/*
 * Created at 24-ago-2017 by Fran Periago
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.dao.classes.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.classes.AbstractDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.PersonDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Person;

/**
 * The Class PersonDAOImpl.
 */
@Service
public class PersonDAOImpl extends AbstractDAO<Person, Long> implements PersonDAO {

	/** The person dao. */
	@Autowired
	private PersonDAO personDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.PersonDAO
	 * #relatePersons(java.lang.Long, java.lang.Iterable)
	 */
	@Override
	public Person relatePersons(final Long personId, final Iterable<Long> newFriendsIds) {
		Person person = personDao.findById(personId);
		Set<Person> friends = (Set<Person>) personDao.findByIds(newFriendsIds);
		person.getFriends().addAll(friends);
		return person;
	}
}