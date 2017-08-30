/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller.impl;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.alicante.courses.beca.summer17.friendsnet.controller.AbstractController;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Event;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.EventManager;

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
	 * @param personId
	 *            the person id
	 * @return the by person id
	 */
	@GetMapping("/person/{id}")
	public Set<Event> getByPersonId(@PathVariable("id") final Long personId) {
		return this.getManager().getByPersonId(personId);
	}

	/**
	 * Adds the person.
	 *
	 * @param personId
	 *            the person id
	 * @param eventId
	 *            the event id
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