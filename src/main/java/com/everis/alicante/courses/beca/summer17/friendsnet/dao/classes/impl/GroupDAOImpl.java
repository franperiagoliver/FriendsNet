/*
 * Created at 24-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.dao.classes.impl;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.classes.AbstractDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.GroupDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Group;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Person;

/**
 * The Class GroupDAOImpl.
 */
public class GroupDAOImpl extends AbstractDAO<Group, Long> implements GroupDAO {

	/* (non-Javadoc)
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.GroupDAO#addPersons(java.lang.Iterable)
	 */
	@Override
	public Group addPersons(Iterable<Person> persons) {
		return null;
	}
}