package com.everis.alicante.courses.beca.summer17.friendsnet.controller.interfaces;

import java.util.List;



import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Event;

public interface EventController extends Controller<Event, Long> {
	
	
	public Event addPerson(final List<Long> ids);
	
	public Event addPersons(final List<Long> ids);
	
	public List<Event> getByPersonId(final Long id);
	
}
