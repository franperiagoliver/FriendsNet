/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller.impl;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.alicante.courses.beca.summer17.friendsnet.controller.AbstractController;
import com.everis.alicante.courses.beca.summer17.friendsnet.controller.domain.PersonLike;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Like;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Post;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.PostManager;

/**
 * The Class PostController.
 */
@RestController
@RequestMapping("/post")
@Transactional
public class PostControllerImpl extends AbstractController<Post, Long> {

	/** The manager. */
	@Autowired
	private PostManager manager;

	/**
	 * Gets the by person id.
	 *
	 * @param personId
	 *            the person id
	 * @return the by person id
	 */
	@GetMapping("/person/{id}")
	public Set<Post> getByPersonId(@PathVariable("id") final Long personId) {
		return this.getManager().getByPersonId(personId);
	}

	/**
	 * Adds the like.
	 *
	 * @param postId
	 *            the post id
	 * @param personLike
	 *            the person like
	 * @return the post
	 */
	@PostMapping("/{idPost}/like")
	public Like addLike(@PathVariable("idPost") final Long postId, @RequestBody PersonLike personLike) {
		return this.getManager().addLike(postId, personLike.getIdPerson(), personLike.getLikeType());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.controller.classes.
	 * AbstractController#getManager()
	 */
	@Override
	protected final PostManager getManager() {
		return manager;
	}
}