/*
 * Created at 24-ago-2017 by Fran Periago
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.manager;

import java.util.List;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;

/**
 * The Interface PersonManager.
 */
public interface PersonManager extends Manager<Person,Long> {

	/**
	 * Relate persons.
	 *
	 * @param personId the person id
	 * @param persons the persons
	 * @return the person
	 */
	Person relatePersons(final Long personId, final List<Long> persons);
}