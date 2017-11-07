
package io.javabrains.springbootstarter.topic;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.service.ITopicService;

@RestController
@RequestMapping("/topics")
public class TopicController {

	@Autowired
	ITopicService service;

	 private static Logger LOGGER = Logger.getLogger("com.wombat.nose");
		
	
	@RequestMapping("/list")
	public List<Topic> getAllTopics() {
		LOGGER.info("getAllTopics()");
		return service.getAll();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Boolean addTopic(@RequestBody Topic topic) {
		LOGGER.info("addTopic()");
		return service.addTopic(topic);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public Boolean addTopic(@RequestBody Topic topic, @PathVariable String id) {
		
		LOGGER.info("uodateTopic()");
		return service.updateTopic(id, topic);
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Topic addTopic(@PathVariable("id") String id) {

		try {
			return service.getTopic(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
