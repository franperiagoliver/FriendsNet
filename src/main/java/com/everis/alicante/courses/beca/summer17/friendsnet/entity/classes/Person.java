/*
 * Created at 24-ago-2017 by Fran Periago
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.interfaces.FNEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class Person.
 */
/**
 * Instantiates a new person.
 */
@Entity
@Table(name = "person")
@Getter
@Setter
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
	@OneToMany(mappedBy = "personInGroup", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Group> groups = new HashSet<Group>();

	/** The persons. */
	@OneToMany(mappedBy = "friends", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Person> friends = new HashSet<Person>();

	/** The like. */
	@OneToOne(mappedBy = "like", fetch = FetchType.EAGER)
	@JsonIgnore
	private Like like;

	/** The post. */
	@OneToOne(mappedBy = "post", fetch = FetchType.EAGER)
	@JsonIgnore
	private Post post;

	/** The events. */
	@OneToMany(mappedBy = "personInEvent", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Event> events = new HashSet<Event>();
}