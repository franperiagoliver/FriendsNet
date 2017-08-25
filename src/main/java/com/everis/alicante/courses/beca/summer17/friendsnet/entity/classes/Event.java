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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.enums.EventType;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.interfaces.FNEntity;

/**
 * The Class Event.
 */
@Entity
@Table(name = "Event")
public class Event implements FNEntity {
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

	/** The post. */
	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "id", nullable = false)
	private Post post;

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
	 * Gets the starting date.
	 *
	 * @return the starting date
	 */
	public Date getStartingDate() {
		return startingDate;
	}

	/**
	 * Sets the starting date.
	 *
	 * @param startingDate
	 *            the new starting date
	 */
	public void setStartingDate(final Date startingDate) {
		this.startingDate = startingDate;
	}

	/**
	 * Gets the ending date.
	 *
	 * @return the ending date
	 */
	public Date getEndingDate() {
		return endingDate;
	}

	/**
	 * Sets the ending date.
	 *
	 * @param endingDate
	 *            the new ending date
	 */
	public void setEndingDate(final Date endingDate) {
		this.endingDate = endingDate;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public EventType getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type
	 *            the new type
	 */
	public void setType(final EventType type) {
		this.type = type;
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

}