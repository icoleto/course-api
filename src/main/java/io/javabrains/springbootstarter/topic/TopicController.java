
package io.javabrains.springbootstarter.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.service.ITopicService;

@RestController
public class TopicController {

	@Autowired
	ITopicService service;

	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return service.getAll();
	}

	@RequestMapping(value = "/addTopic", method = RequestMethod.POST)
	public Boolean addTopic(@RequestBody Topic topic) {
		return service.addTopic(topic);
	}

	@RequestMapping(value = "/updateTopic/{id}", method = RequestMethod.POST)
	public Boolean addTopic(@RequestBody Topic topic, @PathVariable String id) {
		return service.updateTopic(id, topic);
	}
	
	@RequestMapping(value = "/getTopic/{id}", method = RequestMethod.GET)
	public Topic addTopic(@PathVariable("id") String id) {

		try {
			return service.getTopic(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
