/*
 * Created at 30-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.dao.integration;

import java.util.List;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.PostDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Post;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.enums.PostType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

/**
 * The Class PostDAOIT.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
public class PostDAOIT {

	/** The dao. */
	@Autowired
	private PostDAO dao;

	/** The mapper. */
	private ObjectMapper mapper;

	/**
	 * Setup.
	 */
	@Before
	public void setup() {
		this.mapper = new ObjectMapper();
	}

	/**
	 * Test find all.
	 *
	 * @throws JSONException
	 *             the JSON exception
	 */
	@Test
	@DatabaseSetup("/db/initial-post.xml")
	public void testFindAll() throws JSONException {
		// Act
		List<Post> all = (List<Post>) dao.findAll();
		// Assert
		Assert.assertEquals(2, all.size());
	}

	/**
	 * Test save person.
	 *
	 * @throws JSONException
	 *             the JSON exception
	 */
	@Test
	@DatabaseSetup("/db/initial-post.xml")
	public void testSavePost() throws JSONException {
		// Arrange
		final Post post = new Post();
		post.setText("Uno");
		post.setType(PostType.STATUS);
		// Act
		dao.save(post);
		// Assert
		List<Post> all = (List<Post>) dao.findAll();
		Assert.assertEquals(3, all.size());
	}

	/**
	 * Test save person 2.
	 *
	 * @throws JSONException
	 *             the JSON exception
	 */
	@Test
	@DatabaseSetup("/db/initial-post.xml")
	@ExpectedDatabase(value = "/db/after-creating-post.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testSavePost2() throws JSONException {
		// Arrange
		final Post post = new Post();
		post.setText("Adios");
		post.setType(PostType.STATUS);
		// Act
		dao.save(post);
	}

	/**
	 * Test remove person.
	 *
	 * @throws JSONException
	 *             the JSON exception
	 */
	@Test
	@DatabaseSetup("/db/initial-post.xml")
	@ExpectedDatabase(value = "/db/after-deleting-post.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testRemovePost() throws JSONException {
	}
}