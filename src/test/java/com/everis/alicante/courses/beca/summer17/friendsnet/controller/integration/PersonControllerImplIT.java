/*
 * Created at 29-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller.integration;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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
 * The Class PersonControllerImplIT.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
public class PersonControllerImplIT {

	/** The port. */
	@LocalServerPort
	private int port;

	/** The person dao. */
	@Autowired
	private PersonDAO personDao;

	/** The rest template. */
	TestRestTemplate restTemplate = new TestRestTemplate();

	/** The headers. */
	HttpHeaders headers = new HttpHeaders();

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
	@DatabaseSetup("classpath:db/initial-person.xml")
	public void testFindAll() throws JSONException {
		// Act
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/person"), HttpMethod.GET, null,
				String.class);
		// Assert
		JSONAssert.assertEquals(
				"[{'id':1, 'name':'Antonio', 'surname':'Sanchez'},{'id'=2, 'name'='Fran', 'surname':'Periago'},{'id'=3, 'name'='Maria', 'surname':'Lopez'},{'id'=4, 'name'='Juana', 'surname':'Loca'}]",
				response.getBody(), false);
	}

	/**
	 * Test get by id.
	 *
	 * @throws JSONException
	 *             the JSON exception
	 */
	@Test
	@DatabaseSetup("classpath:db/initial-person.xml")
	public void testGetById() throws JSONException {
		// Arrange

		// Act
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/person/4"), HttpMethod.GET, null,
				String.class);
		// Assert
		JSONAssert.assertEquals("{'id'=4, 'name'='Juana', 'surname':'Loca'}", response.getBody(), false);
	}

	/**
	 * Test create.
	 *
	 * @throws JSONException
	 *             the JSON exception
	 */
	@Test
	@DatabaseSetup("classpath:db/initial-person.xml")
	@ExpectedDatabase(value = "classpath:db/after-creating-person.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testCreate() throws JSONException {
		// Arrange
		Person person = new Person();
		person.setName("Miguel");
		person.setSurname("Oliver");
		personDao.save(person);
		HttpEntity<Person> entity = new HttpEntity<Person>(person, headers);

		// Act
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/person"), HttpMethod.POST, entity,
				String.class);
		// Assert
		JSONAssert.assertEquals("{'id'=5, 'name'='Miguel', 'surname':'Oliver'}", response.getBody(), false);
	}

	/**
	 * Test remove.
	 *
	 * @throws JSONException
	 *             the JSON exception
	 */
	@Test
	@DatabaseSetup("classpath:db/initial-person.xml")
	@ExpectedDatabase(value = "classpath:db/after-deleting-person.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testRemove() throws JSONException {
		// Act
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/person/5"), HttpMethod.DELETE, null,
				String.class);
		// Assert
		JSONAssert.assertEquals("{}", response.getBody(), false);
	}

	/**
	 * Creates the URL with port.
	 *
	 * @param uri
	 *            the uri
	 * @return the string
	 */
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}