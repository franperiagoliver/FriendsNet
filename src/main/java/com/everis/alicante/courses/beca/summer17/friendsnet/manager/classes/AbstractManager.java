package com.everis.alicante.courses.beca.summer17.friendsnet.manager.classes;

import java.io.Serializable;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.EntityDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.interfaces.FNEntity;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.Manager;

public abstract class AbstractManager<E extends FNEntity, ID extends Serializable> implements Manager<E, ID>{
	
	protected abstract EntityDAO<E, ID> getEntityDAO();
	
	@Override
	public Iterable<E> findAll() {
		return this.getEntityDAO().findAll();
	}

	@Override
	public E findById(ID id) {
		return this.getEntityDAO().findById(id);
	}

	@Override
	public Iterable<E> findByIds(Iterable<ID> ids) {
		return this.getEntityDAO().findByIds(ids);
	}

	@Override
	public E save(E e) {
		return this.getEntityDAO().save(e);
	}

	@Override
	public Iterable<E> save(Iterable<E> es) {
		return this.getEntityDAO().save(es);
	}

	@Override
	public E update(E e) {
		return this.getEntityDAO().update(e);
	}

	@Override
	public Iterable<E> update(Iterable<E> es) {
		return this.getEntityDAO().update(es);
	}

	@Override
	public void remove(E e) {
		this.getEntityDAO().remove(e);
	}

}
