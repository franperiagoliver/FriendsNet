/*
 * Created at 27-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces;

import java.util.List;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Like;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Post;

/**
 * The Interface PostDAO.
 */
public interface PostDAO extends EntityDAO<Post, Long> {

	/**
	 * Adds the like.
	 *
	 * @param like
	 *            the like
	 * @return the post
	 */
	public Post addLike(final Like like);

	/**
	 * Gets the by person id.
	 *
	 * @param id
	 *            the id
	 * @return the by person id
	 */
	public List<Post> getByPersonId(final Long id);
}