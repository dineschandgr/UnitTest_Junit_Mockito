package io.springboot.starter.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.springboot.starter.topic.Topic;

@Entity
public class Course {

	@Id
	String courseId;
	String courseName;
	String courseDescription;
	
	@ManyToOne
	private Topic topic;
	
	public Course() {
		super();
	}
	
	public Course(String courseId, String courseName, String courseDescription) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
	}
	
	public Course(String courseId, String courseName, String courseDescription, String topicId) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.topic = new Topic(topicId, "", "");
	}
	
	
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
}
