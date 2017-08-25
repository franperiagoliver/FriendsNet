/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Group;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.GroupManager;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.PersonManager;

/**
 * The Class GroupController.
 */
@RestController
@RequestMapping("/group")
public class GroupController {

	/** The manager. */
	@Autowired
	private GroupManager manager;

	/** The p manager. */
	@Autowired
	private PersonManager pManager;

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	@GetMapping
	public List<Group> getAll() {
		return (List<Group>) this.manager.findAll();
	}

	/**
	 * Gets the by id.
	 *
	 * @param id
	 *            the id
	 * @return the by id
	 */
	@GetMapping("/{id}")
	public Group getById(@RequestParam final Long id) {
		return this.manager.findById(id);
	}

	/**
	 * Creates the.
	 *
	 * @param group
	 *            the group
	 * @return the group
	 */
	@PostMapping
	public Group create(@RequestBody final Group group) {
		return this.manager.save(group);
	}

	/**
	 * Gets the by person id.
	 *
	 * @param id
	 *            the id
	 * @return the by person id
	 */
	@GetMapping("/person/{id}/")
	public Group getByPersonId(@RequestParam final Long id) {
		return this.manager.findById(id);
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
	@PostMapping("/{id}/relate")
	public Person relate(@RequestParam final Long id, @RequestBody final List<Long> persons) {
		return this.pManager.relatePersons(id, persons);
	}

	/**
	 * Removes the.
	 *
	 * @param id
	 *            the id
	 */
	@DeleteMapping("{id}")
	public void remove(@RequestParam final Long id) {
		this.manager.remove(manager.findById(id));
	}
}