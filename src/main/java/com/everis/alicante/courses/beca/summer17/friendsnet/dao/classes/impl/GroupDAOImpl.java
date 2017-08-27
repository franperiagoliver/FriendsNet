/*
 * Created at 24-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.dao.classes.impl;

import java.util.ArrayList;
import java.util.List;

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

	private List<Group> listGroups = new ArrayList<>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.GroupDAO#
	 * addPersons(java.lang.Iterable)
	 */
	@Override
	public Group addPersons(final Iterable<Person> persons) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.GroupDAO#
	 * addPerson(com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes
	 * .Person)
	 */
	@Override
	public Group addPerson(final Person person) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.GroupDAO#
	 * relate(java.lang.Long, java.util.List)
	 */
	@Override
	public Group relate(final Long id, final List<Long> ids) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.GroupDAO#
	 * getByPersonId(java.lang.Long)
	 */
	@Override
	public List<Group> getByPersonId(final Long id) {
		return listGroups;
	}
}