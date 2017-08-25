package com.everis.alicante.courses.beca.summer17.friendsnet.controller.interfaces;

import java.util.List;


import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Person;

public interface PersonController extends Controller<Person, Long> {
	
	public Person relate(Long id, List<Long> persons);

}
