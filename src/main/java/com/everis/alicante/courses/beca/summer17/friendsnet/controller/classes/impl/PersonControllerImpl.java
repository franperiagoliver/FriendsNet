/*
 * Created at 24-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller.classes.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class PersonControllerImpl extends AbstractController<Person, Long> {

	/** The person manager. */
	@Autowired
	private PersonManager manager;

	/**
	 * Gets the all.
	 *
	 * @param id
	 *            the id
	 * @param ids
	 *            the ids
	 * @return the all
	 */

	@PostMapping("/{id}/relate")
	public Person relate(@PathVariable final Long id, @RequestBody final List<Long> ids) {
		return this.getManager().relatePersons(id, ids);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.controller.classes.
	 * AbstractController#getManager()
	 */
	@Override
	protected PersonManager getManager() {
		return manager;
	}
}