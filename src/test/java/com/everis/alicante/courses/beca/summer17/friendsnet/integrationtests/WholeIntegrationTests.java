package com.everis.alicante.courses.beca.summer17.friendsnet.integrationtests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EventControllerImplIT.class, GroupControllerImplIT.class, PersonControllerImplIT.class,
		PostControllerImplIT.class })
public class WholeIntegrationTests {

}
