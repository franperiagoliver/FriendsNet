/*
 * Created at 30-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.dao.integration;

import java.util.List;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.PersonDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

/**
 * The Class PersonDAOIT.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
public class PersonDAOIT {

	/** The dao. */
	@Autowired
	private PersonDAO dao;

	/** The mapper. */
	private ObjectMapper mapper;

	/**
	 * Setup.
	 */
	@Before
	public void setup() {
		this.mapper = new ObjectMapper();
	}

	/**
	 * Test find all.
	 *
	 * @throws JSONException
	 *             the JSON exception
	 */
	@Test
	@DatabaseSetup("/db/initial-person.xml")
	public void testFindAll() throws JSONException {
		// Act
		List<Person> all = (List<Person>) dao.findAll();
		// Assert
		Assert.assertEquals(4, all.size());
	}

	/**
	 * Test save person.
	 *
	 * @throws JSONException
	 *             the JSON exception
	 */
	@Test
	@DatabaseSetup("/db/initial-person.xml")
	public void testSavePerson() throws JSONException {
		// Arrange
		final Person person = new Person();
		person.setName("A");
		person.setSurname("B");
		// Act
		dao.save(person);
		// Assert
		List<Person> all = (List<Person>) dao.findAll();
		Assert.assertEquals(5, all.size());
	}

	/**
	 * Test save person 2.
	 *
	 * @throws JSONException
	 *             the JSON exception
	 */
	@Test
	@DatabaseSetup("/db/initial-person.xml")
	@ExpectedDatabase(value = "/db/after-creating-person.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testSavePerson2() throws JSONException {
		// Arrange
		final Person person = new Person();
		person.setName("Miguel");
		person.setSurname("Oliver");
		// Act
		dao.save(person);
	}

	/**
	 * Test remove person.
	 *
	 * @throws JSONException
	 *             the JSON exception
	 */
	@Test
	@DatabaseSetup("/db/initial-person.xml")
	@ExpectedDatabase(value = "/db/after-deleting-person.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testRemovePerson() throws JSONException {
	}
}