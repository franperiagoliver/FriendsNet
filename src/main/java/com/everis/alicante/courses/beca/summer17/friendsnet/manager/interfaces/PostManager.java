/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces;

import java.util.List;
import java.util.Set;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Like;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Post;

/**
 * The Interface PostManager.
 */
public interface PostManager extends Manager<Post, Long> {

	/**
	 * Adds the like.
	 *
	 * @param like
	 *            the like
	 * @return the post
	 */
	Post addLike(Like like, final Long idPost);

	/**
	 * Gets the by person id.
	 *
	 * @param id
	 *            the id
	 * @return the by person id
	 */
	Set<Post> getByPersonId(final Long personId);
}