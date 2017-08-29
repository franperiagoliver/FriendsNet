/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Event;

/**
 * The Interface EventDAO.
 */
@Service
public interface EventDAO extends CrudRepository<Event, Long>, EntityDAO<Event, Long> {
	
	@Query(value = "INSERT INTO event(id, person_id) VALUES(?1,?2)", nativeQuery = true)
	Event addPerson(final Long personId, final Long eventId);
	
	@Query(value = "SELECT person_id FROM event WHERE person_id=?1", nativeQuery = true)
	Set<Event> getByPersonId(final Long personId);
}