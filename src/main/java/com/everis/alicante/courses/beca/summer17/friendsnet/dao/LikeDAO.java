/*
 * Created at 29-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Like;

/**
 * The Interface LikeDAO.
 */
@Service
public interface LikeDAO extends CrudRepository<Like, Long>, EntityDAO<Like, Long> {

}