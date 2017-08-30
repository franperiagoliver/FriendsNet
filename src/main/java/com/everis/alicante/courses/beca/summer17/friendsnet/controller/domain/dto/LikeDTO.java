/*
 * Created at 30-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller.domain.dto;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.enums.LikeType;

import lombok.Getter;
import lombok.Setter;

/**
 * Gets the like of person.
 *
 * @return the like of person
 */

/**
 * Gets the person of like.
 *
 * @return the person of like
 */
@Getter

/**
 * Sets the like of person.
 *
 * @param likeOfPerson
 *            the new like of person
 */

/**
 * Sets the person of like.
 *
 * @param PersonOfLike
 *            the new person of like
 */
@Setter
public class LikeDTO {

	/** The like type. */
	private LikeType likeType;

	/** The like of person. */
	private PersonDTO PersonOfLike;
}