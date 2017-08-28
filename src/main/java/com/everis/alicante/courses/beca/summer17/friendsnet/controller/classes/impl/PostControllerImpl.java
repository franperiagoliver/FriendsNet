/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller.classes.impl;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.alicante.courses.beca.summer17.friendsnet.controller.classes.AbstractController;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Like;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Post;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.enums.LikeType;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.PostManager;

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
	 * @param id
	 *            the id
	 * @return the by person id
	 */
	@GetMapping("/person/{id}")
	public Set<Post> getByPersonId(@PathVariable("id") final Long personId) {
		return this.getManager().getByPersonId(personId);
	}
	
	/**
	 * Adds the like.
	 *
	 * @param like the like
	 * @return the post
	 */
	@PostMapping("/{id}/person/{idPerson}/like/{typeLike}/add")
	public Like addLike(@PathVariable("id") final Long postId, @PathVariable("idPerson") final Long personId, @PathVariable("typeLike") final LikeType likeType) {
		return this.getManager().addLike(postId, personId, likeType);
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