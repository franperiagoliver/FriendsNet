package com.everis.alicante.courses.beca.summer17.friendsnet.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

import com.everis.alicante.courses.beca.summer17.friendsnet.controller.impl.PersonControllerImpl;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.PersonManager;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.impl.PersonManagerImpl;
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

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(personController).build();
		this.mapper = new ObjectMapper();
		this.personManager = new PersonManagerImpl();
	}

	@Test
	public void testGetAllNoContent() throws Exception {
		// Arrange
		Mockito.when(personManager.findAll()).thenReturn(null);
		// Act
		ResultActions perform = mockMvc.perform(get("/person"));
		// Assert
		perform.andExpect(status().isOk());
	}

	@Test
	public void testGetAllWithContent() throws Exception {
		// Arrange
		Person person = new Person();
		person.setName("Juan");
		Person person2 = new Person();
		person.setName("Adrian");
		List<Person> persons = new ArrayList<>();
		persons.add(person);
		persons.add(person2);
		Mockito.when(personManager.findAll()).thenReturn(persons);
		// Act
		ResultActions perform = mockMvc.perform(get("/person"));
		// Assert
		perform.andExpect(status().isOk());
		perform.andExpect(content().json(mapper.writeValueAsString(persons)));
	}
}
