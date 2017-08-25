/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Event;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.EventManager;

/**
 * The Class EventController.
 */
@RestController
@RequestMapping("/event")
public class EventController {

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
	@GetMapping("/{id}")
	public Event getById(@RequestParam final Long id) {
		return this.manager.findById(id);
	}

	/**
	 * Creates the.
	 *
	 * @param event
	 *            the event
	 * @return the post
	 */
	@PostMapping
	public Event create(@RequestBody final Event event) {
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
	public Event getByPersonId(@RequestParam final Long id) {
		return this.manager.findById(id);
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
	public Event addPerson(final Long idPerson, final Long idEvent) {
		return this.manager.findById(idPerson);
	}
}