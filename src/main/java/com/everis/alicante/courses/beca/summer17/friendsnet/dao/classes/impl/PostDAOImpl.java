/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.dao.classes.impl;

import java.util.List;

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

	@Override
	public List<Post> getByPersonId(Long id) {
		return null;
	}
	

}