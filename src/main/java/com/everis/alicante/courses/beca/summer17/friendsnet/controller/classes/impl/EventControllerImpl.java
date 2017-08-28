/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller.classes.impl;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public Set<Event> getByPersonId(@PathVariable("id") final Long personId) {
		return this.getManager().getByPersonId(personId);
	}

	/**
	 * Adds the person.
	 *
	 * @param ids
	 *            the ids
	 * @return the event
	 */
	@PostMapping("/{id}/person/{idPerson}/add")
	public Event addPerson(@PathVariable("idPerson") final Long personId, @PathVariable("id") final Long eventId) {
		return this.getManager().addPerson(personId, eventId);
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