/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.manager.classes.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * GroupManager#addPersons(java.lang.Iterable)
	 */
	@Override
	public Group addPersons(final Iterable<Person> persons) {
		return this.getEntityDAO().addPersons(persons);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * GroupManager#relate(java.lang.Long, java.util.List)
	 */
	@Override
	public Group relate(final Long id, final List<Long> ids) {
		return this.getEntityDAO().relate(id, ids);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * GroupManager#getByPersonId(java.lang.Long)
	 */
	@Override
	public List<Group> getByPersonId(final Long id) {
		return this.getEntityDAO().getByPersonId(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * GroupManager#addPerson(com.everis.alicante.courses.beca.summer17.friendsnet.
	 * entity.classes.Person)
	 */
	@Override
	public Group addPerson(final Person person) {
		return this.getEntityDAO().addPerson(person);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.classes.
	 * AbstractManager#getEntityDAO()
	 */
	@Override
	protected final GroupDAO getEntityDAO() {
		return this.groupDao;
	}
}