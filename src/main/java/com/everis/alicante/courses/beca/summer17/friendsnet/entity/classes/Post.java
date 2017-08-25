/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes;

import java.util.Date;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.enums.PostType;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.interfaces.FNEntity;

/**
 * The Class Post.
 */
@Entity
@Table(name = "Post")
public class Post implements FNEntity {

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

	/** The events. */
	@OneToMany(mappedBy = "Event", fetch = FetchType.EAGER)
	private Iterable<Event> events;

	/** The like. */
	@OneToOne(mappedBy = "Like", fetch = FetchType.EAGER)
	@JoinColumn(name = "id", nullable = false)
	private Like like;

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
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text.
	 *
	 * @param text
	 *            the new text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Gets the creation date.
	 *
	 * @return the creation date
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * Sets the creation date.
	 *
	 * @param creationDate
	 *            the new creation date
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public PostType getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type
	 *            the new type
	 */
	public void setType(PostType type) {
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
	public void setPicture(byte[] picture) {
		this.picture = picture;
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