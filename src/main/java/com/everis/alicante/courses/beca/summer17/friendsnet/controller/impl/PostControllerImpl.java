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
import com.everis.alicante.courses.beca.summer17.friendsnet.controller.domain.dto.LikeDTO;
import com.everis.alicante.courses.beca.summer17.friendsnet.controller.domain.dto.PostDTO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Like;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Post;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.PostManager;
import com.everis.alicante.courses.beca.summer17.friendsnet.utils.converter.EntityConverter;

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

	/** The entity converter. */
	@Autowired
	private EntityConverter entityConverter;

	/**
	 * Gets the by person id.
	 *
	 * @param personId
	 *            the person id
	 * @return the by person id
	 */
	@GetMapping("/person/{id}")
	public Set<Post> getByPersonId(@PathVariable("id") final Long personId) {
		final Set<Post> posts = this.getManager().getByPersonId(personId);
		return (Set<Post>) entityConverter.convert(posts, PostDTO.class);
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
	public LikeDTO addLike(@PathVariable("idPost") final Long postId, @RequestBody PersonLike personLike) {
		final Like like = this.getManager().addLike(postId, personLike.getIdPerson(), personLike.getLikeType());
		return entityConverter.convert(like, LikeDTO.class);
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