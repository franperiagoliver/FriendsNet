/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller.classes.impl;

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

import com.everis.alicante.courses.beca.summer17.friendsnet.controller.interfaces.EventController;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Event;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.EventManager;

/**
 * The Class EventController.
 */
@RequestMapping("/event")
@Transactional
public class EventControllerImpl implements EventController {

	/** The manager. */
	@Autowired
	private EventManager manager;

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	public List<Event> getAll() {
		return (List<Event>) this.manager.findAll();
	}

	/**
	 * Gets the by id.
	 *
	 * @param id
	 *            the id
	 * @return the by id
	 */
	public Event getById(final Long id) {
		return this.manager.findById(id);
	}

	/**
	 * Creates the.
	 *
	 * @param event
	 *            the event
	 * @return the post
	 */
	public Event create(final Event event) {
		return this.manager.save(event);
	}

	/**
	 * Gets the by person id.
	 *
	 * @param id
	 *            the id
	 * @return the by person id
	 */
	@GetMapping("/person/{id}")
	public List<Event> getByPersonId(@RequestParam final Long id) {
		return (List<Event>) this.manager.findById(id);
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

	/**
	 * Adds the person.
	 *
	 * @param idPerson
	 *            the id person
	 * @param idEvent
	 *            the id event
	 * @return the event
	 */
	@PostMapping("/{id}/person/{idPerson}/add")
	public Event addPerson(@ RequestBody List<Long> ids) {
		return this.manager.addPerson(ids);
	}


	@Override
	public Event addPersons(List<Long> ids) {
		return this.manager.addPersons(ids);
	}
}