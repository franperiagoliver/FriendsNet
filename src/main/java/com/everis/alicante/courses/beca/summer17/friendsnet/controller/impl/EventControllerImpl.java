/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller.impl;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.alicante.courses.beca.summer17.friendsnet.controller.AbstractController;
import com.everis.alicante.courses.beca.summer17.friendsnet.controller.domain.dto.EventDTO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Event;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.EventManager;
import com.everis.alicante.courses.beca.summer17.friendsnet.utils.converter.EntityConverter;

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

	/** The entity converter. */
	@Autowired
	private EntityConverter entityConverter;

	/**
	 * Gets the by person id.
	 *
	 * @param personId
	 *            the person id
	 * @return the by person id
	 */
	@GetMapping("/person/{id}")
	public Set<EventDTO> getByPersonId(@PathVariable("id") final Long personId) {
		final Set<Event> events = this.getManager().getByPersonId(personId);
		return (Set<EventDTO>) entityConverter.convert(events, EventDTO.class);
	}

	/**
	 * Adds the person.
	 *
	 * @param personsId
	 *            the persons id
	 * @param eventId
	 *            the event id
	 * @return the event
	 */
	@PostMapping("/{id}/person/{idPersons}/add")
	public EventDTO addPersons(@PathVariable("idPersons") final List<Long> personsId,
			@PathVariable("id") final Long eventId) {
		final Event event = this.getManager().addPersons(personsId, eventId);
		return entityConverter.convert(event, EventDTO.class);
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