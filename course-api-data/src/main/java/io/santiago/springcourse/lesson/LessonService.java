package io.santiago.springcourse.lesson;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LessonService {

	@Autowired
	private LessonRepository lessonRepository;
	

	public List<Lesson> getAllLessons(String courseId) {
		List<Lesson> lesson = new ArrayList<>();
		lessonRepository.findByCourseId(courseId).forEach(lesson::add);
		return lesson;
	}

	public Lesson getLesson(Long id) {
		return lessonRepository.findOne(id);
	}

	public void addLesson(Lesson lesson) {
		lessonRepository.save(lesson);
		
	}

	public void updateLesson(Lesson lesson) {
		lessonRepository.save(lesson);
		
	}

	public void deleteLesson(Long id) {
		lessonRepository.delete(id);	
	}


			
	
}
