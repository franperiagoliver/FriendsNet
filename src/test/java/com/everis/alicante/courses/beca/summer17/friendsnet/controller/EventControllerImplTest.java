/*
 * Created at 29-ago-2017 by Fran Periago.
 */
package com.everis.alicante.courses.beca.summer17.friendsnet.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
import org.springframework.test.web.servlet.ResultActions;

import com.everis.alicante.courses.beca.summer17.friendsnet.controller.AbstractControllerTest;
import com.everis.alicante.courses.beca.summer17.friendsnet.controller.EventControllerImpl;
import com.everis.alicante.courses.beca.summer17.friendsnet.controller.GroupControllerImpl;
import com.everis.alicante.courses.beca.summer17.friendsnet.dao.EventDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Event;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Group;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.enums.EventType;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.EventManager;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.PersonManager;
import com.github.springtestdbunit.DbUnitTestExecutionListener;

/**
 * The Class EventControllerImplIT.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
public class EventControllerImplTest extends AbstractControllerTest<Event, Long> {

	/** The manager. */
	@Mock
	private EventManager manager;

	/** The manager. */
	@Mock
	private PersonManager Pmanager;

	/** The person controller. */
	@InjectMocks
	private EventControllerImpl controller;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.controller.
	 * AbstractControllerTest#getBaseURLFindAllAndCreate()
	 */
	@Override
	protected String getBaseURLFindAllAndCreate() {
		return "/event";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.controller.
	 * AbstractControllerTest#getBaseURLFindByIdAndRemove(java.io.Serializable)
	 */
	@Override
	protected String getBaseURLFindByIdAndRemove(final Long id) {
		return "/event" + id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.controller.
	 * AbstractControllerTest#getThenReturnFindAll()
	 */
	@Override
	protected Iterable<Event> getThenReturnFindAll() {
		final Event eventa = new Event();
		eventa.setName("pepe");
		eventa.setType(EventType.GENERAL);
		final Event eventb = new Event();
		eventb.setName("juan");
		eventb.setType(EventType.GENERAL);
		final List<Event> events = new ArrayList<>();
		events.add(eventa);
		events.add(eventb);
		return events;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.controller.
	 * AbstractControllerTest#getThenReturnFindByIdAndCreate()
	 */
	@Override
	protected Event getThenReturnFindByIdAndCreate() {
		final Event event = new Event();
		return event;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.controller.
	 * AbstractControllerTest#getManagerMock()
	 */
	@Override
	protected EventManager getManagerMock() {
		return this.manager;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.controller.
	 * AbstractControllerTest#getController()
	 */
	@Override
	protected EventControllerImpl getController() {
		return this.controller;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.controller.
	 * AbstractControllerTest#getFindById()
	 */
	@Override
	protected Long getFindById() {
		return 1L;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.everis.alicante.courses.beca.summer17.friendsnet.controller.
	 * AbstractControllerTest#getSaveAndRemove()
	 */
	@Override
	protected Event getSaveAndRemove() {
		final Event event = new Event();
		event.setName("Fran");
		event.setType(EventType.GENERAL);
		return event;
	}

	/**
	 * Test add persons.
	 *
	 * @param personIds
	 *            the person ids
	 * @param eventId
	 *            the event id
	 * @return the event
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public Event TestAddPersons(final List<Long> personIds, final Long eventId) throws Exception {
		final Set<Person> persons = (Set<Person>) this.Pmanager.findByIds(personIds);
		final Event event = this.getManagerMock().findById(eventId);
		event.getPersonsInEvent().addAll(persons);
		this.getManagerMock().save(event);
		Mockito.when(this.getManagerMock().addPersons(personIds, eventId)).thenReturn(event);
		// Act
		ResultActions perform = super.getMockMvc()
				.perform(post(this.getBaseURLFindByIdAndRemove(eventId) + "/person/" + personIds + "/add"));
		// Assert
		perform.andExpect(status().isOk());
		perform.andExpect(content().json(super.getMapper().writeValueAsString(event)));
		return event;
	}

	/**
	 * Test get by person id.
	 *
	 * @param personId
	 *            the person id
	 * @return the sets the
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public Set<Event> TestGetByPersonId(final Long personId) throws Exception {
		final Person person = this.Pmanager.findById(personId);
		final Set<Event> events = person.getEvents();
		Mockito.when(this.getManagerMock().getByPersonId(personId)).thenReturn(events);
		// Act
		ResultActions perform = super.getMockMvc()
				.perform(post(this.getBaseURLFindAllAndCreate() + "/person/" + personId));
		// Assert
		perform.andExpect(status().isOk());
		perform.andExpect(content().json(super.getMapper().writeValueAsString(events)));
		return events;
	}
}