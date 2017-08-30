/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.entity;

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

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.enums.PostType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class Post.
 */
/**
 * Instantiates a new post.
 */
/**
 * Instantiates a new post.
 */
@Entity
@Table(name = "post")

/**
 * Gets the post in event.
 *
 * @return the post in event
 */
@Getter

/**
 * Sets the post in event.
 *
 * @param postInEvent
 *            the new post in event
 */
@Setter
public class Post implements FNEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -190387273503499471L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Long id;

	/** The text. */
	@Lob
	@Column(nullable = false, length = 255)
	private String text;

	/** The creation date. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, length = 255)
	private Date creationDate;

	/** The type. */
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private PostType type;

	/** The picture. */
	@Lob
	@Column(nullable = true)
	private byte[] picture;

	/** The like. */
	@OneToMany(mappedBy = "likeOfPost", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Like> postLikes = new HashSet<>();

	/** The Post person. */
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "post_id", nullable = true)
	@JsonIgnore
	private Person postWritter;

	/** The event. */
	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "event_id", nullable = true)
	@JsonIgnore
	private Event postInEvent;
}