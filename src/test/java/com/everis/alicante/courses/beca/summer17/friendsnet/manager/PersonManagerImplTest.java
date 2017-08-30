/*
 * Created at 30-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.manager;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

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

	/** The person DAO mock. */
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
}