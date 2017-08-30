/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller.dto;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.everis.alicante.courses.beca.summer17.friendsnet.controller.domain.GroupDTO;

/**
 * The Class PersonTest.
 */
public class GroupDTOTest {

	/** The expected person. */
	private GroupDTO expectedGroupDTO;

	/** The expected id. */
	private Long expectedId = 1L;

	/** The expected name. */
	private String expectedName = "Group";

	/** The expected picture. */
	private byte[] expectedPicture = null;

	/**
	 * Inits the.
	 */
	@Before
	public void init() {
		this.expectedGroupDTO = new GroupDTO();
		this.expectedGroupDTO.setId(expectedId);
		this.expectedGroupDTO.setName(expectedName);
		this.expectedGroupDTO.setPicture(expectedPicture);
	}

	/**
	 * Test person.
	 */
	@Test
	public void testGroupDTO() {
		// Assert
		Assert.assertNotNull(expectedGroupDTO);
	}

	/**
	 * Test get id.
	 */
	@Test
	public void testGetId() {
		// Act
		final Long result = this.expectedGroupDTO.getId();
		// Assert
		Assert.assertEquals(expectedId, result);
	}

	/**
	 * Test set id.
	 */
	@Test
	public void testSetId() {
		// Arrange
		final GroupDTO group = new GroupDTO();
		// Act
		group.setId(expectedId);
		// Assert
		Assert.assertEquals(expectedId, group.getId());
	}

	/**
	 * Test get name.
	 */
	@Test
	public void testGetName() {
		// Act
		final String result = this.expectedGroupDTO.getName();
		// Assert
		Assert.assertEquals(expectedName, result);
	}

	/**
	 * Test set name.
	 */
	@Test
	public void testSetName() {
		// Arrange
		final GroupDTO group = new GroupDTO();
		// Act
		group.setName(expectedName);
		// Assert
		Assert.assertEquals(expectedName, group.getName());
	}

	/**
	 * Test get picture.
	 */
	@Test
	public void testGetPicture() {
		// Act
		final byte[] result = this.expectedGroupDTO.getPicture();
		// Assert
		Assert.assertEquals(expectedPicture, result);
	}

	/**
	 * Test set picture.
	 */
	@Test
	public void testSetPicture() {
		// Arrange
		final GroupDTO group = new GroupDTO();
		// Act
		group.setPicture(expectedPicture);
		// Assert
		Assert.assertEquals(expectedPicture, group.getPicture());
	}
}