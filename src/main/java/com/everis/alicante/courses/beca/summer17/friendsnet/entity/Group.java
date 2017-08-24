/*
 * Created at 24-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.FNEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class Group.
 */
@Getter
@Setter
@Entity
public class Group implements FNEntity {
	
	/** The id. */
	@Id
	private Long id;
	
	/** The name. */
	private String name;
	
	/** The picture. */
	private byte[] picture;
	
}