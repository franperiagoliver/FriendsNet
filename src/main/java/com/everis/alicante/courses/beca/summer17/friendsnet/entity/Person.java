/*
 * Created at 24-ago-2017 by Fran Periago
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class Person.
 */
@Getter
@Setter
@Entity
public class Person {
	
	/** The id. */
	@Id
	private Long id;
	
	/** The name. */
	private String name;
	
	/** The surname. */
	private String surname;
	
	/** The picture. */
	private byte[] picture;
}
