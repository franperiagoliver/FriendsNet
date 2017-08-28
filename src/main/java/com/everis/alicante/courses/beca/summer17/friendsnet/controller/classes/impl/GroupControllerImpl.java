/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller.classes.impl;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.alicante.courses.beca.summer17.friendsnet.controller.classes.AbstractController;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Group;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.GroupManager;

/**
 * The Class GroupController.
 */
@RestController
@RequestMapping("/group")
@Transactional
public class GroupControllerImpl extends AbstractController<Group, Long> {

	/** The manager. */
	@Autowired
	private GroupManager manager;

	/**
	 * Gets the by person id.
	 *
	 * @param id
	 *            the id
	 * @return the by person id
	 */
	@GetMapping("/person/{id}/")
	public Set<Group> getByPersonId(final Long id) {
		return this.getManager().getByPersonId(id);
	}

	/**
	 * Relate.
	 *
	 * @param id
	 *            the id
	 * @param ids
	 *            the ids
	 * @return the group
	 */
	@PostMapping("/{id}/relate")
	public Group relate(@PathVariable final Long id, @RequestBody final Set<Long> ids) {
		return this.getManager().relate(id, ids);
	}
	
	/**
	 * Adds the person.
	 *
	 * @param person the person
	 * @return the group
	 */
	public Group addPerson(final Long personId, final Long groupId) {
		return this.getManager().addPerson(personId, groupId);
	}
	
	/**
	 * Adds the persons.
	 *
	 * @param persons the persons
	 * @return the group
	 */
	public Group addPersons(final Set<Long> personIds, final Long groupId) {
		return this.getManager().addPersons(personIds, groupId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.controller.classes.
	 * AbstractController#getManager()
	 */
	@Override
	protected final GroupManager getManager() {
		return this.manager;
	}
}