package com.everis.alicante.courses.beca.summer17.friendsnet.controller.domain.dto;

import java.util.Date;
import java.util.Set;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.enums.EventType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventDTO {

	private Long id;
	private String name;
	private byte[] picture;
	private Date startingDate;
	private Date endingDate;
	private EventType eventType;
	private Set<PersonDTO> personsInEvent;
}
