/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes;

import java.util.Date;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.enums.PostType;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.interfaces.FNEntity;
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
@Getter
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
	@Column(nullable = false)
	private byte[] picture;

	/** The like. */
	@OneToOne(mappedBy = "likeOfPerson", fetch = FetchType.EAGER)
	@JsonIgnore
	private Like postOfLike;

	/** The Post person. */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "post_id", nullable = false)
	@JsonIgnore
	private Person postWritter;

	/** The event. */
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "event_id", nullable = false)
	@JsonIgnore
	private Event postInEvent;
}