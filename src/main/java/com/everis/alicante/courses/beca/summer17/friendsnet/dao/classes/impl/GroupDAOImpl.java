/*
 * Created at 24-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.dao.classes.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.classes.AbstractDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.GroupDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Group;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Person;

/**
 * The Class GroupDAOImpl.
 */
@Service
public class GroupDAOImpl extends AbstractDAO<Group, Long> implements GroupDAO {

	/** The entity manager. */
	@Autowired
	EntityManager entityManager;

	/** The group. */
	@Autowired
	Group group;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.GroupDAO#
	 * addPersons(java.lang.Iterable)
	 */
	@Override
	public Group addPersons(Iterable<Person> persons) {
		return null;
	}
}