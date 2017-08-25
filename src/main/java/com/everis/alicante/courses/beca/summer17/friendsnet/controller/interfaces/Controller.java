package com.everis.alicante.courses.beca.summer17.friendsnet.controller.interfaces;

import java.io.Serializable;
import java.util.List;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.interfaces.FNEntity;

public interface Controller<E extends FNEntity, ID extends Serializable> {
	
	public List<E> getAll();

	public E getById(ID id);

	public E create(E e);

	public void remove(ID id);
}
