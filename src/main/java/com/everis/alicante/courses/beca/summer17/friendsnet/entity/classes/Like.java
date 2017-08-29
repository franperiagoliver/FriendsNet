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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.enums.LikeType;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.interfaces.FNEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class Like.
 */
@Entity(name = "like_table")
@Table(name = "like_table")

/**
 * Gets the like of person.
 *
 * @return the like of person
 */
@Getter

/**
 * Sets the like of person.
 *
 * @param likeOfPerson
 *            the new like of person
 */
@Setter
public class Like implements FNEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2603648111651479873L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Long id;

	/** The creation date. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, length = 255)
	private Date creationDate;

	/** The type. */
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private LikeType type;

	/** The like of post. */
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "post_id", nullable = true)
	private Post likeOfPost;

	/** The like of person. */
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "person_id", nullable = true)
	private Person likeOfPerson;
}