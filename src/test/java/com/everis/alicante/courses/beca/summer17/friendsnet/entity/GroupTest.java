/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.entity;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The Class PersonTest.
 */
public class GroupTest {

	/** The expected person. */
	private Group expectedGroup;

	/** The expected id. */
	private Long expectedId = 1L;

	/** The expected name. */
	private String expectedName = "Group";

	/** The expected picture. */
	private byte[] expectedPicture = null;

	/** The expected person in group. */
	private Set<Person> expectedPersonsInGroups = new HashSet<>();

	/**
	 * Inits the.
	 */
	@Before
	public void init() {
		this.expectedGroup = new Group();
		this.expectedGroup.setId(expectedId);
		this.expectedGroup.setName(expectedName);
		this.expectedGroup.setPersonsInGroups(expectedPersonsInGroups);
		this.expectedGroup.setPicture(expectedPicture);
	}

	/**
	 * Test person.
	 */
	@Test
	public void testGroup() {
		// Assert
		Assert.assertNotNull(expectedGroup);
	}

	/**
	 * Test get id.
	 */
	@Test
	public void testGetId() {
		// Act
		final Long result = this.expectedGroup.getId();
		// Assert
		Assert.assertEquals(expectedId, result);
	}

	/**
	 * Test set id.
	 */
	@Test
	public void testSetId() {
		// Arrange
		final Group group = new Group();
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
		final String result = this.expectedGroup.getName();
		// Assert
		Assert.assertEquals(expectedName, result);
	}

	/**
	 * Test set name.
	 */
	@Test
	public void testSetName() {
		// Arrange
		final Group group = new Group();
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
		final byte[] result = this.expectedGroup.getPicture();
		// Assert
		Assert.assertEquals(expectedPicture, result);
	}

	/**
	 * Test set picture.
	 */
	@Test
	public void testSetPicture() {
		// Arrange
		final Group group = new Group();
		// Act
		group.setPicture(expectedPicture);
		// Assert
		Assert.assertEquals(expectedPicture, group.getPicture());
	}

	/**
	 * Test get person in group.
	 */
	@Test
	public void TestGetPersonsInGroup() {
		// Act
		final Set<Person> result = this.expectedGroup.getPersonsInGroups();
		// Assert
		Assert.assertEquals(expectedPersonsInGroups, result);
	}

	/**
	 * Test set person in group.
	 */
	@Test
	public void TestSetPersonsInGroup() {
		// Arrange
		final Group group = new Group();
		// Act
		group.setPersonsInGroups(expectedPersonsInGroups);
		// Assert
		Assert.assertEquals(expectedPersonsInGroups, group.getPersonsInGroups());
	}
}