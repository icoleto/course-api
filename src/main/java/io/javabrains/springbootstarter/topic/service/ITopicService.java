package io.javabrains.springbootstarter.topic.service;

import java.util.List;

import io.javabrains.springbootstarter.topic.Topic;

public interface ITopicService {

	List<Topic> getAll();
	
	Boolean addTopic(Topic topic);
	
	Topic getTopic(String id) throws Exception;

	Boolean updateTopic(String id, Topic topic);
}
