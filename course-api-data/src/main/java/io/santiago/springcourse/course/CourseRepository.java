package io.santiago.springcourse.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {

	/*
	Spring will implement the method if it follows the standard
	find By <Property> if property is and object, you have to specify
	which property, for example Topic->id findByTopicId 
	*/
	public List<Course> findByTopicId(String topicId);
}
