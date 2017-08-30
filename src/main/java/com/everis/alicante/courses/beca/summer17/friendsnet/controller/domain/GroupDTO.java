/*
 * Created at 30-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Gets the picture.
 *
 * @return the picture
 */
@Getter

/**
 * Sets the picture.
 *
 * @param picture
 *            the new picture
 */
@Setter
public class GroupDTO implements FNDTO {

	/** The id. */
	private Long id;

	/** The name. */
	private String name;

	/** The picture. */
	private byte[] picture;
}