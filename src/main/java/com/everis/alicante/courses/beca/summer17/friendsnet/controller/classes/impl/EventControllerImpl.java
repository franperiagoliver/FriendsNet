/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller.classes.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.everis.alicante.courses.beca.summer17.friendsnet.controller.classes.AbstractController;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Event;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.EventManager;

/**
 * The Class EventController.
 */
@RestController
@RequestMapping("/event")
@Transactional
public class EventControllerImpl extends AbstractController<Event, Long> {

	/** The manager. */
	@Autowired
	private EventManager manager;

	/**
	 * Gets the by person id.
	 *
	 * @param id
	 *            the id
	 * @return the by person id
	 */
	@GetMapping("/person/{id}")
	public List<Event> getByPersonId(@RequestParam final Long id) {
		return (List<Event>) this.getManager().findById(id);
	}

	/**
	 * Adds the person.
	 *
	 * @param ids
	 *            the ids
	 * @return the event
	 */
	@PostMapping("/{id}/person/{idPerson}/add")
	public Event addPerson(@RequestBody final List<Long> ids) {
		return this.getManager().addPerson(ids);
	}

	/**
	 * Adds the persons.
	 *
	 * @param ids
	 *            the ids
	 * @return the event
	 */
	public Event addPersons(final List<Long> ids) {
		return this.getManager().addPersons(ids);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.controller.classes.
	 * AbstractController#getManager()
	 */
	@Override
	protected final EventManager getManager() {
		return this.manager;
	}
}