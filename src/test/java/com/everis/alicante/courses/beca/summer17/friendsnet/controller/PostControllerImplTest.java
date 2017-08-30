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

import com.everis.alicante.courses.beca.summer17.friendsnet.controller.impl.PostControllerImpl;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Post;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.PostManager;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.impl.PostManagerImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class PostControllerImplTest {

	@InjectMocks
	private PostControllerImpl postController;

	@Mock
	private PostManager postManager;

	private MockMvc mockMvc;

	private ObjectMapper mapper;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(postController).build();
		this.mapper = new ObjectMapper();
		this.postManager = new PostManagerImpl();
	}

	@Test
	public void testGetAllNoContent() throws Exception {
		// Arrange
		Mockito.when(postManager.findAll()).thenReturn(null);
		// Act
		ResultActions perform = mockMvc.perform(get("/post"));
		// Assert
		perform.andExpect(status().isOk());
	}

	@Test
	public void testGetAllWithContent() throws Exception {
		// Arrange
		Post post = new Post();
		post.setText("Hello World!");
		Post post2 = new Post();
		post.setText("Bye World!");
		List<Post> posts = new ArrayList<>();
		posts.add(post);
		posts.add(post2);
		Mockito.when(postManager.findAll()).thenReturn(posts);
		// Act
		ResultActions perform = mockMvc.perform(get("/post"));
		// Assert
		perform.andExpect(status().isOk());
		perform.andExpect(content().json(mapper.writeValueAsString(posts)));
	}
}
