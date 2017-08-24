package com.everis.alicante.courses.beca.summer17.friendsnet.manager;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.PersonDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;

public class PersonManager {
	
	PersonDAO personDao;
	
	public PersonManager(final PersonDAO personDao) {
		super();
		this.personDao = personDao;
	}
	
	public void savePerson(final Person person) {
		this.personDao.save(person);
	}
	
	public void savePersons(final Iterable<Person> persons) {
		this.personDao.save(persons);
	}
	
	public void updatePerson(final Person person) {
		this.personDao.update(person);
	}
	
	public void updatePersons(final Iterable<Person> persons) {
		this.personDao.update(persons);
	}
	
	public void removePerson(final Person person) {
		this.personDao.remove(person);
	}
	
	public Iterable<Person> findPersons() {
		return this.personDao.findAll();
	}
	
	public Person findPersonById(Long id) {
		return this.personDao.findById(id);
	}
	
}
