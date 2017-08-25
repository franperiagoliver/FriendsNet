/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.everis.alicante.courses.beca.summer17.friendsnet.controller.interfaces.PostController;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Like;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Post;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.PostManager;

/**
 * The Class PostController.
 */

@RequestMapping("/post")
@Transactional
public class PostControllerImpl implements PostController {

	/** The manager. */
	@Autowired
	private PostManager manager;

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */

	public List<Post> getAll() {
		return (List<Post>) this.manager.findAll();
	}

	/**
	 * Gets the by id.
	 *
	 * @param id
	 *            the id
	 * @return the by id
	 */
	
	public Post getById(final Long id) {
		return this.manager.findById(id);
	}

	/**
	 * Creates the.
	 *
	 * @param post
	 *            the post
	 * @return the post
	 */
	
	public Post create(final Post post) {
		return this.manager.save(post);
	}

	/**
	 * Gets the by person id.
	 *
	 * @param id
	 *            the id
	 * @return the by person id
	 */
	@Override
	@GetMapping("/person/{id}")
	public List<Post> getByPersonId(@PathVariable final Long id) {
		return (List<Post>) this.manager.findById(id);
	}

	/**
	 * Removes the.
	 *
	 * @param id
	 *            the id
	 */
	public void remove(final Long id) {
		this.manager.remove(manager.findById(id));
	}

	@Override
	public Post addLike(Like like) {
		return this.manager.addLike(like);
	}

}