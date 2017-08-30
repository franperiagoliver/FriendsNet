/*
 * Created at 27-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.everis.alicante.courses.beca.summer17.friendsnet.controller.domain.LikeDTO;
import com.everis.alicante.courses.beca.summer17.friendsnet.controller.domain.PersonDTO;
import com.everis.alicante.courses.beca.summer17.friendsnet.controller.domain.PostDTO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.enums.PostType;

/**
 * The Class PostTest.
 */
public class PostDTOTest {

	/** The expected post. */
	private PostDTO expectedPostDTO;

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
	private Set<LikeDTO> expectedPostLikes = new HashSet<>();

	/** The expected post writter. */
	private PersonDTO expectedPostWritter = new PersonDTO();

	/**
	 * Inits the.
	 */
	@Before
	public void init() {

		this.expectedPostDTO = new PostDTO();
		this.expectedPostDTO.setId(expectedId);
		this.expectedPostDTO.setText(expectedText);
		this.expectedPostDTO.setCreationDate(expectedCreationDate);
		this.expectedPostDTO.setPostType(expectedType);
		this.expectedPostDTO.setPicture(expectedPicture);
		this.expectedPostDTO.setPostLikes(expectedPostLikes);
		this.expectedPostDTO.setPostWritter(expectedPostWritter);
	}

	/**
	 * Test like.
	 */
	@Test
	public void testLike() {
		// Assert
		Assert.assertNotNull(expectedPostDTO);
	}

	/**
	 * Test get id.
	 */
	@Test
	public void testGetId() {
		// Act
		final Long result = this.expectedPostDTO.getId();
		// Assert
		Assert.assertEquals(expectedId, result);
	}

	/**
	 * Test get text.
	 */
	@Test
	public void testGetText() {
		// Act
		final String result = this.expectedPostDTO.getText();
		// Assert
		Assert.assertEquals(expectedText, result);
	}

	/**
	 * Test get creation date.
	 */
	@Test
	public void testGetCreationDate() {
		// Act
		final Date result = this.expectedPostDTO.getCreationDate();
		// Assert
		Assert.assertEquals(expectedCreationDate, result);
	}

	/**
	 * Test get type.
	 */
	@Test
	public void testGetPostType() {
		// Act
		final PostType result = this.expectedPostDTO.getPostType();
		// Assert
		Assert.assertEquals(expectedType, result);
	}

	/**
	 * Test get picture.
	 */
	@Test
	public void testGetPicture() {
		// Act
		final byte[] result = this.expectedPostDTO.getPicture();
		// Assert
		Assert.assertEquals(expectedPicture, result);
	}

	/**
	 * Test get post of like.
	 */
	@Test
	public void testGetPostLikes() {
		// Act
		final Set<LikeDTO> result = this.expectedPostDTO.getPostLikes();
		// Assert
		Assert.assertEquals(expectedPostLikes, result);
	}

	/**
	 * Test get post writter.
	 */
	@Test
	public void testGetPostWritter() {
		// Act
		final PersonDTO result = this.expectedPostDTO.getPostWritter();
		// Assert
		Assert.assertEquals(expectedPostWritter, result);
	}

	/**
	 * Test set id.
	 */
	@Test
	public void testSetId() {
		// Arrange
		final PostDTO post = new PostDTO();
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
		final PostDTO post = new PostDTO();
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
		final PostDTO post = new PostDTO();
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
		final PostDTO post = new PostDTO();
		// Act
		post.setPostType(expectedType);
		// Assert
		Assert.assertEquals(expectedType, post.getPostType());
	}

	/**
	 * Test set picture.
	 */
	@Test
	public void testSetPicture() {
		// Arrange
		final PostDTO post = new PostDTO();
		// Act
		post.setPicture(expectedPicture);
		// Assert
		Assert.assertEquals(expectedPicture, post.getPicture());
	}

	/**
	 * Test set post of like.
	 */
	@Test
	public void testSetPostLikes() {
		// Arrange
		final PostDTO post = new PostDTO();
		// Act
		post.setPostLikes(expectedPostLikes);
		// Assert
		Assert.assertEquals(expectedPostLikes, post.getPostLikes());
	}

	/**
	 * Test set post writter.
	 */
	@Test
	public void testSetPostWritter() {
		// Arrange
		final PostDTO post = new PostDTO();
		// Act
		post.setPostWritter(expectedPostWritter);
		// Assert
		Assert.assertEquals(expectedPostWritter, post.getPostWritter());
	}
}