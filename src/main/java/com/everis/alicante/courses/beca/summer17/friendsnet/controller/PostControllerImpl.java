/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.alicante.courses.beca.summer17.friendsnet.controller.domain.GroupDTO;
import com.everis.alicante.courses.beca.summer17.friendsnet.controller.domain.LikeDTO;
import com.everis.alicante.courses.beca.summer17.friendsnet.controller.domain.PersonLikeDTO;
import com.everis.alicante.courses.beca.summer17.friendsnet.controller.domain.PostDTO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Group;
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
public class PostControllerImpl extends AbstractController<Post, PostDTO, Long> {

	/** The manager. */
	@Autowired
	private PostManager manager;

	protected PostControllerImpl() {
		super(Post.class, PostDTO.class);
		// TODO Auto-generated constructor stub
	}
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
		return (Set<Post>) super.getEntityConverter().convert(posts, PostDTO.class);
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
	public LikeDTO addLike(@PathVariable("idPost") final Long postId, @RequestBody PersonLikeDTO personLike) {
		final Like like = this.getManager().addLike(postId, personLike.getIdPerson(), personLike.getLikeType());
		return super.getEntityConverter().convert(like, LikeDTO.class);
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