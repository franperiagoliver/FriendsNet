package com.everis.alicante.courses.beca.summer17.friendsnet.controller.social;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/twitter")
@Transactional
public class TwitterController {

	private final ConnectionRepository connectionRepository;
	private final Twitter twitter;

	@Inject
	public TwitterController(Twitter twitter, ConnectionRepository connectionRepository) {
		this.twitter = twitter;
		this.connectionRepository = connectionRepository;
	}

	@GetMapping
	public String getTimeline(Model model) {
		if (!isTwitterLogged()) {
			return "redirect:/connect/twitter";
		}

		retrieveTweets(model);

		return "home";
	}

	@PostMapping
	public String createTweet(Model model, @RequestBody String text) {
		twitter.timelineOperations().updateStatus(text);

		retrieveTweets(model);

		return "home";
	}

	private void retrieveTweets(Model model) {
		model.addAttribute("twitterProfile", twitter.userOperations().getUserProfile().getName());
		model.addAttribute("timeline", twitter.timelineOperations().getHomeTimeline());
		model.addAttribute("myTweets", twitter.timelineOperations().getUserTimeline());
		model.addAttribute("favorites", twitter.timelineOperations().getFavorites());
	}

	private boolean isTwitterLogged() {
		return connectionRepository.findPrimaryConnection(Twitter.class) != null;
	}
}