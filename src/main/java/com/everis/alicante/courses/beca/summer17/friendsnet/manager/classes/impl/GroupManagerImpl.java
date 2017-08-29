/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.manager.classes.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.GroupDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.PersonDAO;
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
		group.setPersonsInGroups(persons);
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
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * GroupManager#addPerson(java.lang.Long, java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Group addPerson(final Long personId, final Long groupId) {
		final Person person = this.personDao.findOne(personId);
		final Group group = this.getEntityDAO().findOne(groupId);
		group.setPersonsInGroups((Set<Person>) person);
		return this.getEntityDAO().save(group);
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