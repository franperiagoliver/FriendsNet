/*
 * Created at 29-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.manager.classes;

import java.io.Serializable;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.EntityDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.interfaces.FNEntity;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.Manager;

/**
 * The Class AbstractManager.
 *
 * @param <E>
 *            the element type
 * @param <ID>
 *            the generic type
 */
public abstract class AbstractManager<E extends FNEntity, ID extends Serializable> implements Manager<E, ID> {

	/**
	 * Gets the entity DAO.
	 *
	 * @return the entity DAO
	 */
	protected abstract EntityDAO<E, ID> getEntityDAO();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * Manager#findAll()
	 */
	@Override
	public Iterable<E> findAll() {
		return this.getEntityDAO().findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * Manager#findById(java.io.Serializable)
	 */
	@Override
	public E findById(final ID id) {
		return this.getEntityDAO().findById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * Manager#findByIds(java.lang.Iterable)
	 */
	@Override
	public Iterable<E> findByIds(final Iterable<ID> ids) {
		return this.getEntityDAO().findByIds(ids);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * Manager#save(com.everis.alicante.courses.beca.summer17.friendsnet.entity.
	 * interfaces.FNEntity)
	 */
	@Override
	public E save(final E e) {
		return this.getEntityDAO().save(e);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * Manager#save(java.lang.Iterable)
	 */
	@Override
	public Iterable<E> save(final Iterable<E> es) {
		return this.getEntityDAO().save(es);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * Manager#update(com.everis.alicante.courses.beca.summer17.friendsnet.entity.
	 * interfaces.FNEntity)
	 */
	@Override
	public E update(final E e) {
		return this.getEntityDAO().update(e);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * Manager#update(java.lang.Iterable)
	 */
	@Override
	public Iterable<E> update(final Iterable<E> es) {
		return this.getEntityDAO().update(es);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.
	 * Manager#remove(com.everis.alicante.courses.beca.summer17.friendsnet.entity.
	 * interfaces.FNEntity)
	 */
	@Override
	public void remove(final E e) {
		this.getEntityDAO().remove(e);
	}
}