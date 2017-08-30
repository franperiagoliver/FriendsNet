/*
 * Created at 24-ago-2017 by Fran Periago
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;

/**
 * The Interface PersonDAO.
 */
@Service
public interface PersonDAO extends CrudRepository<Person, Long>, EntityDAO<Person, Long> {
	
	@Query(value = "INSERT INTO group_table(id, friends) VALUES(?1,?2)", nativeQuery = true)
	Person relatePersons(final Long personId, final Long newFriendsIds);
}