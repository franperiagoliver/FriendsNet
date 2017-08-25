/*
 * Created at 24-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Group;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Person;

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
	Group addPersons(final Iterable<Person> persons);
}