package io.santiago.springcourse.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(
			new Topic("1","Spring Framework","14 hours course"),
			new Topic("2","Java Basic","2 hours course"),
			new Topic("3","Spring Framework advanced","5 hours course")));
	
	public List<Topic> getAllTopics() {
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(String id, Topic topic) {
		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			} 
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}
			
	
}
