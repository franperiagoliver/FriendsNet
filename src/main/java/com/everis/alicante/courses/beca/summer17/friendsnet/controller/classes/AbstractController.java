/*
 * Created at 27-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller.classes;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.interfaces.FNEntity;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.Manager;

/**
 * The Class AbstractController.
 *
 * @param <E>
 *            the element type
 * @param <ID>
 *            the generic type
 */
@RestController
@Transactional
public abstract class AbstractController<E extends FNEntity, ID extends Serializable> {

	/**
	 * Gets the manager.
	 *
	 * @return the manager
	 */
	protected abstract Manager<E, ID> getManager();

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	@GetMapping
	public List<E> getAll() {
		return (List<E>) this.getManager().findAll();
	}

	/**
	 * Gets the by id.
	 *
	 * @param id
	 *            the id
	 * @return the by id
	 */
	@GetMapping("/{id}")
	public E getById(final ID id) {
		return this.getManager().findById(id);

	}

	/**
	 * Creates the.
	 *
	 * @param e
	 *            the e
	 * @return the e
	 */
	@PostMapping
	public E create(@RequestBody final E e) {
		return this.getManager().save(e);

	}

	/**
	 * Removes the.
	 *
	 * @param id
	 *            the id
	 */
	@DeleteMapping("/{id}")
	public void remove(@PathVariable final ID id) {
		this.getManager().remove(this.getManager().findById(id));
	}
}