/*
 * Created at 24-ago-2017 by Fran Periago
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.manager;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.PersonDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;

/**
 * The Class PersonManager.
 */
public class PersonManager {
	
	/** The person dao. */
	private PersonDAO personDao;
	
	/**
	 * Instantiates a new person manager.
	 *
	 * @param personDao the person dao
	 */
	public PersonManager(final PersonDAO personDao) {
		super();
		this.personDao = personDao;
	}
	
	/**
	 * Save person.
	 *
	 * @param person the person
	 */
	public void savePerson(final Person person) {
		this.personDao.save(person);
	}
	
	/**
	 * Save persons.
	 *
	 * @param persons the persons
	 */
	public void savePersons(final Iterable<Person> persons) {
		this.personDao.save(persons);
	}
	
	/**
	 * Update person.
	 *
	 * @param person the person
	 */
	public void updatePerson(final Person person) {
		this.personDao.update(person);
	}
	
	/**
	 * Update persons.
	 *
	 * @param persons the persons
	 */
	public void updatePersons(final Iterable<Person> persons) {
		this.personDao.update(persons);
	}
	
	/**
	 * Removes the person.
	 *
	 * @param person the person
	 */
	public void removePerson(final Person person) {
		this.personDao.remove(person);
	}
	
	/**
	 * Find persons.
	 *
	 * @return the iterable
	 */
	public Iterable<Person> findPersons() {
		return this.personDao.findAll();
	}
	
	/**
	 * Find person by id.
	 *
	 * @param id the id
	 * @return the person
	 */
	public Person findPersonById(Long id) {
		return this.personDao.findById(id);
	}
	
}
