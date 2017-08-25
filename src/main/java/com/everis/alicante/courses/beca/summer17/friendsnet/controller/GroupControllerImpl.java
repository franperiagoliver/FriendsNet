/*
 * Created at 25-ago-2017 by Fran Periago.
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

import com.everis.alicante.courses.beca.summer17.friendsnet.controller.interfaces.GroupController;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Group;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.GroupManager;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.PersonManager;

/**
 * The Class GroupController.
 */
@RequestMapping("/group")
@Transactional
public class GroupControllerImpl implements GroupController {

	/** The manager. */
	@Autowired
	private GroupManager manager;

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
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
	public Group getById(final Long id) {
		return this.manager.findById(id);
	}

	/**
	 * Creates the.
	 *
	 * @param group
	 *            the group
	 * @return the group
	 */
	public Group create(final Group group) {
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
	public Group getByPersonId(final Long id) {
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
	@Override
	@PostMapping("/{id}/relate")
	public Group relate(@RequestParam final Long id, @RequestBody final List<Long> groups) {
		return this.manager.relate(id, groups);
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