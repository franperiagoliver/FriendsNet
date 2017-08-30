/*
 * Created at 29-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.web.servlet.ResultActions;

import com.everis.alicante.courses.beca.summer17.friendsnet.controller.AbstractControllerTest;
import com.everis.alicante.courses.beca.summer17.friendsnet.controller.PostControllerImpl;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Post;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Like;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.enums.LikeType;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.enums.PostType;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.PostManager;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.PersonManager;

import com.github.springtestdbunit.DbUnitTestExecutionListener;


/**
 * The Class PostControllerImplIT.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
public class PostControllerImplTest extends AbstractControllerTest<Post, Long> {

	/** The manager. */
	@Mock
	private PostManager manager;

	/** The manager. */
	@Mock
	private PersonManager Pmanager;

	/** The person controller. */
	@InjectMocks
	private PostControllerImpl controller;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.controller.
	 * AbstractControllerTest#getBaseURLFindAllAndCreate()
	 */
	@Override
	protected String getBaseURLFindAllAndCreate() {
		return "/post";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.controller.
	 * AbstractControllerTest#getBaseURLFindByIdAndRemove(java.io.Serializable)
	 */
	@Override
	protected String getBaseURLFindByIdAndRemove(final Long id) {
		return "/post" + id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.controller.
	 * AbstractControllerTest#getThenReturnFindAll()
	 */
	@Override
	protected Iterable<Post> getThenReturnFindAll() {
		final Post posta = new Post();
		posta.setText("pepe");
		posta.setType(PostType.STATUS);
		final Post postb = new Post();
		postb.setText("juan");
		postb.setType(PostType.STATUS);
		final List<Post> posts = new ArrayList<>();
		posts.add(posta);
		posts.add(postb);
		return posts;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.controller.
	 * AbstractControllerTest#getThenReturnFindByIdAndCreate()
	 */
	@Override
	protected Post getThenReturnFindByIdAndCreate() {
		final Post post = new Post();
		return post;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.controller.
	 * AbstractControllerTest#getManagerMock()
	 */
	@Override
	protected PostManager getManagerMock() {
		return this.manager;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.controller.
	 * AbstractControllerTest#getController()
	 */
	@Override
	protected PostControllerImpl getController() {
		return this.controller;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.controller.
	 * AbstractControllerTest#getFindById()
	 */
	@Override
	protected Long getFindById() {
		return 1L;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.controller.
	 * AbstractControllerTest#getSaveAndRemove()
	 */
	@Override
	protected Post getSaveAndRemove() {
		final Post post = new Post();
		post.setText("Fran");
		post.setType(PostType.STATUS);
		return post;
	}

	/**
	 * Test add persons.
	 *
	 * @param postId
	 *            the post id
	 * @param personId
	 *            the person id
	 * @param likeType
	 *            the like type
	 * @return the post
	 * @throws Exception
	 */
	@Test
	public Like addLike(final Long postId, final Long personId, final LikeType likeType) throws Exception {
		final Post post = this.getManagerMock().findById(postId);
		final Person person = Pmanager.findById(personId);
		final Like like = new Like();
		final Set<Like> likes = post.getPostLikes();
		post.setPostLikes(likes);
		like.setPersonOfLike(person);
		like.setPostOfLike(post);
		like.setType(likeType);
		likes.add(like);
		this.getManagerMock().save(post);
		Mockito.when(this.getManagerMock().addLike(postId, personId, likeType)).thenReturn(like);
		// Act
		ResultActions perform = super.getMockMvc().perform(post(this.getBaseURLFindAllAndCreate() + postId + "/like"));
		// Assert
		perform.andExpect(status().isOk());
		perform.andExpect(content().json(super.getMapper().writeValueAsString(like)));
		return like;
	}

	/**
	 * Test get by person id.
	 *
	 * @param personId
	 *            the person id
	 * @return the sets the
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public Set<Post> TestGetByPersonId(final Long personId) throws Exception {
		final Person person = this.Pmanager.findById(personId);
		final Set<Post> posts = person.getPosts();
		Mockito.when(this.getManagerMock().getByPersonId(personId)).thenReturn(posts);
		// Act
		ResultActions perform = super.getMockMvc()
				.perform(post(this.getBaseURLFindAllAndCreate() + "/person/" + personId));
		// Assert
		perform.andExpect(status().isOk());
		perform.andExpect(content().json(super.getMapper().writeValueAsString(posts)));
		return posts;
	}
}