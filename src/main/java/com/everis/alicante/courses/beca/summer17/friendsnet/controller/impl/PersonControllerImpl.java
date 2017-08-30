/*
 * Created at 24-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.alicante.courses.beca.summer17.friendsnet.controller.AbstractController;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.PersonManager;

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
	 * @param personId
	 *            the id
	 * @param newFriendId
	 *            the new friend id
	 * @return the all
	 */

	@PostMapping("/{id}/relate")
	public Person relate(@PathVariable("id") final Long personId, @RequestBody final Long newFriendId) {
		return this.getManager().relatePersons(personId, newFriendId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.controller.classes.
	 * AbstractController#getManager()
	 */
	@Override
	protected final PersonManager getManager() {
		return this.manager;
	}
}