/*
 * Created at 24-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces;

import java.util.List;
import java.util.Set;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Group;

/**
 * The Interface GroupManager.
 */
public interface GroupManager extends Manager<Group, Long> {

	/**
	 * Adds the persons.
	 *
	 * @param persons
	 *            the persons
	 * @return the group
	 */
	Group addPersons(final List<Long> personIds, final Long groupId);

	/**
	 * Relate.
	 *
	 * @param id
	 *            the id
	 * @param ids
	 *            the ids
	 * @return the group
	 */
	public Group relate(final Long personId, final Long groupId);

	/**
	 * Gets the by person id.
	 *
	 * @param id
	 *            the id
	 * @return the by person id
	 */
	public Set<Group> getByPersonId(final Long id);

	/**
	 * Adds the person.
	 *
	 * @param person
	 *            the person
	 * @return the group
	 */
	public Group addPerson(final Long personId, final Long groupId);
}