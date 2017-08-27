/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.enums.EventType;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.interfaces.FNEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class Event.
 */
@Entity
@Table(name = "event")
@Getter
@Setter
public class Event implements FNEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 339182197410746675L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Long id;

	/** The name. */
	@Lob
	@Column(nullable = false, length = 255)
	private String name;

	/** The starting date. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, length = 255)
	private Date startingDate;

	/** The ending date. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, length = 255)
	private Date endingDate;

	/** The type. */
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private EventType type;

	/** The picture. */
	@Lob
	@Column(nullable = false)
	private byte[] picture;

	/** The events. */
	@OneToMany(mappedBy = "postInEvent", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Post> posts = new HashSet<>();

	/** The person in event. */
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "person_id", nullable = false)
	@JsonIgnore
	private Person personInEvent;
}