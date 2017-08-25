/*
 * Created at 24-ago-2017 by Fran Periago
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.interfaces.FNEntity;

/**
 * The Class Person.
 */
/**
 * @author Fran Durero
 *
 */
@Entity
@Table(name = "Person")
public class Person implements FNEntity {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Long id;

	/** The name. */
	@Lob
	@Column(nullable = false, length = 255)
	private String name;

	/** The surname. */
	@Lob
	@Column(nullable = false, length = 255)
	private String surname;

	/** The picture. */
	@Lob
	@Column(nullable = false)
	private byte[] picture;

	/** The group. */
	@OneToMany(mappedBy = "Group", fetch = FetchType.EAGER)
	private Iterable<Group> groups;

	/** The persons. */
	@OneToMany(mappedBy = "Person", fetch = FetchType.EAGER)
	private Iterable<Person> persons;

	/** The like. */
	@OneToOne(mappedBy = "Like", fetch = FetchType.EAGER)
	@JoinColumn(name = "id", nullable = false)
	private Like like;

	/** The post. */
	@OneToOne(mappedBy = "Post", fetch = FetchType.EAGER)
	@JoinColumn(name = "id", nullable = false)
	private Post post;

	/** The events. */
	@OneToMany(mappedBy = "Event", fetch = FetchType.EAGER)
	private Iterable<Event> events;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the surname.
	 *
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Sets the surname.
	 *
	 * @param surname
	 *            the new surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * Gets the picture.
	 *
	 * @return the picture
	 */
	public byte[] getPicture() {
		return picture;
	}

	/**
	 * Sets the picture.
	 *
	 * @param picture
	 *            the new picture
	 */
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	/**
	 * Gets the persons.
	 *
	 * @return the persons
	 */
	public Iterable<Person> getPersons() {
		return persons;
	}

	/**
	 * Sets the persons.
	 *
	 * @param persons
	 *            the new persons
	 */
	public void setPersons(Iterable<Person> persons) {
		this.persons = persons;
	}

	/**
	 * Gets the groups.
	 *
	 * @return the groups
	 */
	public Iterable<Group> getGroups() {
		return groups;
	}

	/**
	 * Sets the groups.
	 *
	 * @param groups
	 *            the new groups
	 */
	public void setGroups(Iterable<Group> groups) {
		this.groups = groups;
	}

	/**
	 * Gets the events.
	 *
	 * @return the events
	 */
	public Iterable<Event> getEvents() {
		return events;
	}

	/**
	 * Sets the events.
	 *
	 * @param events
	 *            the new events
	 */
	public void setEvents(Iterable<Event> events) {
		this.events = events;
	}

	/**
	 * Gets the post.
	 *
	 * @return the post
	 */
	public Post getPost() {
		return post;
	}

	/**
	 * Sets the post.
	 *
	 * @param post
	 *            the new post
	 */
	public void setPost(Post post) {
		this.post = post;
	}

	/**
	 * Gets the like.
	 *
	 * @return the like
	 */
	public Like getLike() {
		return like;
	}

	/**
	 * Sets the like.
	 *
	 * @param like
	 *            the new like
	 */
	public void setLike(Like like) {
		this.like = like;
	}
}