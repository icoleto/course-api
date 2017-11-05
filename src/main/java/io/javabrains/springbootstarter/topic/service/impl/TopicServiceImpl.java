package io.javabrains.springbootstarter.topic.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import io.javabrains.springbootstarter.topic.Topic;
import io.javabrains.springbootstarter.topic.service.ITopicService;
@Service
public class TopicServiceImpl implements ITopicService {

	private List<Topic> topicList = new ArrayList<>();
	@Override
	public List<Topic> getAll() {
		return topicList;
	}

	@Override
	public Boolean addTopic(Topic topic) {
		
		return topicList.add(topic);
	}
	
	@Override
	public Topic getTopic(String id) throws Exception{
		return topicList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
//		for (Topic topic : topicList) {
//			if (topic.getId().equals(id)) {
//				return topic;
//			}
//		}
//		throw new Exception(String.format("No Topic found with [%s] id", id));
		
	}
	
	@PostConstruct
	public void initIt() throws Exception {
	  topicList.addAll(Arrays.asList(new Topic("spring", "springFramework", "spring Description"),
				new Topic("java", "core java", "java Description"),
				new Topic("spring", "springFramework", "spring Description")));
	}

	@Override
	public Boolean updateTopic(String id, Topic topic) {
		for (int i = 0; i < topicList.size(); i++) {
			if (topicList.get(i).getId().equals(id)) {
				topicList.set(i, topic);
				return true;
			}
		}
		
		return false;
	}
}
