/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces;

import java.util.List;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Group;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Person;

/**
 * The Interface GroupDAO.
 */
public interface GroupDAO extends EntityDAO<Group, Long> {

	/**
	 * Adds the persons.
	 *
	 * @param persons
	 *            the persons
	 * @return the group
	 */
	public Group addPersons(final Iterable<Person> persons);

	/**
	 * Relate.
	 *
	 * @param id
	 *            the id
	 * @param ids
	 *            the ids
	 * @return the group
	 */
	public Group relate(final Long id, final List<Long> ids);

	/**
	 * Gets the by person id.
	 *
	 * @param id
	 *            the id
	 * @return the by person id
	 */
	public List<Group> getByPersonId(final Long id);

	/**
	 * Adds the person.
	 *
	 * @param person
	 *            the person
	 * @return the group
	 */
	public Group addPerson(final Person person);
}