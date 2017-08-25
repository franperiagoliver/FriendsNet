/*
 * Created at 24-ago-2017 by Fran Periago
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Person;

/**
 * The Interface PersonDAO.
 */

public interface PersonDAO extends EntityDAO<Person, Long> {

	/**
	 * Relate persons.
	 *
	 * @param personId
	 *            the person id
	 * @param ids
	 *            the ids
	 * @return the person
	 */
	public Person relatePersons(Long personId, Iterable<Long> ids);

}