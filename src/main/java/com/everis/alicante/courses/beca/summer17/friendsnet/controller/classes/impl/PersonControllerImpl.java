/*
 * Created at 24-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller.classes.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.everis.alicante.courses.beca.summer17.friendsnet.controller.classes.AbstractController;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.PersonManager;

/**
 * The Class PersonController.
 */
@RestController
@RequestMapping("/person")
@Transactional
public class PersonControllerImpl extends AbstractController<Person, Long>  {

	/** The person manager. */
	@Autowired
	private PersonManager manager;

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	
	@PostMapping("/{id}/relate")
	public Person relate(@RequestParam final Long id, @RequestBody final List<Long> persons) {
		return this.manager.relatePersons(id, persons);
	}

	protected PersonManager getManager() {
		return manager;
	}

	
}