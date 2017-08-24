/*
 * Created at 24-ago-2017 by Fran Periago
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.manager;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.PersonDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;

/**
 * The Class PersonManager.
 */
public class PersonManagerImpl implements PersonManager{
	
	/** The person dao. */
	private PersonDAO personDao;
	
	/**
	 * Instantiates a new person manager.
	 *
	 * @param personDao the person dao
	 */
	public PersonManagerImpl(final PersonDAO personDao) {
		super();
		this.personDao = personDao;
	}
	
	/* (non-Javadoc)
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.Manager#findAll()
	 */
	@Override
	public Iterable<Person> findAll() {
		return this.personDao.findAll();
	}

	/* (non-Javadoc)
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.Manager#findById(java.lang.Long)
	 */
	@Override
	public Person findById(final Long id) {
		return this.personDao.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.Manager#save(java.lang.Object)
	 */
	@Override
	public void save(final Person person) {
		this.personDao.save(person);
	}

	/* (non-Javadoc)
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.Manager#save(java.lang.Iterable)
	 */
	@Override
	public void save(final Iterable<Person> persons) {
		this.personDao.save(persons);
	}

	/* (non-Javadoc)
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.Manager#update(java.lang.Object)
	 */
	@Override
	public void update(final Person person) {
		this.personDao.update(person);
	}

	/* (non-Javadoc)
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.Manager#update(java.lang.Iterable)
	 */
	@Override
	public void update(final Iterable<Person> persons) {
		this.personDao.update(persons);
	}

	/* (non-Javadoc)
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.Manager#remove(java.lang.Object)
	 */
	@Override
	public void remove(final Person person) {
		this.personDao.remove(person);
	}

	/* (non-Javadoc)
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.PersonManager#relatePersons(java.lang.Iterable)
	 */
	@Override
	public Person relatePersons(final Iterable<Person> persons) {
		return null;
	}
}