/*
 * Created at 27-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller.tests;

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

import com.everis.alicante.courses.beca.summer17.friendsnet.controller.classes.impl.EventControllerImpl;
import com.everis.alicante.courses.beca.summer17.friendsnet.controller.classes.impl.GroupControllerImpl;
import com.everis.alicante.courses.beca.summer17.friendsnet.controller.classes.impl.PersonControllerImpl;
import com.everis.alicante.courses.beca.summer17.friendsnet.controller.classes.impl.PostControllerImpl;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Event;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Group;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Post;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.EventManager;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.GroupManager;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.PersonManager;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces.PostManager;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class AbstractControllerTest {

	@InjectMocks
	private PersonControllerImpl personController;

	@InjectMocks
	private GroupControllerImpl groupController;

	@InjectMocks
	private EventControllerImpl eventController;

	@InjectMocks
	private PostControllerImpl postController;

	@Mock
	private PersonManager personManager;

	@Mock
	private GroupManager groupManager;

	@Mock
	private EventManager eventManager;

	@Mock
	private PostManager postManager;

	private MockMvc mockMvc;

	private ObjectMapper mapper;

	private Person personA = new Person();
	private Person personB = new Person();
	private List<Person> persons = new ArrayList<>();
	private Group groupA = new Group();
	private Group groupB = new Group();
	private List<Group> groups = new ArrayList<>();
	private Event eventA = new Event();
	private Event eventB = new Event();
	private List<Event> events = new ArrayList<>();
	private Post postA = new Post();
	private Post postB = new Post();
	private List<Post> posts = new ArrayList<>();

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(personController).build();
		this.mockMvc = MockMvcBuilders.standaloneSetup(groupController).build();
		this.mockMvc = MockMvcBuilders.standaloneSetup(eventController).build();
		this.mockMvc = MockMvcBuilders.standaloneSetup(postController).build();
		this.mapper = new ObjectMapper();
	}

	@Test
	public void testGetAll() throws Exception {
		// Arrange
		Mockito.when(personController).findAll().thenReturn(null);
		Mockito.when(groupController).findAll().thenReturn(null);
		Mockito.when(eventController).findAll().thenReturn(null);
		Mockito.when(postController).findAll().thenReturn(null);
		// Act
		ResultActions performPerson = mockMvc.perform(get("/person"));
		ResultActions performGroup = mockMvc.perform(get("/group"));
		ResultActions performEvent = mockMvc.perform(get("/event"));
		ResultActions performPost = mockMvc.perform(get("/post"));
		// Assert
		performPerson.andExpect(status().isOk());
		performGroup.andExpect(status().isOk());
		performEvent.andExpect(status().isOk());
		performPost.andExpect(status().isOk());
	}

	/**
	 * Test get by id.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testGetById() throws Exception {
		// Arrange - Person
		this.personA.setId(1L);
		this.personB.setId(2L);
		this.persons.add(personA);
		this.persons.add(personB);
		Mockito.when(personController.findAll().thenReturn(persons));

		// Arrange - Group
		this.groupA.setId(1L);
		this.groupB.setId(2L);
		this.groups.add(groupA);
		this.groups.add(groupB);
		Mockito.when(groupController.findAll().thenReturn(groups));

		// Arrange - Event
		this.eventA.setId(1L);
		this.eventB.setId(2L);
		this.events.add(eventA);
		this.events.add(eventB);
		Mockito.when(eventController.findAll().thenReturn(events));

		// Arrange - Post
		this.postA.setId(1L);
		this.postB.setId(2L);
		this.posts.add(postA);
		this.posts.add(postB);
		Mockito.when(postController.findAll().thenReturn(posts));

		// Act
		ResultActions performPerson = mockMvc.perform(get("/person"));
		ResultActions performGroup = mockMvc.perform(get("/group"));
		ResultActions performEvent = mockMvc.perform(get("/event"));
		ResultActions performPost = mockMvc.perform(get("/post"));

		// Assert
		performPerson.andExpect(status().isOk());
		performPerson.andExpect(content().json(mapper.writeValueAsString(persons)));

		performGroup.andExpect(status().isOk());
		performGroup.andExpect(content().json(mapper.writeValueAsString(groups)));

		performEvent.andExpect(status().isOk());
		performEvent.andExpect(content().json(mapper.writeValueAsString(events)));

		performPost.andExpect(status().isOk());
		performPost.andExpect(content().json(mapper.writeValueAsString(posts)));
	}

	@Test
	public void testCreate() {

	}

	@Test
	public void testRemove() {

	}
}