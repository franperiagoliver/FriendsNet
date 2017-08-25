package com.everis.alicante.courses.beca.summer17.friendsnet.controller.classes;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.interfaces.FNEntity;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.Manager;

@RestController
public abstract class AbstractController<E extends FNEntity, ID extends Serializable> {
	
	protected abstract Manager<E, ID> getManager();
	
	@GetMapping
	public List<E> getAll(){
		return (List<E>) this.getManager().findAll();
	}
	
	@GetMapping("/{id}")
	public E getById(ID id) {
		return this.getManager().findById(id);
		
	}
	
	@PostMapping
	public E create(@RequestBody E e) {
		return this.getManager().save(e);
		
	}
	
	@DeleteMapping("/{id}")
	public void remove(@PathVariable ID id) {
		this.getManager().remove(this.getManager().findById(id));
	}
}