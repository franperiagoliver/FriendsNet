/*
 * Created at 24-ago-2017 by Fran Periago
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.PersonDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.PersonManager;

/**
 * The Class PersonManager.
 */
@Service
public class PersonManagerImpl implements PersonManager {

	/** The person dao. */
	@Autowired
	private PersonDAO personDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.everis.alicante.courses.beca.summer17.friendsnet.manager.Manager#findAll(
	 * )
	 */
	@Override
	public Iterable<Person> findAll() {
		return this.personDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.everis.alicante.courses.beca.summer17.friendsnet.manager.Manager#findById
	 * (java.io.Serializable)
	 */
	@Override
	public Person findById(final Long id) {
		return this.personDao.findById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.Manager#
	 * findByIds(java.lang.Iterable)
	 */
	@Override
	public Iterable<Person> findByIds(final Iterable<Long> ids) {
		return this.personDao.findByIds(ids);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.everis.alicante.courses.beca.summer17.friendsnet.manager.Manager#save(com
	 * .everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.FNEntity)
	 */
	@Override
	public Person save(final Person person) {
		return this.personDao.save(person);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.everis.alicante.courses.beca.summer17.friendsnet.manager.Manager#save(
	 * java.lang.Iterable)
	 */
	@Override
	public Iterable<Person> save(final Iterable<Person> persons) {
		return this.personDao.save(persons);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.everis.alicante.courses.beca.summer17.friendsnet.manager.Manager#update(
	 * com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.FNEntity)
	 */
	@Override
	public Person update(final Person person) {
		return this.personDao.update(person);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.everis.alicante.courses.beca.summer17.friendsnet.manager.Manager#update(
	 * java.lang.Iterable)
	 */
	@Override
	public Iterable<Person> update(final Iterable<Person> persons) {
		return this.personDao.update(persons);
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
	public void remove(Person person) {
		this.personDao.remove(person);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.everis.alicante.courses.beca.summer17.friendsnet.manager.PersonManager#
	 * relatePersons(java.lang.Long, java.lang.Iterable)
	 */
	@Override
	public Person relatePersons(Long personId, Iterable<Long> ids) {
		return this.personDao.relatePersons(personId, ids);
	}
}