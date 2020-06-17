package io.springboot.starter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface CourseRepository extends CrudRepository<Course, String> {

	public List<Course> findByCourseName(String courseName);
	public List<Course> findByTopicTopicId(String topicId);
	public List<Course> findByTopicTopicName(String topicName);
	
}
