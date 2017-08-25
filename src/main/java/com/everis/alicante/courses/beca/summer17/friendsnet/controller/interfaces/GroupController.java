package com.everis.alicante.courses.beca.summer17.friendsnet.controller.interfaces;

import java.util.List;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Group;

public interface GroupController extends Controller<Group, Long> {
	
	
	public Group relate(final Long id, final List<Long> groups);
	
	public Group getByPersonId(final Long id);
	
}
