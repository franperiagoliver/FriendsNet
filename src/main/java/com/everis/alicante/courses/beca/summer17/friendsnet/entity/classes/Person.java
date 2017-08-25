/*
 * Created at 24-ago-2017 by Fran Periago
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes;

import java.util.Set;

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
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;

/**
 * The Class Person.
 */
/**
 * @author Fran Durero
 *
 */
@Entity
@Table(name = "person")
public class Person implements FNEntity {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
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
	@OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Group> groups;

	/** The persons. */
	@OneToMany(mappedBy = "persons", fetch = FetchType.LAZY)
	@Getter(lazy = true)
	@JsonIgnore
	private Set<Person> persons;

	/** The like. */
	@OneToOne(mappedBy = "person", fetch = FetchType.EAGER)
	@JsonIgnore
	private Like like;

	/** The post. */
	@OneToOne(mappedBy = "person", fetch = FetchType.EAGER)
	@JsonIgnore
	private Post post;

	/** The events. */
	@OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Event> events;

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
	public void setId(final Long id) {
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
	public void setName(final String name) {
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
	public void setSurname(final String surname) {
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
	public void setPicture(final byte[] picture) {
		this.picture = picture;
	}

	/**
	 * Gets the persons.
	 *
	 * @return the persons
	 */
	public Set<Person> getPersons() {
		return persons;
	}

	/**
	 * Sets the persons.
	 *
	 * @param persons
	 *            the new persons
	 */
	public void setPersons(final Set<Person> persons) {
		this.persons = persons;
	}

	/**
	 * Gets the groups.
	 *
	 * @return the groups
	 */
	public Set<Group> getGroups() {
		return groups;
	}

	/**
	 * Sets the groups.
	 *
	 * @param groups
	 *            the new groups
	 */
	public void setGroups(final Set<Group> groups) {
		this.groups = groups;
	}

	/**
	 * Gets the events.
	 *
	 * @return the events
	 */
	public Set<Event> getEvents() {
		return events;
	}

	/**
	 * Sets the events.
	 *
	 * @param events
	 *            the new events
	 */
	public void setEvents(final Set<Event> events) {
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
	public void setPost(final Post post) {
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
	public void setLike(final Like like) {
		this.like = like;
	}
}