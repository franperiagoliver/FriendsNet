/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller.dto;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.everis.alicante.courses.beca.summer17.friendsnet.controller.domain.dto.EventDTO;
import com.everis.alicante.courses.beca.summer17.friendsnet.controller.domain.dto.GroupDTO;
import com.everis.alicante.courses.beca.summer17.friendsnet.controller.domain.dto.PersonDTO;

/**
 * The Class PersonTest.
 */
public class PersonDTOTest {

	/** The expected person. */
	private PersonDTO expectedPersonDTO;

	/** The expected id. */
	private Long expectedId = 1L;

	/** The expected name. */
	private String expectedName = "Jerry";

	/** The expected surname. */
	private String expectedSurname = "Tom";

	/** The expected picture. */
	private byte[] expectedPicture = null;

	/** The expected groups. */
	private Set<GroupDTO> expectedGroups = new HashSet<>();

	/** The expected persons. */
	private Set<PersonDTO> expectedFriends = new HashSet<>();

	/** The expected events. */
	private Set<EventDTO> expectedEvents = new HashSet<>();

	/**
	 * Inits the.
	 */
	@Before
	public void init() {
		this.expectedPersonDTO = new PersonDTO();
		this.expectedPersonDTO.setEvents(expectedEvents);
		this.expectedPersonDTO.setGroups(expectedGroups);
		this.expectedPersonDTO.setId(expectedId);
		this.expectedPersonDTO.setName(expectedName);
		this.expectedPersonDTO.setSurname(expectedSurname);
		this.expectedPersonDTO.setPicture(expectedPicture);
		this.expectedPersonDTO.setFriends(expectedFriends);
	}

	/**
	 * Test person.
	 */
	@Test
	public void testPerson() {
		// Assert
		Assert.assertNotNull(expectedPersonDTO);
	}

	/**
	 * Test get id.
	 */
	@Test
	public void testGetId() {
		// Act
		final Long result = this.expectedPersonDTO.getId();
		// Assert
		Assert.assertEquals(expectedId, result);
	}

	/**
	 * Test set id.
	 */
	@Test
	public void testSetId() {
		// Arrange
		final PersonDTO person = new PersonDTO();
		// Act
		person.setId(expectedId);
		// Assert
		Assert.assertEquals(expectedId, person.getId());
	}

	/**
	 * Test get name.
	 */
	@Test
	public void testGetName() {
		// Act
		final String result = this.expectedPersonDTO.getName();
		// Assert
		Assert.assertEquals(expectedName, result);
	}

	/**
	 * Test set name.
	 */
	@Test
	public void testSetName() {
		// Arrange
		final PersonDTO person = new PersonDTO();
		// Act
		person.setName(expectedName);
		// Assert
		Assert.assertEquals(expectedName, person.getName());
	}

	/**
	 * Test get surname.
	 */
	@Test
	public void testGetSurname() {
		// Act
		final String result = this.expectedPersonDTO.getSurname();
		// Assert
		Assert.assertEquals(expectedSurname, result);
	}

	/**
	 * Test set surname.
	 */
	@Test
	public void testSetSurname() {
		// Arrange
		final PersonDTO person = new PersonDTO();
		// Act
		person.setSurname(expectedSurname);
		// Assert
		Assert.assertEquals(expectedSurname, person.getSurname());
	}

	/**
	 * Test get picture.
	 */
	@Test
	public void testGetPicture() {
		// Act
		final byte[] result = this.expectedPersonDTO.getPicture();
		// Assert
		Assert.assertEquals(expectedPicture, result);
	}

	/**
	 * Test set picture.
	 */
	@Test
	public void testSetPicture() {
		// Arrange
		final PersonDTO person = new PersonDTO();
		// Act
		person.setPicture(expectedPicture);
		// Assert
		Assert.assertEquals(expectedPicture, person.getPicture());
	}

	/**
	 * Test get persons.
	 */
	@Test
	public void testGetPersons() {
		// Act
		final Set<PersonDTO> result = this.expectedPersonDTO.getFriends();
		// Assert
		Assert.assertEquals(expectedFriends, result);
	}

	/**
	 * Test set persons.
	 */
	@Test
	public void testSetPersons() {
		// Arrange
		final PersonDTO person = new PersonDTO();
		// Act
		person.setFriends(expectedFriends);
		// Assert
		Assert.assertEquals(expectedFriends, person.getFriends());
	}

	/**
	 * Test get groups.
	 */
	@Test
	public void testGetGroups() {
		// Act
		final Set<GroupDTO> result = this.expectedPersonDTO.getGroups();
		// Assert
		Assert.assertEquals(expectedGroups, result);
	}

	/**
	 * Test set groups.
	 */
	@Test
	public void testSetGroups() {
		// Arrange
		final PersonDTO person = new PersonDTO();
		// Act
		person.setGroups(expectedGroups);
		// Assert
		Assert.assertEquals(expectedGroups, person.getGroups());
	}

	/**
	 * Test get events.
	 */
	@Test
	public void testGetEvents() {
		// Act
		final Set<EventDTO> result = this.expectedPersonDTO.getEvents();
		// Assert
		Assert.assertEquals(expectedEvents, result);
	}

	/**
	 * Test set events.
	 */
	@Test
	public void testSetEvents() {
		// Arrange
		final PersonDTO person = new PersonDTO();
		// Act
		person.setEvents(expectedEvents);
		// Assert
		Assert.assertEquals(expectedEvents, person.getEvents());
	}
}