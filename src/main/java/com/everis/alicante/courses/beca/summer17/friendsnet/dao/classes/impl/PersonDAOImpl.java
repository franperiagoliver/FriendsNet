/*
 * Created at 24-ago-2017 by Fran Periago
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.dao.classes.impl;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.classes.AbstractDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.PersonDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;

/**
 * The Class PersonDAOImpl.
 */
public class PersonDAOImpl extends AbstractDAO<Person, Long> implements PersonDAO {
	
	/* (non-Javadoc)
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.PersonDAO#relatePersons(java.lang.Iterable)
	 */
	@Override
	public Person relatePersons(Iterable<Person> person) {

		return null;
	}

}
