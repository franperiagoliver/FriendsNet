/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Group;

/**
 * The Interface GroupDAO.
 */
@Service
public interface GroupDAO extends CrudRepository<Group, Long>, EntityDAO<Group, Long> {
	
	@Query(value = "INSERT INTO group_table(id, person_id) VALUES(?1,?2)", nativeQuery = true)
	Group addPersons(final List<Long> personIds, final Long groupId);
	
	@Query(value = "INSERT INTO group_table(id, person_id) VALUES(?1,?2)", nativeQuery = true)
	Group relate(final Long personId, final Long groupId);
	
	@Query(value = "INSERT INTO group_table(id, person_id) VALUES(?1,?2)", nativeQuery = true)
	Group addPerson(final Long personId, final Long groupId);
	
	@Query(value = "SELECT person_id FROM group_test WHERE person_id=?1", nativeQuery = true)
	Set<Group> getByPersonId(final Long id);
}