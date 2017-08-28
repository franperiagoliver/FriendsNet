package com.everis.alicante.courses.beca.summer17.friendsnet.controller.tests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.everis.alicante.courses.beca.summer17.friendsnet.controller.classes.impl.PersonControllerImpl;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.PersonManager;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class PersonControllerImplTest {

	@InjectMocks
	private PersonControllerImpl personController;

	@Mock
	private PersonManager personManager;

	private MockMvc mockMvc;

	private ObjectMapper mapper;

	private Person person = new Person();

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(personController).build();
		this.mapper = new ObjectMapper();
	}

	@Test
	public void testRelate() throws Exception {
		// Arrange
		final Person personA = new Person();
		person.setId(1L);
		final Person personB = new Person();
		person.setId(2L);
		final List<Long> newFriendsIds = new ArrayList<>();
		newFriendsIds.add(2L);
		Mockito.when(personManager.relatePersons(1L, newFriendsIds)).thenReturn(personA);
		final List<Person> persons = new ArrayList<>();
		persons.add(personA);
		persons.add(personB);
		// Act
		ResultActions performPerson = mockMvc.perform(get("/person/id"));
		// Assert
		performPerson.andExpect(status().isOk());
		performPerson.andExpect(content().json(mapper.writeValueAsString(persons)));
	}

	@Test
	public void testGetManager() {
		// // Arrange
		// PersonControllerImpl personControllerImplMock =
		// PowerMockito.createPartialMock(PersonControllerImpl.class, "getManager");
		// PowerMockito.expectPrivate(personControllerImplMock, "getManager");
		// // Act
		// replay(personControllerImplMock);
		// // Assert
		// PowerMockito.verify(personControllerImplMock);
	}

	@Test
	public void testGetAll() throws Exception {
		// Arrange
		Mockito.when(personManager.findAll()).thenReturn(null);
		// Act
		ResultActions performPerson = mockMvc.perform(get("/person"));
		// Assert
		performPerson.andExpect(status().isOk());
	}

	@Test
	public void testGetById() throws Exception {
		// Arrange
		final Person person = new Person();
		person.setId(1L);
		Mockito.when(personManager.findById(1L)).thenReturn(person);
		final List<Person> persons = new ArrayList<>();
		persons.add(person);
		// Act
		ResultActions performPerson = mockMvc.perform(get("/person/id"));
		// Assert
		performPerson.andExpect(status().isOk());
		performPerson.andExpect(content().json(mapper.writeValueAsString(persons)));
	}

	@Test
	public void testCreate() throws Exception {
		// Arrange
		Mockito.when(personManager.save(this.person)).thenReturn(null);
		// Act
		ResultActions performPerson = mockMvc.perform(post("/person"));
		// Assert
		performPerson.andExpect(status().isOk());
	}

	@Test
	public void testRemove() throws Exception {
		// Arrange
		Mockito.doNothing().when(personManager).remove(this.person);
		// Act
		ResultActions performPerson = mockMvc.perform(delete("/person"));
		// Assert
		performPerson.andExpect(status().isOk());
	}
}
