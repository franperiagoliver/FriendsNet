/*
 * Created at 24-ago-2017 by Fran Periago
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;

public interface PersonDAO extends EntityDAO<Person, Long> {

	/**
	 * Relate persons.
	 *
	 * @param person the person
	 * @return the person
	 */
	public Person relatePersons(final Iterable<Person> person);

}
