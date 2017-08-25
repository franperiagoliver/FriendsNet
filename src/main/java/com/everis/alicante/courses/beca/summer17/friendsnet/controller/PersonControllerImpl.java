/*
 * Created at 24-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.everis.alicante.courses.beca.summer17.friendsnet.controller.interfaces.PersonController;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.PersonManager;

/**
 * The Class PersonController.
 */
@RequestMapping("/person")
@Transactional
public class PersonControllerImpl implements PersonController  {

	/** The person manager. */
	@Autowired
	private PersonManager manager;

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	public List<Person> getAll() {
		return (List<Person>) this.manager.findAll();
	}

	/**
	 * Gets the by id.
	 *
	 * @param id
	 *            the id
	 * @return the by id
	 */
	public Person getById(@RequestParam final Long id) {
		return this.manager.findById(id);
	}

	/**
	 * Creates the.
	 *
	 * @param person
	 *            the person
	 * @return the person
	 */
	public Person create(final Person person) {
		return this.manager.save(person);
	}

	/**
	 * Relate.
	 *
	 * @param id
	 *            the id
	 * @param persons
	 *            the persons
	 * @return the person
	 */
	@Override
	@PostMapping("/{id}/relate")
	public Person relate(@RequestParam final Long id, @RequestBody final List<Long> persons) {
		return this.manager.relatePersons(id, persons);
	}

	/**
	 * Removes the.
	 *
	 * @param id
	 *            the id
	 */
	public void remove(final Long id) {
		this.manager.remove(manager.findById(id));
	}
}