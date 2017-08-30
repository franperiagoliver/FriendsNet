/*
 * Created at 30-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller.domain;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.enums.LikeType;

import lombok.Getter;
import lombok.Setter;

/**
 * Gets the person of like.
 *
 * @return the person of like
 */
@Getter

/**
 * Sets the person of like.
 *
 * @param PersonOfLike the new person of like
 */
@Setter
public class LikeDTO implements FNDTO {

	/** The like type. */
	private LikeType likeType;

	/** The like of person. */
	private PersonDTO PersonOfLike;
}