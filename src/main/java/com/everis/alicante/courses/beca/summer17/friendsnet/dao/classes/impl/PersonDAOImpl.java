/*
 * Created at 24-ago-2017 by Fran Periago
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.dao.classes.impl;

import javax.persistence.EntityManager;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.PersonDAO
	 * #relatePersons(java.lang.Long, java.lang.Iterable)
	 */
	@Override
	public Person relatePersons(final Long personId, final Iterable<Long> ids) {
		return null;
	}
}