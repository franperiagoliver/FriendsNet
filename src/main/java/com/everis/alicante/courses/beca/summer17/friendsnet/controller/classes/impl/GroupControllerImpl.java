/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller.classes.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.everis.alicante.courses.beca.summer17.friendsnet.controller.classes.AbstractController;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Group;

import com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.GroupManager;


/**
 * The Class GroupController.
 */
@RestController
@RequestMapping("/group")
@Transactional
public class GroupControllerImpl extends AbstractController {

	/** The manager. */
	@Autowired
	private GroupManager manager;

	
	@GetMapping("/person/{id}/")
	public Group getByPersonId(final Long id) {
		return this.manager.findById(id);
	}

	
	@PostMapping("/{id}/relate")
	public Group relate(@RequestParam final Long id, @RequestBody final List<Long> groups) {
		return this.manager.relate(id, groups);
	}

	@Override
	protected GroupManager getManager() {
		return this.manager;
	}
}