package com.everis.alicante.courses.beca.summer17.friendsnet.integration.tests;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.interfaces.PersonDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.classes.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import javax.transaction.Transactional;

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
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonControllerImplIT {

	@LocalServerPort
	private int port;

	@Autowired
	private PersonDAO dao;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	private ObjectMapper mapper;

	@Before
	public void setup() {

		this.mapper = new ObjectMapper();
		Iterable<Person> all = dao.findAll();
		for (Person person : all) {
			dao.remove(person);
		}
	}

	@Test
	@DatabaseSetup("initial-person.xml")
	public void testGetAll() throws JSONException {
		// Arrange
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		Person person = new Person();
		person.setName("A");
		person.setSurname("A1");
		dao.save(person);
		// Act
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/person"), HttpMethod.GET, null,
				String.class);
		// Assert
		JSONAssert.assertEquals("[{'name':'A', 'surname':'A1'}]", response.getBody(), false);
	}
	
//	@Test
//	public void testGetById() throws JSONException {
//		// Arrange
//		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//		Person person = new Person();
//		person.setName("B");
//		person.setSurname("B1");
//		dao.save(person);
//		// Act
//		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/person/1"), HttpMethod.GET, null,
//				String.class);
//		// Assert
//		JSONAssert.assertEquals("[{'name':'B', 'surname':'B1'}]", response.getBody(), false);
//	}

//	@Test
//	public void testCreate() throws JSONException {
//		// Arrange
//		Person person = new Person();
//		person.setName("Fran");
//		person.setSurname("Periago");
//		this.dao.save(person);
//		HttpEntity<Person> entity = new HttpEntity<Person>(person, headers);
//		// Act
//		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/person/"), HttpMethod.POST, entity, String.class);
//		// Assert
//		JSONAssert.assertEquals("[{'id':'1', 'name':'Fran', 'surname':'Periago'}]", response.getBody(),
//				false);
//	}
//
//	@Test
//	public void testRemove() throws JSONException {
//		// Arrange
//		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//		Person personA = new Person();
//		personA.setName("A");
//		personA.setSurname("A1");
//		dao.save(personA);
//		Person personB = new Person();
//		personB.setName("B");
//		personB.setSurname("B1");
//		dao.save(personB);
//		dao.remove(personB);
//		// Act
//		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/person/"), HttpMethod.DELETE, null,
//				String.class);
//		// Assert
//		JSONAssert.assertEquals("[{'id':'1', 'name':'A', 'surname':'A1'}]", response.getBody(),
//				false);
//	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}