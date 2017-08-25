package com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces;

import java.util.List;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Like;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Post;

public interface PostDAO extends EntityDAO<Post, Long> {

	public Post addLike(final Like like);
	public List<Post> getByPersonId(final Long id);
}
