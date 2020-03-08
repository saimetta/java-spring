package io.santiago.springcourse.lesson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.santiago.springcourse.course.Course;
import io.santiago.springcourse.topic.Topic;

@RestController
public class LessonController {
	
	
	@Autowired
	private LessonService lessonService;

	@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons")
	public List<Lesson> getAllCourses(@PathVariable String topicId,@PathVariable String courseId) {
		return lessonService.getAllLessons(courseId);
	}

	@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public Lesson getCourse(@PathVariable String topicId,@PathVariable String courseId,@PathVariable Long id) {
		return lessonService.getLesson(id);
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/topics/{topicId}/courses/{courseId}/lessons")
	public void addLesson(@RequestBody Lesson lesson,@PathVariable String topicId,@PathVariable String courseId) {
		Topic topic = new Topic(topicId,"","");
		Course course = new Course(courseId,"","",topicId);
		course.setTopic(topic);
		lesson.setCourse(course);
		lessonService.addLesson(lesson);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public void updateCourse(@RequestBody Lesson lesson,@PathVariable Long id,@PathVariable String topicId,@PathVariable String courseId) {
		Topic topic = new Topic(topicId,"","");
		Course course = new Course(courseId,"","",topicId);
		course.setTopic(topic);
		lesson.setCourse(course);
		lessonService.updateLesson(lesson);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public void deleteCourse(@PathVariable Long id) {
		lessonService.deleteLesson(id);
	}
}

