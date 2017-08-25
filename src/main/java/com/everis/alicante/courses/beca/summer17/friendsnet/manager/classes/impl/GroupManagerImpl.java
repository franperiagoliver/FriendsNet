/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.manager.classes.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.EntityDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.GroupDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Group;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.classes.AbstractManager;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.GroupManager;

/**
 * The Class GroupManagerImpl.
 */
@Service
public class GroupManagerImpl extends AbstractManager<Group, Long> implements GroupManager {

	/** The group dao. */
	@Autowired
	private GroupDAO groupDao;

	
	@Override
	public Group addPersons(final Iterable<Person> persons) {
		return this.groupDao.addPersons(persons);
	}


	@Override
	public EntityDAO<Group, Long> getEntityDAO() {
		return this.groupDao;
	}


	@Override
	public Group relate(Long id, List<Long> ids) {
		return this.groupDao.relate(id, ids);
	}


	@Override
	public List<Group> getByPersonId(Long id) {
		return this.groupDao.getByPersonId(id);
	}


	@Override
	public Group addPerson(Person person) {
		return this.groupDao.addPerson(person);
	}
}