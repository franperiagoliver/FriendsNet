/*
 * Created at 30-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.Serializable;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import com.everis.alicante.courses.beca.summer17.friendsnet.entity.FNEntity;

import com.everis.alicante.courses.beca.summer17.friendsnet.manager.Manager;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.springtestdbunit.DbUnitTestExecutionListener;

/**
 * The Class AbstractControllerTest.
 *
 * @param <E> the element type
 * @param <ID> the generic type
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
public abstract class AbstractControllerTest<E extends FNEntity, ID extends Serializable> {
	
	/**
	 * Gets the base URL find all and create.
	 *
	 * @return the base URL find all and create
	 */
	protected abstract String getBaseURLFindAllAndCreate();
	
	/**
	 * Gets the base URL find by id and remove.
	 *
	 * @return the base URL find by id and remove
	 */
	protected abstract String getBaseURLFindByIdAndRemove(ID id);
	
	/**
	 * Gets the then return find all.
	 *
	 * @return the then return find all
	 */
	protected abstract Iterable<E> getThenReturnFindAll();
	
	/**
	 * Gets the then return find by id and create.
	 *
	 * @return the then return find by id and create
	 */
	protected abstract E getThenReturnFindByIdAndCreate();
	
	/**
	 * Gets the manager mock.
	 *
	 * @return the manager mock
	 */
	protected abstract Manager<E, ID> getManagerMock();
	
	/**
	 * Gets the controller.
	 *
	 * @return the controller
	 */
	protected abstract Object getController();
	
	/**
	 * Gets the find by id.
	 *
	 * @return the find by id
	 */
	protected abstract ID getFindById();
	
	/**
	 * Gets the save and remove.
	 *
	 * @return the save and remove
	 */
	protected abstract E getSaveAndRemove();
	
	/** The mock mvc. */
	private MockMvc mockMvc;

	/** The mapper. */
	private ObjectMapper mapper;

	/**
	 * Setup.
	 */
	@Before
	public void setup() {
		this.mockMvc = this.getMockMvc();
		this.mapper = this.getMapper();
	}

	/**
	 * Test get all.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testGetAll() throws Exception {
		// Arrange
		Mockito.when(this.getManagerMock().findAll()).thenReturn(this.getThenReturnFindAll());
		// Act
		ResultActions perform = mockMvc.perform(get(this.getBaseURLFindAllAndCreate()));
		// Assert
		perform.andExpect(status().isOk());
		perform.andExpect(content().json(mapper.writeValueAsString(this.getThenReturnFindAll())));
	}
	
	/**
	 * Test get by id.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testGetById() throws Exception {
		// Arrange
		Mockito.when(this.getManagerMock().findById(this.getFindById())).thenReturn(this.getThenReturnFindByIdAndCreate());
		// Act
		ResultActions perform = mockMvc.perform(get(this.getBaseURLFindByIdAndRemove(this.getFindById())));
		// Assert
		perform.andExpect(status().isOk());
		perform.andExpect(content().json(mapper.writeValueAsString(this.getThenReturnFindByIdAndCreate())));
	}
	
	/**
	 * Test create.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testCreate() throws Exception {
		// Arrange
		Mockito.when(this.getManagerMock().save(this.getSaveAndRemove())).thenReturn(this.getThenReturnFindByIdAndCreate());
		// Act
		ResultActions perform = mockMvc.perform(post(this.getBaseURLFindAllAndCreate()));
		// Assert
		perform.andExpect(status().isOk());
		perform.andExpect(content().json(mapper.writeValueAsString(this.getThenReturnFindByIdAndCreate())));
	}
	
	/**
	 * Test remove.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testRemove() throws Exception {
		// Arrange
		Mockito.doNothing().when(this.getManagerMock()).remove(getSaveAndRemove());
		// Act
		ResultActions perform = mockMvc.perform(delete(this.getBaseURLFindByIdAndRemove(this.getFindById())));
		// Assert
		perform.andExpect(status().isOk());
		perform.andExpect(content().json(mapper.writeValueAsString("{}")));
	}
	
	/**
	 * Gets the mapper.
	 *
	 * @return the mapper
	 */
	protected ObjectMapper getMapper() {
		return this.mapper;
	}
	
	/**
	 * Gets the mock mvc.
	 *
	 * @return the mock mvc
	 */
	protected MockMvc getMockMvc() {
		return this.mockMvc;
	}
}