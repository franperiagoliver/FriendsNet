/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.manager.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.GroupDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.dao.PersonDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Group;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.AbstractManager;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.GroupManager;

/**
 * The Class GroupManagerImpl.
 */
@Service
public class GroupManagerImpl extends AbstractManager<Group, Long> implements GroupManager {

	/** The group dao. */
	@Autowired
	private GroupDAO groupDao;

	/** The person dao. */
	@Autowired
	private PersonDAO personDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * GroupManager#addPersons(java.lang.Iterable, java.lang.Long)
	 */
	@Override
	public Group addPersons(final List<Long> personIds, final Long groupId) {
		final Set<Person> persons = (Set<Person>) this.personDao.findAll(personIds);
		final Group group = this.getEntityDAO().findOne(groupId);
		group.getPersonsInGroups().addAll(persons);
		return this.getEntityDAO().save(group);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * GroupManager#relate(java.lang.Long, java.util.List)
	 */
	@Override
	public Group relate(final Long groupId, final Long personId) {
		final Group group = this.getEntityDAO().findOne(groupId);
		final Person person = personDao.findOne(personId);
		group.getPersonsInGroups().add(person);
		person.getGroups().add(group);
		return this.getEntityDAO().save(group);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * GroupManager#getByPersonId(java.lang.Long)
	 */
	@Override
	public Set<Group> getByPersonId(final Long personId) {
		final Person person = this.personDao.findOne(personId);
		return person.getGroups();
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