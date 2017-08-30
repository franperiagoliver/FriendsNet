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
public class PersonTest {

	/** The expected person. */
	private Person expectedPerson;

	/** The expected id. */
	private Long expectedId = 1L;

	/** The expected name. */
	private String expectedName = "Jerry";

	/** The expected surname. */
	private String expectedSurname = "Tom";

	/** The expected picture. */
	private byte[] expectedPicture = null;

	/** The expected groups. */
	private Set<Group> expectedGroups = new HashSet<>();

	/** The expected persons. */
	private Set<Person> expectedFriends = new HashSet<>();

	/** The expected friends of friends. */
	private Set<Person> expectedFriendsOfFriends = new HashSet<>();

	/** The expected events. */
	private Set<Event> expectedEvents = new HashSet<>();

	/** The expected like. */
	private Set<Like> expectedLikes = new HashSet<>();

	/** The expected post. */
	private Set<Post> expectedPosts = new HashSet<>();

	/**
	 * Inits the.
	 */
	@Before
	public void init() {
		this.expectedPerson = new Person();
		this.expectedPerson.setEvents(expectedEvents);
		this.expectedPerson.setGroups(expectedGroups);
		this.expectedPerson.setId(expectedId);
		this.expectedPerson.setLikes(expectedLikes);
		this.expectedPerson.setName(expectedName);
		this.expectedPerson.setSurname(expectedSurname);
		this.expectedPerson.setPicture(expectedPicture);
		this.expectedPerson.setPosts(expectedPosts);
		this.expectedPerson.setFriends(expectedFriends);
		this.expectedPerson.setFriendsOfFriends(expectedFriendsOfFriends);
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
		final Set<Person> result = this.expectedPerson.getFriends();
		// Assert
		Assert.assertEquals(expectedFriends, result);
	}

	/**
	 * Test set persons.
	 */
	@Test
	public void testSetPersons() {
		// Arrange
		final Person person = new Person();
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
		final Set<Group> result = this.expectedPerson.getGroups();
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
		final Set<Event> result = this.expectedPerson.getEvents();
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
	public void testGetPosts() {
		// Act
		final Set<Post> result = this.expectedPerson.getPosts();
		// Assert
		Assert.assertEquals(expectedPosts, result);
	}

	/**
	 * Test set post.
	 */
	@Test
	public void testSetPosts() {
		// Arrange
		final Person person = new Person();
		// Act
		person.setPosts(expectedPosts);
		// Assert
		Assert.assertEquals(expectedPosts, person.getPosts());
	}

	/**
	 * Test get like.
	 */
	@Test
	public void testGetLikes() {
		// Act
		final Set<Like> result = this.expectedPerson.getLikes();
		// Assert
		Assert.assertEquals(expectedLikes, result);
	}

	/**
	 * Test set like.
	 */
	@Test
	public void testSetLikes() {
		// Arrange
		final Person person = new Person();
		// Act
		person.setLikes(expectedLikes);
		// Assert
		Assert.assertEquals(expectedLikes, person.getLikes());
	}

	/**
	 * Test get friends of fiends.
	 */
	@Test
	public void testGetFriendsOfFiends() {
		// Act
		final Set<Person> result = this.expectedPerson.getFriendsOfFriends();
		// Assert
		Assert.assertEquals(expectedFriendsOfFriends, result);
	}

	/**
	 * Test set friends of friends.
	 */
	@Test
	public void testSetFriendsOfFriends() {
		// Arrange
		final Person person = new Person();
		// Act
		person.setFriendsOfFriends(expectedFriendsOfFriends);
		// Assert
		Assert.assertEquals(expectedFriendsOfFriends, person.getFriendsOfFriends());
	}
}