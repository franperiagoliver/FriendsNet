/*
 * Created at 24-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller;



import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.PersonDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.PersonManager;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.PersonManagerImpl;

import antlr.collections.List;

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
		this.personManager = new PersonManagerImpl(personDao);
	}
	
	public List<Person> getAll() {
		return this.personManager.findAll();
	}
	
	public Person getById(final Long id) {
		return this.personManager.findById(id);
	}
	
	public Person create(final Person person) {
		return this.personManager.save(person);
	}
	
	public Person relate(final String person, final List<String> persons) {
		return this.personManager.relatePersons(persons);
	}
	
	public void remove(final Long id) {
		this.personManager.remove(id);
	}
}
