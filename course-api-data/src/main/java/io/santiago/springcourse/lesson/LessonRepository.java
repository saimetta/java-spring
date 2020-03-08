package io.santiago.springcourse.lesson;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LessonRepository extends CrudRepository<Lesson, Long> {

	/*
	Spring will implement the method if it follows the standard
	find By <Property> if property is and object, you have to specify
	which property, for example Topic->id findByTopicId 
	*/
	public List<Lesson> findByCourseId(String courseId);
}
