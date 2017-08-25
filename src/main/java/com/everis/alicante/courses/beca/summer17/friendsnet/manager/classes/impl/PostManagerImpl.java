/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.manager.classes.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.PostDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Like;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Post;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.PostManager;

/**
 * The Class EventManagerImpl.
 */
@Service
public class PostManagerImpl implements PostManager {

	/** The event dao. */
	@Autowired
	private PostDAO postDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * Manager#findAll()
	 */
	@Override
	public Iterable<Post> findAll() {
		return this.postDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * Manager#findById(java.io.Serializable)
	 */
	@Override
	public Post findById(Long id) {
		return this.postDao.findById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * Manager#findByIds(java.lang.Iterable)
	 */
	@Override
	public Iterable<Post> findByIds(Iterable<Long> ids) {
		return this.postDao.findByIds(ids);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * Manager#save(com.everis.alicante.courses.beca.summer17.friendsnet.entity.
	 * interfaces.FNEntity)
	 */
	@Override
	public Post save(Post post) {
		return this.postDao.save(post);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * Manager#save(java.lang.Iterable)
	 */
	@Override
	public Iterable<Post> save(Iterable<Post> posts) {
		return this.postDao.save(posts);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * Manager#update(com.everis.alicante.courses.beca.summer17.friendsnet.entity.
	 * interfaces.FNEntity)
	 */
	@Override
	public Post update(Post post) {
		return this.postDao.update(post);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * Manager#update(java.lang.Iterable)
	 */
	@Override
	public Iterable<Post> update(Iterable<Post> posts) {
		return this.postDao.update(posts);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * Manager#remove(com.everis.alicante.courses.beca.summer17.friendsnet.entity.
	 * interfaces.FNEntity)
	 */
	@Override
	public void remove(Post post) {
		this.postDao.remove(post);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * PostManager#addLike(com.everis.alicante.courses.beca.summer17.friendsnet.
	 * entity.classes.Like)
	 */
	@Override
	public Post addLike(Like like) {
		return this.addLike(like);
	}
}