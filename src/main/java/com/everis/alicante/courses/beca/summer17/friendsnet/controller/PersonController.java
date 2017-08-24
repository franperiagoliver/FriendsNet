/*
 * Created at 24-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.PersonDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.PersonManager;

/**
 * The Class PersonController.
 */
public class PersonController {
	
	/** The person manager. */
	private PersonManager personManager;
	
	/**
	 * Instantiates a new person controller.
	 *
	 * @param personDao the person dao
	 */
	public PersonController(final PersonDAO personDao) {
		this.personManager = new PersonManager(personDao);
	}
	
	/**
	 * Save person.
	 *
	 * @param person the person
	 */
	public void savePerson(final Person person) {
		this.personManager.savePerson(person);
	}
	
	/**
	 * Save persons.
	 *
	 * @param persons the persons
	 */
	public void savePersons(final Iterable<Person> persons) {
		this.personManager.savePersons(persons);
	}
	
	/**
	 * Update person.
	 *
	 * @param person the person
	 */
	public void updatePerson(final Person person) {
		this.personManager.updatePerson(person);
	}
	
	/**
	 * Update persons.
	 *
	 * @param persons the persons
	 */
	public void updatePersons(final Iterable<Person> persons) {
		this.personManager.updatePersons(persons);
	}
	
	/**
	 * Removes the person.
	 *
	 * @param person the person
	 */
	public void removePerson(final Person person) {
		this.personManager.removePerson(person);
	}
	
	/**
	 * Find persons.
	 *
	 * @return the iterable
	 */
	public Iterable<Person> findPersons() {
		return this.personManager.findPersons();
	}
	
	/**
	 * Find person by id.
	 *
	 * @param id the id
	 * @return the person
	 */
	public Person findPersonById(Long id) {
		return this.personManager.findPersonById(id);
	}
}
