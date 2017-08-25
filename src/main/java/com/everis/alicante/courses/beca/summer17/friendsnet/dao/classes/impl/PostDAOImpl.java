/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.dao.classes.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.classes.AbstractDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.PostDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Like;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Post;

/**
 * The Class PostDAOImpl.
 */
@Service
public class PostDAOImpl extends AbstractDAO<Post, Long> implements PostDAO {

	/** The entity manager. */
	@Autowired
	EntityManager entityManager;

	/** The post. */
	@Autowired
	Post post;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.PostDAO#
	 * addLike(com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.
	 * Like)
	 */
	@Override
	public Post addLike(final Like like) {
		return null;
	}

}