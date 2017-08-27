/*
 * Created at 27-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.entity.tests;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Event;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Like;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Post;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.enums.PostType;

/**
 * The Class PostTest.
 */
public class PostTest {

	/** The expected post. */
	private Post expectedPost;

	/** The expected id. */
	private Long expectedId = 1L;

	/** The expected text. */
	private String expectedText = "Hello World!";

	/** The expected creation date. */
	private Date expectedCreationDate = new Date();

	/** The expected type. */
	private PostType expectedType = PostType.STATUS;

	/** The expected picture. */
	private byte[] expectedPicture = null;

	/** The expected post of like. */
	private Like expectedPostOfLike = new Like();

	/** The expected post writter. */
	private Person expectedPostWritter = new Person();

	/** The expected post in event. */
	private Event expectedPostInEvent = new Event();

	/**
	 * Inits the.
	 */
	@Before
	public void init() {

		this.expectedPost = new Post();
		this.expectedPost.setId(expectedId);
		this.expectedPost.setText(expectedText);
		this.expectedPost.setCreationDate(expectedCreationDate);
		this.expectedPost.setType(expectedType);
		this.expectedPost.setPicture(expectedPicture);
		this.expectedPost.setPostOfLike(expectedPostOfLike);
		this.expectedPost.setPostWritter(expectedPostWritter);
		this.expectedPost.setPostInEvent(expectedPostInEvent);
	}

	/**
	 * Test like.
	 */
	@Test
	public void testLike() {
		// Assert
		Assert.assertNotNull(expectedPost);
	}

	/**
	 * Test get id.
	 */
	@Test
	public void testGetId() {
		// Act
		final Long result = this.expectedPost.getId();
		// Assert
		Assert.assertEquals(expectedId, result);
	}

	/**
	 * Test get text.
	 */
	@Test
	public void testGetText() {
		// Act
		final String result = this.expectedPost.getText();
		// Assert
		Assert.assertEquals(expectedText, result);
	}

	/**
	 * Test get creation date.
	 */
	@Test
	public void testGetCreationDate() {
		// Act
		final Date result = this.expectedPost.getCreationDate();
		// Assert
		Assert.assertEquals(expectedCreationDate, result);
	}

	/**
	 * Test get type.
	 */
	@Test
	public void testGetType() {
		// Act
		final PostType result = this.expectedPost.getType();
		// Assert
		Assert.assertEquals(expectedType, result);
	}

	/**
	 * Test get picture.
	 */
	@Test
	public void testGetPicture() {
		// Act
		final byte[] result = this.expectedPost.getPicture();
		// Assert
		Assert.assertEquals(expectedPicture, result);
	}

	/**
	 * Test get post of like.
	 */
	@Test
	public void testGetPostOfLike() {
		// Act
		final Like result = this.expectedPost.getPostOfLike();
		// Assert
		Assert.assertEquals(expectedPostOfLike, result);
	}

	/**
	 * Test get post writter.
	 */
	@Test
	public void testGetPostWritter() {
		// Act
		final Person result = this.expectedPost.getPostWritter();
		// Assert
		Assert.assertEquals(expectedPostWritter, result);
	}

	/**
	 * Test get post in event.
	 */
	@Test
	public void testGetPostInEvent() {
		// Act
		final Event result = this.expectedPost.getPostInEvent();
		// Assert
		Assert.assertEquals(expectedPostInEvent, result);
	}

	/**
	 * Test set id.
	 */
	@Test
	public void testSetId() {
		// Arrange
		final Post post = new Post();
		// Act
		post.setId(expectedId);
		// Assert
		Assert.assertEquals(expectedId, post.getId());
	}

	/**
	 * Test set text.
	 */
	@Test
	public void testSetText() {
		// Arrange
		final Post post = new Post();
		// Act
		post.setText(expectedText);
		// Assert
		Assert.assertEquals(expectedText, post.getText());
	}

	/**
	 * Test set creation date.
	 */
	@Test
	public void testSetCreationDate() {
		// Arrange
		final Post post = new Post();
		// Act
		post.setCreationDate(expectedCreationDate);
		// Assert
		Assert.assertEquals(expectedCreationDate, post.getCreationDate());
	}

	/**
	 * Test set type.
	 */
	@Test
	public void testSetType() {
		// Arrange
		final Post post = new Post();
		// Act
		post.setType(expectedType);
		// Assert
		Assert.assertEquals(expectedType, post.getType());
	}

	/**
	 * Test set picture.
	 */
	@Test
	public void testSetPicture() {
		// Arrange
		final Post post = new Post();
		// Act
		post.setPicture(expectedPicture);
		// Assert
		Assert.assertEquals(expectedPicture, post.getPicture());
	}

	/**
	 * Test set post of like.
	 */
	@Test
	public void testSetPostOfLike() {
		// Arrange
		final Post post = new Post();
		// Act
		post.setPostOfLike(expectedPostOfLike);
		// Assert
		Assert.assertEquals(expectedPostOfLike, post.getPostOfLike());
	}

	/**
	 * Test set post writter.
	 */
	@Test
	public void testSetPostWritter() {
		// Arrange
		final Post post = new Post();
		// Act
		post.setPostWritter(expectedPostWritter);
		// Assert
		Assert.assertEquals(expectedPostWritter, post.getPostWritter());
	}

	/**
	 * Test set post in event.
	 */
	@Test
	public void testSetPostInEvent() {
		// Arrange
		final Post post = new Post();
		// Act
		post.setPostInEvent(expectedPostInEvent);
		// Assert
		Assert.assertEquals(expectedPostInEvent, post.getPostInEvent());
	}
}