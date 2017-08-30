/*
 * Created at 24-ago-2017 by Fran Periago
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class Person.
 */

@Entity
@Table(name = "person")

/**
 * Gets the events.
 *
 * @return the events
 */
@Getter

/**
 * Sets the events.
 *
 * @param events
 *            the new events
 */
@Setter
@EqualsAndHashCode(callSuper = false, exclude = { "friends", "groups", "events", "likes", "posts", "friendsOfFriends" })
public class Person implements FNEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4374421059150417639L;

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
	@Column(nullable = true)
	private byte[] picture;

	/** The group. */
	@ManyToMany(mappedBy = "personsInGroups", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Group> groups = new HashSet<>();

	/** The persons. */
	@ManyToMany(mappedBy = "friendsOfFriends", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Person> friends = new HashSet<>();

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "friends", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "friend_id") })
	@JsonIgnore
	private Set<Person> friendsOfFriends;

	/** The like. */
	@OneToMany(mappedBy = "likeOfPerson", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Like> likes = new HashSet<>();

	/** The post. */
	@OneToMany(mappedBy = "postWritter", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Post> posts = new HashSet<>();

	/** The events. */
	@OneToMany(mappedBy = "personInEvent", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Event> events = new HashSet<>();
}