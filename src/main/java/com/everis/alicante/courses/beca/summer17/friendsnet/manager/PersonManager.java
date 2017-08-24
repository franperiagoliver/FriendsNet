/*
 * Created at 24-ago-2017 by Fran Periago
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.manager;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;

/**
 * The Interface PersonManager.
 */
public interface PersonManager extends Manager<Person> {

	/**
	 * Relate persons.
	 *
	 * @param persons the persons
	 * @return the person
	 */
	Person relatePersons(final Iterable<Person> persons);
}