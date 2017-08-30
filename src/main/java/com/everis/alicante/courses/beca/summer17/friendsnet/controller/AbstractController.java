/*
 * Created at 27-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.everis.alicante.courses.beca.summer17.friendsnet.controller.domain.FNDTO;
import com.everis.alicante.courses.beca.summer17.friendsnet.controller.domain.PersonDTO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.FNEntity;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.Manager;
import com.everis.alicante.courses.beca.summer17.friendsnet.utils.converter.EntityConverter;

/**
 * The Class AbstractController.
 *
 * @param <E>            the element type
 * @param <DTO> the generic type
 * @param <ID>            the generic type
 */
@RestController
@Transactional
public abstract class AbstractController<E extends FNEntity, DTO extends FNDTO, ID extends Serializable> {

	/**
	 * Gets the manager.
	 *
	 * @return the manager
	 */
	protected abstract Manager<E, ID> getManager();

	/** The e class. */
	private final Class<E> eClass;
	
	/** The dto class. */
	private final Class<DTO> dtoClass;

	/** The entity converter. */
	@Autowired
	private EntityConverter entityConverter;

	/**
	 * Instantiates a new abstract controller.
	 *
	 * @param eClass the e class
	 * @param dtoClass the dto class
	 */
	protected AbstractController(final Class<E> eClass, final Class<DTO> dtoClass) {
		this.eClass = eClass;
		this.dtoClass = dtoClass;
	}

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	@GetMapping
	public List<DTO> getAll() {
		return this.getEntityConverter().convert((List<E>) this.getManager().findAll(), dtoClass);
	}

	/**
	 * Gets the by id.
	 *
	 * @param id
	 *            the id
	 * @return the by id
	 */
	@GetMapping("/{id}")
	public DTO getById(@PathVariable final ID id) {
		return this.getEntityConverter().convert((E) this.getManager().findById(id), dtoClass);

	}

	/**
	 * Creates the.
	 *
	 * @param e
	 *            the e
	 * @return the e
	 */
	@PostMapping
	public E create(@RequestBody final DTO dtoClass) {
		 final E eClass = entityConverter.convert(dtoClass, this.eClass);
	        return getManager().save(eClass);
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

	/**
	 * Gets the entity converter.
	 *
	 * @return the entity converter
	 */
	protected EntityConverter getEntityConverter() {
		return this.entityConverter;
	}
}