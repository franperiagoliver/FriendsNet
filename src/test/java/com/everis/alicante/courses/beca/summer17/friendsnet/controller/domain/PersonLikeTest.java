/*
 * Created at 30-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.everis.alicante.courses.beca.summer17.friendsnet.controller.domain.PersonLikeDTO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.enums.LikeType;

/**
 * The Class PersonLikeTest.
 */
public class PersonLikeTest {

	/** The expected person like. */
	private PersonLikeDTO expectedPersonLike;

	/** The expected id. */
	private Long expectedId = 1L;

	/** The expected type. */
	private LikeType expectedType = LikeType.ANGRY;

	/**
	 * Inits the.
	 */
	@Before
	public void init() {
		this.expectedPersonLike = new PersonLikeDTO();
		this.expectedPersonLike.setIdPerson(expectedId);
		this.expectedPersonLike.setLikeType(expectedType);
	}

	/**
	 * Test person like.
	 */
	@Test
	public void testPersonLike() {
		// Assert
		Assert.assertNotNull(expectedPersonLike);
	}

	/**
	 * Test get id person.
	 */
	@Test
	public void testGetIdPerson() {
		// Act
		final Long result = this.expectedPersonLike.getIdPerson();
		// Assert
		Assert.assertEquals(expectedId, result);
	}

	/**
	 * Test get like type.
	 */
	@Test
	public void testGetLikeType() {
		// Act
		final LikeType result = this.expectedPersonLike.getLikeType();
		// Assert
		Assert.assertEquals(expectedType, result);
	}

	/**
	 * Test set id person.
	 */
	@Test
	public void testSetIdPerson() {
		// Arrange
		final PersonLikeDTO personLike = new PersonLikeDTO();
		// Act
		personLike.setIdPerson(expectedId);
		// Assert
		Assert.assertEquals(expectedId, personLike.getIdPerson());
	}

	/**
	 * Test set like type.
	 */
	@Test
	public void testSetLikeType() {
		// Arrange
		final PersonLikeDTO personLike = new PersonLikeDTO();
		// Act
		personLike.setLikeType(expectedType);
		// Assert
		Assert.assertEquals(expectedType, personLike.getLikeType());
	}
}