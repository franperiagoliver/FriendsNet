/*
 * Created at 29-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.integration.tests;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;

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

	/** The rest template. */
	TestRestTemplate restTemplate = new TestRestTemplate();

	/** The headers. */
	HttpHeaders headers = new HttpHeaders();

	/**
	 * Setup.
	 */
	@Before
	public void setup() {

	}

	/**
	 * Test get all.
	 *
	 * @throws JSONException
	 *             the JSON exception
	 */
	@Test
	@DatabaseSetup("classpath:initial-person.xml")
	public void testGetAll() throws JSONException {
		// Act
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/person"), HttpMethod.GET, null,
				String.class);
		// Assert
		JSONAssert.assertEquals("[{'id':1, 'name':'Adrian', 'surname':'Sanchez'},{'id':2, 'name':'Fran', 'surname':'Periago'}]", response.getBody(), false);
	}
	
	@Test
	@DatabaseSetup("classpath:initial-person.xml")
	public void testGetId() throws JSONException {
		// Act
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/person/1"), HttpMethod.GET, null,
				String.class);
		// Assert
		JSONAssert.assertEquals("{'id':1, 'name':'Adrian', 'surname':'Sanchez'}", response.getBody(), false);
	}
	
	@Test
	@DatabaseSetup("classpath:initial-person.xml")
	@ExpectedDatabase("classpath:after-saving-person.xml")
	public void testCreate() throws JSONException {
		// Act
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/person/"), HttpMethod.POST, null,
				String.class);
		// Assert
		JSONAssert.assertEquals("{'id':3, 'name':'Maria', 'surname':'Oliver'}", response.getBody(), false);
	}
	
	@Test
	@DatabaseSetup("classpath:initial-person.xml")
	@ExpectedDatabase("classpath:after-deleting-person.xml")
	public void testRemove() throws JSONException {
		// Act
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/person/"), HttpMethod.DELETE, null,
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