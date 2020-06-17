package io.springboot.starter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	public Course getCourse(String id) {
		Course course = courseRepository.findById(id).orElse(null);
		System.out.println("inside getCourse id "+course);
		return course;
	}

	public List<Course> getAllCourses(String topicId) {
		List<Course> courseList = new ArrayList<>();
		courseRepository.findByTopicTopicId(topicId)
		.forEach(courseList :: add);
		return courseList;	
	}
	
	public List<Course> getAllCoursesbyCourseName(String courseName) {
		List<Course> courseList = new ArrayList<>();
		courseRepository.findByCourseName(courseName)
		.forEach(courseList :: add);
		System.out.println("inside getAllCoursesbyCourseName id "+courseName);
		return courseList;	
	}
	
	public List<Course> getAllCoursesbyTopicName(String topicName) {
		List<Course> courseList = new ArrayList<>();
		courseRepository.findByTopicTopicName(topicName)
		.forEach(courseList :: add);
		return courseList;	
	}
	
	
	public Course addCourse(Course course) {
		return courseRepository.save(course);
	}
	
	public Course updateCourse(String id, Course course) {
		return courseRepository.save(course);
	}
	
	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}

	public Course getCoursesbyId(String courseId) {
		return courseRepository.findById(courseId).orElse(new Course("Test","Test","Test","1"));
		
	}
	
}
