/*
 * Created at 30-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller.domain;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

/**
 * Gets the events.
 *
 * @return the events
 */
@Getter

/**
 * Sets the events.
 *
 * @param events
 *            the new events
 */
@Setter
public class PersonDTO implements FNDTO {

	/** The id. */
	private Long id;

	/** The surname. */
	private String name, surname;

	/** The picture. */
	private byte[] picture;

	/** The friends. */
	private Set<PersonDTO> friends;

	/** The groups. */
	private Set<GroupDTO> groups;

	/** The events. */
	private Set<EventDTO> events;
}