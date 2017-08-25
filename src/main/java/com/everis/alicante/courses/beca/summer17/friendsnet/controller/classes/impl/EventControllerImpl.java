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

import com.everis.alicante.courses.beca.summer17.friendsnet.controller.classes.AbstractController;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Event;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.EventManager;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.Manager;

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

	
	@GetMapping("/person/{id}")
	public List<Event> getByPersonId(@RequestParam final Long id) {
		return (List<Event>) this.manager.findById(id);
	}

	
	@PostMapping("/{id}/person/{idPerson}/add")
	public Event addPerson(@ RequestBody List<Long> ids) {
		return this.manager.addPerson(ids);
	}

	public Event addPersons(List<Long> ids) {
		return this.manager.addPersons(ids);
	}


	@Override
	protected EventManager getManager() {
		return this.manager;
	}
}