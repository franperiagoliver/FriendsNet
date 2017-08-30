/*
 * Created at 27-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.everis.alicante.courses.beca.summer17.friendsnet.controller.domain.LikeDTO;
import com.everis.alicante.courses.beca.summer17.friendsnet.controller.domain.PersonDTO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.enums.LikeType;

/**
 * The Class LikeTest.
 */
public class LikeDTOTest {

	/** The expected like. */
	private LikeDTO expectedLikeDTO;

	/** The expected type. */
	private LikeType expectedType = LikeType.COOL;

	/** The expected person like. */
	private PersonDTO expectedPersonOfLike = new PersonDTO();

	/**
	 * Inits the.
	 */
	@Before
	public void init() {
		this.expectedLikeDTO = new LikeDTO();
		this.expectedLikeDTO.setPersonOfLike(expectedPersonOfLike);
		this.expectedLikeDTO.setLikeType(expectedType);
	}

	/**
	 * Test get type.
	 */
	@Test
	public void testGetType() {
		// Act
		final LikeType result = this.expectedLikeDTO.getLikeType();
		// Assert
		Assert.assertEquals(expectedType, result);
	}

	/**
	 * Test get person like.
	 */
	@Test
	public void testGetPersonOfLike() {
		// Act
		final PersonDTO result = this.expectedLikeDTO.getPersonOfLike();
		// Assert
		Assert.assertEquals(expectedPersonOfLike, result);
	}

	/**
	 * Test set type.
	 */
	@Test
	public void testSetLikeType() {
		// Arrange
		final LikeDTO like = new LikeDTO();
		// Act
		like.setLikeType(expectedType);
		// Assert
		Assert.assertEquals(expectedType, like.getLikeType());
	}

	/**
	 * Test set person like.
	 */
	@Test
	public void testSetPersonOfLike() {
		// Arrange
		final LikeDTO like = new LikeDTO();
		// Act
		like.setPersonOfLike(expectedPersonOfLike);
		// Assert
		Assert.assertEquals(expectedPersonOfLike, like.getPersonOfLike());
	}

	/**
	 * Test like.
	 */
	@Test
	public void testLikeDTO() {
		// Assert
		Assert.assertNotNull(expectedLikeDTO);
	}
}