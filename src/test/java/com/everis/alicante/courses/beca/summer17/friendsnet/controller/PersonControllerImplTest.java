/*
 * Created at 29-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.everis.alicante.courses.beca.summer17.friendsnet.controller.AbstractControllerTest;
import com.everis.alicante.courses.beca.summer17.friendsnet.controller.PersonControllerImpl;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;

import com.everis.alicante.courses.beca.summer17.friendsnet.manager.PersonManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.springtestdbunit.DbUnitTestExecutionListener;

/**
 * The Class PersonControllerImplIT.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
public class PersonControllerImplTest extends AbstractControllerTest<Person, Long> {

	/** The manager. */
	@Mock
	private PersonManager manager;

	/** The person controller. */
	@InjectMocks
	private PersonControllerImpl personController;
	
	/** The mock mvc. */
	private MockMvc mockMvc;

	/** The mapper. */
	private ObjectMapper mapper;

	/**
	 * Setup.
	 */
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.getController()).build();
		this.mapper = new ObjectMapper();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.controller.
	 * AbstractControllerTest#getBaseURLFindAllAndCreate()
	 */
	@Override
	protected String getBaseURLFindAllAndCreate() {
		return "/person";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.controller.
	 * AbstractControllerTest#getBaseURLFindByIdAndRemove()
	 */
	@Override
	protected String getBaseURLFindByIdAndRemove(final Long id) {
		return "/person/" + id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.controller.
	 * AbstractControllerTest#getThenReturnFindAll()
	 */
	@Override
	protected Iterable<Person> getThenReturnFindAll() {
		final Person persona = new Person();
		persona.setName("pepe");
		final Person personb = new Person();
		persona.setName("juan");
		final List<Person> persons = new ArrayList<>();
		persons.add(persona);
		persons.add(personb);
		return persons;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.controller.
	 * AbstractControllerTest#getThenReturnFindByIdAndCreate()
	 */
	@Override
	protected Person getThenReturnFindByIdAndCreate() {
		final Person person = new Person();
		person.setName("Juan");
		person.setSurname("Periago");
		return person;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.controller.
	 * AbstractControllerTest#getManagerMock()
	 */
	@Override
	protected PersonManager getManagerMock() {
		return this.manager;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.controller.
	 * AbstractControllerTest#getController()
	 */
	@Override
	protected PersonControllerImpl getController() {
		return this.personController;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.controller.
	 * AbstractControllerTest#getFindById()
	 */
	@Override
	protected Long getFindById() {
		return 1L;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.controller.
	 * AbstractControllerTest#getSaveAndRemove()
	 */
	@Override
	protected Person getSaveAndRemove() {
		final Person person = new Person();
		person.setName("Fran");
		person.setSurname("Periago");
		return person;
	}

	/**
	 * Test relate.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testRelate() throws Exception {
		// Arrange
		final Person person = new Person();
		person.setName("Friend1");
		person.setSurname("Surname1");
		final Person friend = new Person();
		friend.setName("Friend2");
		friend.setSurname("Surname2");
		this.getManagerMock().save(person);
		this.getManagerMock().save(friend);
		final Long idPerson = person.getId();
		final Long idFriend = friend.getId();
		Mockito.when(this.getManagerMock().relatePersons(idPerson, idFriend)).thenReturn(person);
		// Act
		ResultActions perform = super.getMockMvc()
				.perform(post(this.getBaseURLFindByIdAndRemove(idPerson) + "/relate"));
		// Assert
		perform.andExpect(status().isOk());
		perform.andExpect(content().json(super.getMapper().writeValueAsString(person)));
	}
}