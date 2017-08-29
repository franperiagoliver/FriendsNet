/*
 * Created at 27-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Like;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Post;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.enums.LikeType;

/**
 * The Interface PostDAO.
 */
@Service
public interface PostDAO extends CrudRepository<Post, Long>, EntityDAO<Post, Long> {
	
	@Query(value = "INSERT INTO like_table(post_id, person_id, type) VALUES(?1,?2,?3)", nativeQuery= true)
	Like addLike(final Long postId, final Long personId, final LikeType likeType);
	
	@Query(value = "SELECT person_id FROM post WHERE person_id=?1", nativeQuery = true)
	Set<Post> getByPersonId(final Long id);
}