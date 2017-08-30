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

import com.everis.alicante.courses.beca.summer17.friendsnet.controller.impl.GroupControllerImpl;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Group;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.GroupManager;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.impl.GroupManagerImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class GroupControllerImplTest {

	@InjectMocks
	private GroupControllerImpl groupController;

	@Mock
	private GroupManager groupManager;

	private MockMvc mockMvc;

	private ObjectMapper mapper;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(groupController).build();
		this.mapper = new ObjectMapper();
		this.groupManager = new GroupManagerImpl();
	}

	@Test
	public void testGetAllNoContent() throws Exception {
		// Arrange
		Mockito.when(groupManager.findAll()).thenReturn(null);
		// Act
		ResultActions perform = mockMvc.perform(get("/group"));
		// Assert
		perform.andExpect(status().isOk());
	}

	@Test
	public void testGetAllWithContent() throws Exception {
		// Arrange
		Group group = new Group();
		group.setName("Molones");
		Group group2 = new Group();
		group.setName("Leones");
		List<Group> groups = new ArrayList<>();
		groups.add(group);
		groups.add(group2);
		Mockito.when(groupManager.findAll()).thenReturn(groups);
		// Act
		ResultActions perform = mockMvc.perform(get("/group"));
		// Assert
		perform.andExpect(status().isOk());
		perform.andExpect(content().json(mapper.writeValueAsString(groups)));
	}
}
