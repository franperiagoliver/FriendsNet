/*
 * Created at 24-ago-2017 by Fran Periago
 */
package com.everis.alicante.courses.beca.summer17.friendsnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Class FriendsnetApplication.
 */
@SpringBootApplication(scanBasePackages = { "com.everis.alicante.courses.beca.summer17.friendsnet.controller",
		"com.everis.alicante.courses.beca.summer17.friendsnet.dao.classes",
		"com.everis.alicante.courses.beca.summer17.friendsnet.dao.classes.impl",
		"com.everis.alicante.courses.beca.summer17.friendsnet.manager.classes.impl",
		"com.everis.alicante.courses.beca.summer17.friendsnet.manager.interfaces"})
public class FriendsnetApplication {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(FriendsnetApplication.class, args);
	}
}