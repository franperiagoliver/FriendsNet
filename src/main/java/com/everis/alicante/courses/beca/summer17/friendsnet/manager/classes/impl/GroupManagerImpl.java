/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.manager.classes.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.GroupDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Group;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.GroupManager;

/**
 * The Class GroupManagerImpl.
 */
@Service
public class GroupManagerImpl implements GroupManager {

	/** The group dao. */
	@Autowired
	private GroupDAO groupDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.everis.alicante.courses.beca.summer17.friendsnet.manager.Manager#findAll(
	 * )
	 */
	@Override
	public Iterable<Group> findAll() {
		return this.groupDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.everis.alicante.courses.beca.summer17.friendsnet.manager.Manager#findById
	 * (java.io.Serializable)
	 */
	@Override
	public Group findById(Long id) {
		return this.groupDao.findById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.Manager#
	 * findByIds(java.lang.Iterable)
	 */
	@Override
	public Iterable<Group> findByIds(Iterable<Long> ids) {
		return this.groupDao.findByIds(ids);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.everis.alicante.courses.beca.summer17.friendsnet.manager.Manager#save(com
	 * .everis.alicante.courses.beca.summer17.friendsnet.entity.interfaces.FNEntity)
	 */
	@Override
	public Group save(Group group) {
		return this.groupDao.save(group);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.everis.alicante.courses.beca.summer17.friendsnet.manager.Manager#save(
	 * java.lang.Iterable)
	 */
	@Override
	public Iterable<Group> save(Iterable<Group> groups) {
		return this.groupDao.save(groups);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.everis.alicante.courses.beca.summer17.friendsnet.manager.Manager#update(
	 * com.everis.alicante.courses.beca.summer17.friendsnet.entity.interfaces.
	 * FNEntity)
	 */
	@Override
	public Group update(Group group) {
		return this.groupDao.update(group);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.everis.alicante.courses.beca.summer17.friendsnet.manager.Manager#update(
	 * java.lang.Iterable)
	 */
	@Override
	public Iterable<Group> update(Iterable<Group> groups) {
		return this.groupDao.update(groups);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.everis.alicante.courses.beca.summer17.friendsnet.manager.Manager#remove(
	 * com.everis.alicante.courses.beca.summer17.friendsnet.entity.interfaces.
	 * FNEntity)
	 */
	@Override
	public void remove(Group group) {
		this.groupDao.remove(group);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.everis.alicante.courses.beca.summer17.friendsnet.manager.GroupManager#
	 * addPersons(java.lang.Iterable)
	 */
	@Override
	public Group addPersons(Iterable<Person> persons) {
		return this.groupDao.addPersons(persons);
	}
}