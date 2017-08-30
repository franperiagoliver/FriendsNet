/*
 * Created at 25-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller.impl;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.alicante.courses.beca.summer17.friendsnet.controller.AbstractController;
import com.everis.alicante.courses.beca.summer17.friendsnet.controller.domain.dto.GroupDTO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Group;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.GroupManager;
import com.everis.alicante.courses.beca.summer17.friendsnet.utils.converter.EntityConverter;

/**
 * The Class GroupController.
 */
@RestController
@RequestMapping("/group")
@Transactional
public class GroupControllerImpl extends AbstractController<Group, Long> {

	/** The manager. */
	@Autowired
	private GroupManager manager;

	/** The entity converter. */
	@Autowired
	private EntityConverter entityConverter;

	/**
	 * Gets the by person id.
	 *
	 * @param id
	 *            the id
	 * @return the by person id
	 */
	@GetMapping("/person/{id}/")
	public Set<GroupDTO> getByPersonId(final Long id) {
		final Set<Group> groups = this.getManager().getByPersonId(id);
		return (Set<GroupDTO>) entityConverter.convert(groups, GroupDTO.class);
	}

	/**
	 * Relate.
	 *
	 * @param groupId
	 *            the group id
	 * @param personId
	 *            the person id
	 * @return the group
	 */
	@PostMapping("/{id}/relate")
	public GroupDTO relate(@PathVariable("id") final Long groupId, @RequestBody final Long personId) {
		final Group group = this.getManager().relate(groupId, personId);
		return entityConverter.convert(group, GroupDTO.class);
	}

	/**
	 * Adds the persons.
	 *
	 * @param personIds
	 *            the person ids
	 * @param groupId
	 *            the group id
	 * @return the group
	 */
	@PostMapping("/{id}/person/{idPersons}/add")
	public GroupDTO addPersons(@PathVariable("idPersons") final List<Long> personIds,
			@PathVariable("id") final Long groupId) {
		final Group groups = this.getManager().addPersons(personIds, groupId);
		return entityConverter.convert(groups, GroupDTO.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.controller.classes.
	 * AbstractController#getManager()
	 */
	@Override
	protected final GroupManager getManager() {
		return this.manager;
	}
}