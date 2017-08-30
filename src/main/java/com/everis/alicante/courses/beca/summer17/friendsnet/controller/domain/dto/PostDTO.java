/*
 * Created at 30-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller.domain.dto;

import java.util.Date;
import java.util.Set;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.enums.PostType;

import lombok.Getter;
import lombok.Setter;

/**
 * Gets the post likes.
 *
 * @return the post likes
 */

/**
 * Gets the post type.
 *
 * @return the post type
 */

/**
 * Gets the post type.
 *
 * @return the post type
 */

/**
 * Gets the post type.
 *
 * @return the post type
 */
@Getter

/**
 * Sets the post likes.
 *
 * @param postLikes
 *            the new post likes
 */

/**
 * Sets the post type.
 *
 * @param postType
 *            the new post type
 */

/**
 * Sets the post type.
 *
 * @param postType
 *            the new post type
 */

/**
 * Sets the post type.
 *
 * @param postType
 *            the new post type
 */
@Setter
public class PostDTO {

	/** The id. */
	private Long id;

	/** The text. */
	private String text;

	/** The creation date. */
	private Date creationDate;

	/** The picture. */
	private byte[] picture;

	/** The post likes. */
	private Set<LikeDTO> postLikes;

	/** The post writter. */
	private PersonDTO postWritter;

	/** The post type. */
	private PostType postType;
}