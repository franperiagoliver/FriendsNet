/*
 * Created at 30-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.manager;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.repository.CrudRepository;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.EntityDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.dao.PersonDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.impl.PersonManagerImpl;

/**
 * The Class PersonManagerImplTest.
 */
@RunWith(MockitoJUnitRunner.class)
public class PersonManagerImplTest {

	/** The person manager impl. */
	@InjectMocks
	private PersonManagerImpl personManagerImpl;

	@Mock
	private PersonDAO personDAOMock;

	/** The person. */
	private Person person;

	/**
	 * Inits the.
	 */
	@Before
	public void init() {
		this.person = new Person();
		person.setName("asd");
		person.setId(1L);
	}

	/**
	 * Test find all.
	 */
	@Test
	public void testFindAll() {
		// Arrange
		Iterable<Person> expectPersons = new ArrayList<Person>();
		Mockito.when(personDAOMock.findAll()).thenReturn(expectPersons);
		// Act
		Iterable<Person> persons = personManagerImpl.findAll();
		// Assert
		Assert.assertEquals(expectPersons, persons);
	}

	/**
	 * Test find by id.
	 */
	@Test
	public void testFindById() {
		// Arrange
		final Person person = new Person();
		Mockito.when(personDAOMock.findOne(1L)).thenReturn(person);
		// Act
		Person expectedPersonId = personManagerImpl.findById(1L);
		// Assert
		Assert.assertEquals(person, expectedPersonId);
	}

	@Test
	public void testCreate() {
		// Arrange
		Person newPerson = new Person();
		Person expected = new Person();
		Mockito.when(personDAOMock.save(newPerson)).thenReturn(expected);
		// Act
		Person result = personManagerImpl.save(newPerson);
		// Assert
		Assert.assertEquals(expected, result);
	}
	

	@Test
	public void testCreateIterable() {
		// Arrange
		Iterable<Person> newPerson = new HashSet<>();
		Iterable<Person> expected = new HashSet<>();
		Mockito.when(personDAOMock.save(newPerson)).thenReturn(expected);
		// Act
		Iterable<Person> result = personManagerImpl.save(newPerson);
		// Assert
		Assert.assertEquals(expected, result);
	}
}