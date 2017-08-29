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
	 * @param personIds
	 *            the person ids
	 * @param groupId
	 *            the group id
	 * @return the group
	 */
	Group addPersons(final List<Long> personIds, final Long groupId);

	/**
	 * Relate.
	 *
	 * @param personId
	 *            the person id
	 * @param groupId
	 *            the group id
	 * @return the group
	 */
	Group relate(final Long personId, final Long groupId);

	/**
	 * Gets the by person id.
	 *
	 * @param id
	 *            the id
	 * @return the by person id
	 */
	Set<Group> getByPersonId(final Long id);

	/**
	 * Adds the person.
	 *
	 * @param personId
	 *            the person id
	 * @param groupId
	 *            the group id
	 * @return the group
	 */
	Group addPerson(final Long personId, final Long groupId);
}