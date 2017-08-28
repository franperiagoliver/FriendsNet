/*
 * Created at 24-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.interfaces.FNEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class Group.
 */
@Entity(name = "group_table")
@Table(name = "group_table")
@Getter
@Setter
public class Group implements FNEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8528264221546094527L;

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
	@Column(nullable = true)
	private byte[] picture;

	/** The person. */
	@ManyToMany(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "person_id", nullable = true)
	private Set<Person> personsInGroups = new HashSet<>();
}