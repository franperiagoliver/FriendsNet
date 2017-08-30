/*
 * Created at 29-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.web.servlet.ResultActions;

import com.everis.alicante.courses.beca.summer17.friendsnet.controller.AbstractControllerTest;
import com.everis.alicante.courses.beca.summer17.friendsnet.controller.GroupControllerImpl;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Group;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.GroupManager;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.PersonManager;
import com.github.springtestdbunit.DbUnitTestExecutionListener;


/**
 * The Class GroupControllerImplIT.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
public class GroupControllerImplTest extends AbstractControllerTest<Group, Long> {

	/** The manager. */
	@Mock
	private GroupManager manager;

	/** The manager. */
	@Mock
	private PersonManager Pmanager;

	/** The person controller. */
	@InjectMocks
	private GroupControllerImpl controller;

	@Override
	protected String getBaseURLFindAllAndCreate() {
		return "/group";
	}

	@Override
	protected String getBaseURLFindByIdAndRemove(final Long id) {
		return "/group" + id;
	}

	@Override
	protected Iterable<Group> getThenReturnFindAll() {
		final Group groupa = new Group();
		groupa.setName("pepe");
		final Group groupb = new Group();
		groupb.setName("juan");
		final List<Group> groups = new ArrayList<>();
		groups.add(groupa);
		groups.add(groupb);
		return groups;
	}

	@Override
	protected Group getThenReturnFindByIdAndCreate() {
		final Group group = new Group();
		return group;
	}

	@Override
	protected GroupManager getManagerMock() {
		return this.manager;
	}

	@Override
	protected GroupControllerImpl getController() {
		return this.controller;
	}

	@Override
	protected Long getFindById() {
		return 1L;
	}

	@Override
	protected Group getSaveAndRemove() {
		final Group group = new Group();
		group.setName("Fran");
		return group;
	}

	@Test
	public Group TestAddPersons(final List<Long> personIds, final Long groupId) throws Exception {
		final Set<Person> persons = (Set<Person>) this.Pmanager.findByIds(personIds);
		final Group group = this.getManagerMock().findById(groupId);
		group.getPersonsInGroups().addAll(persons);
		this.getManagerMock().save(group);
		Mockito.when(this.getManagerMock().addPersons(personIds, groupId)).thenReturn(group);
		// Act
		ResultActions perform = super.getMockMvc().perform(post(this.getBaseURLFindByIdAndRemove(groupId) + "/person/" + personIds + "/add"));
		// Assert
		perform.andExpect(status().isOk());
		perform.andExpect(content().json(super.getMapper().writeValueAsString(group)));
		return group;
	}

	@Test
	public void testRelatePerson(Long groupId, Long personId) throws Exception {
		// Arrange
		final Group group = new Group();
		group.setName("Group1");
		final Person friend = new Person();
		friend.setName("Friend2");
		friend.setSurname("Surname2");
		this.getManagerMock().save(group);
		this.Pmanager.save(friend);
		groupId = group.getId();
		personId = friend.getId();
		Mockito.when(this.getManagerMock().relate(groupId, personId)).thenReturn(group);
		// Act
		ResultActions perform = super.getMockMvc().perform(post(this.getBaseURLFindByIdAndRemove(groupId) + "/relate"));
		// Assert
		perform.andExpect(status().isOk());
		perform.andExpect(content().json(super.getMapper().writeValueAsString(group)));
	}

	@Test
	public Set<Group> TestGetByPersonId(final Long personId) throws Exception {
		final Person person = this.Pmanager.findById(personId);
		final Set<Group> groups = person.getGroups();
		Mockito.when(this.getManagerMock().getByPersonId(personId)).thenReturn(groups);
		// Act
		ResultActions perform = super.getMockMvc().perform(post(this.getBaseURLFindAllAndCreate()+ "/person/" + personId));
		// Assert
		perform.andExpect(status().isOk());
		perform.andExpect(content().json(super.getMapper().writeValueAsString(groups)));
		return groups;

	}
}