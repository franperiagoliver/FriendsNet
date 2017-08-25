/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.entity.test;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Event;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Group;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Like;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Post;

/**
 * The Class PersonTest.
 */
public class PersonTest {

	/** The expected person. */
	private Person expectedPerson;

	/** The expected id. */
	private Long expectedId = 1L;

	/** The expected name. */
	private String expectedName = "";

	/** The expected surname. */
	private String expectedSurname = "";

	/** The expected picture. */
	private byte[] expectedPicture = null;

	/** The expected groups. */
	private Iterable<Group> expectedGroups = new HashSet<Group>();

	/** The expected persons. */
	private Iterable<Person> expectedPersons = new HashSet<Person>();

	/** The expected events. */
	private Iterable<Event> expectedEvents = new HashSet<Event>();

	/** The expected like. */
	private Like expectedLike = new Like();

	/** The expected post. */
	private Post expectedPost = new Post();

	/**
	 * Inits the.
	 */
	@Before
	public void init() {
		this.expectedPerson = new Person();
		this.expectedPerson.setEvents(expectedEvents);
		this.expectedPerson.setGroups(expectedGroups);
		this.expectedPerson.setId(expectedId);
		this.expectedPerson.setLike(expectedLike);
		this.expectedPerson.setName(expectedName);
		this.expectedPerson.setSurname(expectedSurname);
		this.expectedPerson.setPersons(expectedPersons);
		this.expectedPerson.setPicture(expectedPicture);
		this.expectedPerson.setPost(expectedPost);
	}

	/**
	 * Test person.
	 */
	@Test
	public void testPerson() {
		// Assert
		Assert.assertNotNull(expectedPerson);
	}

	/**
	 * Test get id.
	 */
	@Test
	public void testGetId() {
		// Act
		final Long result = this.expectedPerson.getId();
		// Assert
		Assert.assertEquals(expectedId, result);
	}

	/**
	 * Test set id.
	 */
	@Test
	public void testSetId() {
		// Arrange
		final Person person = new Person();
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
		final String result = this.expectedPerson.getName();
		// Assert
		Assert.assertEquals(expectedName, result);
	}

	/**
	 * Test set name.
	 */
	@Test
	public void testSetName() {
		// Arrange
		final Person person = new Person();
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
		final String result = this.expectedPerson.getSurname();
		// Assert
		Assert.assertEquals(expectedSurname, result);
	}

	/**
	 * Test set surname.
	 */
	@Test
	public void testSetSurname() {
		// Arrange
		final Person person = new Person();
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
		final byte[] result = this.expectedPerson.getPicture();
		// Assert
		Assert.assertEquals(expectedPicture, result);
	}

	/**
	 * Test set picture.
	 */
	@Test
	public void testSetPicture() {
		// Arrange
		final Person person = new Person();
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
		final Iterable<Person> result = this.expectedPerson.getPersons();
		// Assert
		Assert.assertEquals(expectedPersons, result);
	}

	/**
	 * Test set persons.
	 */
	@Test
	public void testSetPersons() {
		// Arrange
		final Person person = new Person();
		// Act
		person.setPersons(expectedPersons);
		// Assert
		Assert.assertEquals(expectedPersons, person.getPersons());
	}

	/**
	 * Test get groups.
	 */
	@Test
	public void testGetGroups() {
		// Act
		final Iterable<Group> result = this.expectedPerson.getGroups();
		// Assert
		Assert.assertEquals(expectedGroups, result);
	}

	/**
	 * Test set groups.
	 */
	@Test
	public void testSetGroups() {
		// Arrange
		final Person person = new Person();
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
		final Iterable<Event> result = this.expectedPerson.getEvents();
		// Assert
		Assert.assertEquals(expectedEvents, result);
	}

	/**
	 * Test set events.
	 */
	@Test
	public void testSetEvents() {
		// Arrange
		final Person person = new Person();
		// Act
		person.setEvents(expectedEvents);
		// Assert
		Assert.assertEquals(expectedEvents, person.getEvents());
	}

	/**
	 * Test get post.
	 */
	@Test
	public void testGetPost() {
		// Act
		final Post result = this.expectedPerson.getPost();
		// Assert
		Assert.assertEquals(expectedPost, result);
	}

	/**
	 * Test set post.
	 */
	@Test
	public void testSetPost() {
		// Arrange
		final Person person = new Person();
		// Act
		person.setPost(expectedPost);
		// Assert
		Assert.assertEquals(expectedPost, person.getPost());
	}

	/**
	 * Test get like.
	 */
	@Test
	public void testGetLike() {
		// Act
		final Like result = this.expectedPerson.getLike();
		// Assert
		Assert.assertEquals(expectedLike, result);
	}

	/**
	 * Test set like.
	 */
	@Test
	public void testSetLike() {
		// Arrange
		final Person person = new Person();
		// Act
		person.setLike(expectedLike);
		// Assert
		Assert.assertEquals(expectedLike, person.getLike());
	}
}