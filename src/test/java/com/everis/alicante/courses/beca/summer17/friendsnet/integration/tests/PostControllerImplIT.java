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

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
public class PostControllerImplIT {

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

	@Test
	@DatabaseSetup("classpath:initial-post.xml")
	public void testGetAll() throws JSONException {
		// Act
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/post"), HttpMethod.GET, null,
				String.class);
		// Assert
		JSONAssert.assertEquals("[{'creationdate':'2017-08-29T08:23:08.938Z','text':'Hola','type':'STATUS'}]",
				response.getBody(), false);
	}

	@Test
	public void testGetById() {

	}

	@Test
	public void testCreate() {

	}

	@Test
	public void testRemove() {

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
