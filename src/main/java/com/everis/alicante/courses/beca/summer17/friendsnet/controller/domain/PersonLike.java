/*
 * Created at 29-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller.domain;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.enums.LikeType;

import lombok.Getter;
import lombok.Setter;

/**
 * Gets the like type.
 *
 * @return the like type
 */
@Getter

/**
 * Sets the like type.
 *
 * @param likeType
 *            the new like type
 */
@Setter
public class PersonLike {

	/** The id person. */
	private Long idPerson;

	/** The like type. */
	private LikeType likeType;
}