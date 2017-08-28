/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.manager.classes.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.PersonDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.PostDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Like;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Person;
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
	
	/** The person dao. */
	@Autowired
	private PersonDAO personDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * PostManager#addLike(com.everis.alicante.courses.beca.summer17.friendsnet.
	 * entity.classes.Like)
	 */
	@Override
	public Post addLike(Like like, final Long postId) {
		final Post post = this.getEntityDAO().findById(postId);
		like = post.getPostOfLike();
		post.setPostOfLike(like);
		this.getEntityDAO().save(post);
		return post;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * PostManager#getByPersonId(java.lang.Long)
	 */
	@Override
	public Set<Post> getByPersonId(final Long personId) {
		final Person person = this.personDao.findById(personId);
		final Set<Post> listPosts = person.getPosts();
		return listPosts;
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