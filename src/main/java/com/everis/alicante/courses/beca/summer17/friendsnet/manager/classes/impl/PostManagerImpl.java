/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.manager.classes.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.PostDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Like;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Post;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.classes.AbstractManager;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.PostManager;

/**
 * The Class EventManagerImpl.
 */
@Service
public class PostManagerImpl extends AbstractManager<Post, Long> implements PostManager {

	/** The post dao. */
	@Autowired
	private PostDAO postDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * PostManager#addLike(com.everis.alicante.courses.beca.summer17.friendsnet.
	 * entity.classes.Like)
	 */
	@Override
	public Post addLike(final Like like) {
		return this.getEntityDAO().addLike(like);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * PostManager#getByPersonId(java.lang.Long)
	 */
	@Override
	public List<Post> getByPersonId(final Long id) {
		return this.getEntityDAO().getByPersonId(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.classes.
	 * AbstractManager#getEntityDAO()
	 */
	@Override
	protected PostDAO getEntityDAO() {
		return this.postDao;
	}
}