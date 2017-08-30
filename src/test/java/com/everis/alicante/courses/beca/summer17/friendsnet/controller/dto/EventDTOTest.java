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

import com.everis.alicante.courses.beca.summer17.friendsnet.controller.domain.dto.EventDTO;
import com.everis.alicante.courses.beca.summer17.friendsnet.controller.domain.dto.PersonDTO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.enums.EventType;

/**
 * The Class EventTest.
 */
public class EventDTOTest {

	/** The expected event. */
	private EventDTO expectedEventDTO;

	/** The expected id. */
	private Long expectedId = 1L;

	/** The expected name. */
	private String expectedName = "Party";

	/** The expected starting date. */
	private Date expectedStartingDate = new Date();

	/** The expected ending date. */
	private Date expectedEndingDate = new Date();

	/** The expected type. */
	private EventType expectedType = EventType.PARTY;

	/** The expected picture. */
	private byte[] expectedPicture = null;

	/** The expected person in event. */
	private Set<PersonDTO> expectedPersonsInEvent = new HashSet();

	/**
	 * Inits the.
	 */
	@Before
	public void init() {
		this.expectedEventDTO = new EventDTO();
		this.expectedEventDTO.setEndingDate(expectedEndingDate);
		this.expectedEventDTO.setId(expectedId);
		this.expectedEventDTO.setPicture(expectedPicture);
		this.expectedEventDTO.setName(expectedName);
		this.expectedEventDTO.setPersonsInEvent(expectedPersonsInEvent);
		this.expectedEventDTO.setStartingDate(expectedStartingDate);
		this.expectedEventDTO.setEventType(expectedType);
	}

	/**
	 * Test event.
	 */
	@Test
	public void testEventDTO() {
		// Assert
		Assert.assertNotNull(expectedEventDTO);
	}

	/**
	 * Test get id.
	 */
	@Test
	public void testGetId() {
		// Act
		final Long result = this.expectedEventDTO.getId();
		// Assert
		Assert.assertEquals(expectedId, result);
	}

	/**
	 * Test get name.
	 */
	@Test
	public void testGetName() {
		// Act
		final String result = this.expectedEventDTO.getName();
		// Assert
		Assert.assertEquals(expectedName, result);
	}

	/**
	 * Test get starting date.
	 */
	@Test
	public void testGetStartingDate() {
		// Act
		final Date result = this.expectedEventDTO.getStartingDate();
		// Assert
		Assert.assertEquals(expectedStartingDate, result);
	}

	/**
	 * Test get ending date.
	 */
	@Test
	public void testGetEndingDate() {
		// Act
		final Date result = this.expectedEventDTO.getEndingDate();
		// Assert
		Assert.assertEquals(expectedEndingDate, result);
	}

	/**
	 * Test get type.
	 */
	@Test
	public void testGetEventType() {
		// Act
		final EventType result = this.expectedEventDTO.getEventType();
		// Assert
		Assert.assertEquals(expectedType, result);
	}

	/**
	 * Test get picture.
	 */
	@Test
	public void testGetPicture() {
		// Act
		final byte[] result = this.expectedEventDTO.getPicture();
		// Assert
		Assert.assertEquals(expectedPicture, result);
	}

	/**
	 * Test get person in event.
	 */
	@Test
	public void testGetPersonsInEvent() {
		// Act
		final Set<PersonDTO> result = this.expectedEventDTO.getPersonsInEvent();
		// Assert
		Assert.assertEquals(expectedPersonsInEvent, result);
	}

	/**
	 * Test set id.
	 */
	@Test
	public void testSetId() {
		// Arrange
		final EventDTO event = new EventDTO();
		// Act
		event.setId(expectedId);
		// Assert
		Assert.assertEquals(expectedId, event.getId());
	}

	/**
	 * Test set name.
	 */
	@Test
	public void testSetName() {
		// Arrange
		final EventDTO event = new EventDTO();
		// Act
		event.setName(expectedName);
		// Assert
		Assert.assertEquals(expectedName, event.getName());
	}

	/**
	 * Test set starting date.
	 */
	@Test
	public void testSetStartingDate() {
		// Arrange
		final EventDTO event = new EventDTO();
		// Act
		event.setStartingDate(expectedStartingDate);
		// Assert
		Assert.assertEquals(expectedStartingDate, event.getStartingDate());
	}

	/**
	 * Test set ending date.
	 */
	@Test
	public void testSetEndingDate() {
		// Arrange
		final EventDTO event = new EventDTO();
		// Act
		event.setEndingDate(expectedEndingDate);
		// Assert
		Assert.assertEquals(expectedEndingDate, event.getEndingDate());
	}

	/**
	 * Test set type.
	 */
	@Test
	public void testSetEventType() {
		// Arrange
		final EventDTO event = new EventDTO();
		// Act
		event.setEventType(expectedType);
		// Assert
		Assert.assertEquals(expectedType, event.getEventType());
	}

	/**
	 * Test set picture.
	 */
	@Test
	public void testSetPicture() {
		// Arrange
		final EventDTO event = new EventDTO();
		// Act
		event.setPicture(expectedPicture);
		// Assert
		Assert.assertEquals(expectedPicture, event.getPicture());
	}

	/**
	 * Test set person in event.
	 */
	@Test
	public void testSetPersonsInEvent() {
		// Arrange
		final EventDTO event = new EventDTO();
		// Act
		event.setPersonsInEvent(expectedPersonsInEvent);
		// Assert
		Assert.assertEquals(expectedPersonsInEvent, event.getPersonsInEvent());
	}
}