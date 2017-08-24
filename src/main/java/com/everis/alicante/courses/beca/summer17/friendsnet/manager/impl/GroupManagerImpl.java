package com.everis.alicante.courses.beca.summer17.friendsnet.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.GroupDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Group;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.GroupManager;

@Service
public class GroupManagerImpl implements GroupManager {
	
	@Autowired
	private GroupDAO groupDao;
	
	@Override
	public Iterable<Group> findAll() {
		return groupDao.findAll();
	}

	@Override
	public Group findById(final Long id) {
		return groupDao.findById(id);
	}

	@Override
	public Iterable<Group> findByIds(final Iterable<Long> ids) {
		return groupDao.findByIds(ids);
	}

	@Override
	public Group save(final Group group) {
		return groupDao.save(group);
	}

	@Override
	public Iterable<Group> save(Iterable<Group> groups) {
		return groupDao.save(groups);
	}

	@Override
	public Group update(Group e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Group> update(Iterable<Group> es) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Group addPersons(Iterable<Person> persons) {
		// TODO Auto-generated method stub
		return null;
	}

}
