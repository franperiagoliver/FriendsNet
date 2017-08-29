/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.manager.classes.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.LikeDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.PersonDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.PostDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Like;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Post;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.enums.LikeType;
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

	/** The like dao. */
	@Autowired
	private LikeDAO likeDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * PostManager#addLike(com.everis.alicante.courses.beca.summer17.friendsnet.
	 * entity.classes.Like)
	 */
	@Override
	public Like addLike(final Long postId, final Long personId, final LikeType likeType) {
		final Post post = getEntityDAO().findOne(postId);
		final Person person = personDao.findOne(personId);
		final Like like = new Like();
		like.setLikeOfPerson(person);
		like.setLikeOfPost(post);
		like.setType(likeType);
		return likeDao.save(like);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * PostManager#getByPersonId(java.lang.Long)
	 */
	@Override
	public Set<Post> getByPersonId(final Long personId) {
		final Person person = this.personDao.findOne(personId);
		return person.getPosts();
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