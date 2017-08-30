/*
 * Created at 27-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.enums.EventType;

/**
 * The Class EventTest.
 */
public class EventTest {

	/** The expected event. */
	private Event expectedEvent;

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

	/** The expected posts. */
	private Set<Post> expectedPosts = new HashSet<>();

	/** The expected person in event. */
	private Set<Person> expectedPersonsInEvent = new HashSet<>();

	/**
	 * Inits the.
	 */
	@Before
	public void init() {
		this.expectedEvent = new Event();
		this.expectedEvent.setEndingDate(expectedEndingDate);
		this.expectedEvent.setId(expectedId);
		this.expectedEvent.setPicture(expectedPicture);
		this.expectedEvent.setName(expectedName);
		this.expectedEvent.setPersonsInEvent(expectedPersonsInEvent);
		this.expectedEvent.setPosts(expectedPosts);
		this.expectedEvent.setStartingDate(expectedStartingDate);
		this.expectedEvent.setType(expectedType);
	}

	/**
	 * Test event.
	 */
	@Test
	public void testEvent() {
		// Assert
		Assert.assertNotNull(expectedEvent);
	}

	/**
	 * Test get id.
	 */
	@Test
	public void testGetId() {
		// Act
		final Long result = this.expectedEvent.getId();
		// Assert
		Assert.assertEquals(expectedId, result);
	}

	/**
	 * Test get name.
	 */
	@Test
	public void testGetName() {
		// Act
		final String result = this.expectedEvent.getName();
		// Assert
		Assert.assertEquals(expectedName, result);
	}

	/**
	 * Test get starting date.
	 */
	@Test
	public void testGetStartingDate() {
		// Act
		final Date result = this.expectedEvent.getStartingDate();
		// Assert
		Assert.assertEquals(expectedStartingDate, result);
	}

	/**
	 * Test get ending date.
	 */
	@Test
	public void testGetEndingDate() {
		// Act
		final Date result = this.expectedEvent.getEndingDate();
		// Assert
		Assert.assertEquals(expectedEndingDate, result);
	}

	/**
	 * Test get type.
	 */
	@Test
	public void testGetType() {
		// Act
		final EventType result = this.expectedEvent.getType();
		// Assert
		Assert.assertEquals(expectedType, result);
	}

	/**
	 * Test get picture.
	 */
	@Test
	public void testGetPicture() {
		// Act
		final byte[] result = this.expectedEvent.getPicture();
		// Assert
		Assert.assertEquals(expectedPicture, result);
	}

	/**
	 * Test get posts.
	 */
	@Test
	public void testGetPosts() {
		// Act
		final Set<Post> result = this.expectedEvent.getPosts();
		// Assert
		Assert.assertEquals(expectedPosts, result);
	}

	/**
	 * Test get person in event.
	 */
	@Test
	public void testGetPersonsInEvent() {
		// Act
		final Set<Person> result = this.expectedEvent.getPersonsInEvent();
		// Assert
		Assert.assertEquals(expectedPersonsInEvent, result);
	}

	/**
	 * Test set id.
	 */
	@Test
	public void testSetId() {
		// Arrange
		final Event event = new Event();
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
		final Event event = new Event();
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
		final Event event = new Event();
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
		final Event event = new Event();
		// Act
		event.setEndingDate(expectedEndingDate);
		// Assert
		Assert.assertEquals(expectedEndingDate, event.getEndingDate());
	}

	/**
	 * Test set type.
	 */
	@Test
	public void testSetType() {
		// Arrange
		final Event event = new Event();
		// Act
		event.setType(expectedType);
		// Assert
		Assert.assertEquals(expectedType, event.getType());
	}

	/**
	 * Test set picture.
	 */
	@Test
	public void testSetPicture() {
		// Arrange
		final Event event = new Event();
		// Act
		event.setPicture(expectedPicture);
		// Assert
		Assert.assertEquals(expectedPicture, event.getPicture());
	}

	/**
	 * Test set posts.
	 */
	@Test
	public void testSetPosts() {
		// Arrange
		final Event event = new Event();
		// Act
		event.setPosts(expectedPosts);
		// Assert
		Assert.assertEquals(expectedPosts, event.getPosts());
	}

	/**
	 * Test set person in event.
	 */
	@Test
	public void testSetPersonsInEvent() {
		// Arrange
		final Event event = new Event();
		// Act
		event.setPersonsInEvent(expectedPersonsInEvent);
		// Assert
		Assert.assertEquals(expectedPersonsInEvent, event.getPersonsInEvent());
	}
}