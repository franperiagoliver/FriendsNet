/*
 * Created at 27-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.entity.tests;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Like;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Post;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.enums.LikeType;

/**
 * The Class LikeTest.
 */
public class LikeTest {

	/** The expected like. */
	private Like expectedLike;

	/** The expected id. */
	private Long expectedId = 1L;

	/** The expected creation date. */
	private Date expectedCreationDate = new Date();

	/** The expected type. */
	private LikeType expectedType = LikeType.COOL;

	/** The expected post like. */
	private Post expectedLikeofPost = new Post();

	/** The expected person like. */
	private Person expectedLiker = new Person();

	/**
	 * Inits the.
	 */
	@Before
	public void init() {
		this.expectedLike = new Like();
		this.expectedLike.setCreationDate(expectedCreationDate);
		this.expectedLike.setId(expectedId);
		this.expectedLike.setLikeOfPerson(expectedLiker);
		this.expectedLike.setLikeOfPost(expectedLikeofPost);
		this.expectedLike.setType(expectedType);
	}

	/**
	 * Test get id.
	 */
	@Test
	public void testGetId() {
		// Act
		final Long result = this.expectedLike.getId();
		// Assert
		Assert.assertEquals(expectedId, result);
	}

	/**
	 * Test get creation date.
	 */
	@Test
	public void testGetCreationDate() {
		// Act
		final Date result = this.expectedLike.getCreationDate();
		// Assert
		Assert.assertEquals(expectedCreationDate, result);
	}

	/**
	 * Test get type.
	 */
	@Test
	public void testGetType() {
		// Act
		final LikeType result = this.expectedLike.getType();
		// Assert
		Assert.assertEquals(expectedType, result);
	}

	/**
	 * Test get post like.
	 */
	@Test
	public void testGetPostLike() {
		// Act
		final Post result = this.expectedLike.getLikeOfPost();
		// Assert
		Assert.assertEquals(expectedLikeofPost, result);
	}

	/**
	 * Test get person like.
	 */
	@Test
	public void testGetPersonLike() {
		// Act
		final Person result = this.expectedLike.getLikeOfPerson();
		// Assert
		Assert.assertEquals(expectedLiker, result);
	}

	/**
	 * Test set id.
	 */
	@Test
	public void testSetId() {
		// Arrange
		final Like like = new Like();
		// Act
		like.setId(expectedId);
		// Assert
		Assert.assertEquals(expectedId, like.getId());
	}

	/**
	 * Test set creation date.
	 */
	@Test
	public void testSetCreationDate() {
		// Arrange
		final Like like = new Like();
		// Act
		like.setCreationDate(expectedCreationDate);
		// Assert
		Assert.assertEquals(expectedCreationDate, like.getCreationDate());
	}

	/**
	 * Test set type.
	 */
	@Test
	public void testSetType() {
		// Arrange
		final Like like = new Like();
		// Act
		like.setType(expectedType);
		// Assert
		Assert.assertEquals(expectedType, like.getType());
	}

	/**
	 * Test set post like.
	 */
	@Test
	public void testSetPostLike() {
		// Arrange
		final Like like = new Like();
		// Act
		like.setLikeOfPost(expectedLikeofPost);
		// Assert
		Assert.assertEquals(expectedLikeofPost, like.getLikeOfPost());
	}

	/**
	 * Test set person like.
	 */
	@Test
	public void testSetPersonLike() {
		// Arrange
		final Like like = new Like();
		// Act
		like.setLikeOfPerson(expectedLiker);
		// Assert
		Assert.assertEquals(expectedLiker, like.getLikeOfPerson());
	}

	/**
	 * Test like.
	 */
	@Test
	public void testLike() {
		// Assert
		Assert.assertNotNull(expectedLike);
	}
}