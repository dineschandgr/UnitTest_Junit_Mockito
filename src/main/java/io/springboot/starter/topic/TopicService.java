package io.springboot.starter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;

	/*private List<Topic> topicList = new ArrayList<>(Arrays.asList(
			new Topic("1","Java","Java Topic"),
			new Topic("2","React","ReactTopic"),
			new Topic("3","AWS","AWS Topic")));*/
	

	public Topic getTopic(String id) {
		return topicRepository.findById(id).orElse(null);
	}

	public List<Topic> getAllTopics() {
		//return (List<Topic>) topicRepository.findAll();
		List<Topic> topicList = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topicList :: add);
		return topicList;	
	}
	
	
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}
	
	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
	}
	
	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}
	
	/*
	public void createTopic(Topic topic) {
		topicRepository.add(topic);
	}

	public void updateTopic(Topic topic, String id) {

		for(int i=0;i<topicList.size();i++){
			Topic oldTopic = topicList.get(i);
			if(oldTopic.getCourseId().equals(id)) {
				topicList.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		
		topicList.removeIf(t->t.courseId.equals(id));
	}
*/
}
