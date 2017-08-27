/*
 * Created at 24-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.interfaces.FNEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * The Class Group.
 */
/**
 * Instantiates a new group.
 */
/**
 * Instantiates a new group.
 */
@Entity(name = "group_table")
@Table(name = "group_table")
public @Data class Group implements FNEntity {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Long id;

	/** The name. */
	@Lob
	@Column(nullable = false, length = 255)
	private String name;

	/** The picture. */
	@Lob
	@Column(nullable = false)
	private byte[] picture;

	/** The person. */
	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "person_id", nullable = false)
	@JsonIgnore
	private Person personInGroup;
}