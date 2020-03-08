package io.santiago.springcourse.lesson;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.santiago.springcourse.course.Course;

@Entity
public class Lesson {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	@ManyToOne
	private Course course;
	
	public Lesson() {
	}
	
	public Lesson(String name, String description,String topicId,String courseId) {
		super();
		this.name = name;
		this.description = description;
		this.course = new Course(courseId,"","",topicId);
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	
}
