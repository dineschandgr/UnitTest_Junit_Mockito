package io.springboot.starter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import io.springboot.starter.course.Course;
import io.springboot.starter.course.CourseRepository;
import io.springboot.starter.course.CourseService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DisplayName(value = "Spring Boot Application Test")
public class SpringBootTestApplicationTests {

	@Autowired
	CourseService courseService;
	
	@MockBean
	CourseRepository courseRepositoryMock;

	@DisplayName(value = "Test getCourse Method")
	@Test
	public void getCourseTest() {
		List<Course> courseList = new ArrayList<Course>();
		courseList.add(new Course("Test","Test","Test","1"));
		Optional<Course> optionalList = courseList.stream().findFirst();
		
		when(courseRepositoryMock.findById("Test")).thenReturn(optionalList);
		assertEquals(optionalList.get().getCourseId(),courseService.getCourse("Test").getCourseId());
	}

	@Test
	@DisplayName(value = "Test getAllCoursesbyCourseNameTest Method")
	public void getAllCoursesbyCourseNameTest() {
		String courseName = "php";
		when(courseRepositoryMock.findByCourseName(courseName)).thenReturn(Stream.of(new Course("Php","Php","Php")).collect(Collectors.toList()));
		assertEquals(1,courseService.getAllCoursesbyCourseName("php").size());
	}
	
	@Test
	@DisplayName(value = "Test addCourseTest Method")
	public void addCourseTest() {
		Course course  = new Course("Java","Java","Java");
		when(courseRepositoryMock.save(course)).thenReturn(course);
		assertEquals(course, courseService.addCourse(course));
	}
	
	@Test
	@DisplayName(value = "Test addCourseTest Method")
	public void deleteCourseTest() {
		String courseId = "Java";
		courseService.deleteCourse("Java");
		verify(courseRepositoryMock,times(1)).deleteById(courseId);
	}
	
	/*
	 * public void updateCourseTest() { Course course = new
	 * Course("Java","Java","Java");
	 * when(courseRepositoryMock.save(course)).thenReturn(course);
	 * assertEquals(course, courseService.addCourse(course)); }
	 */
	/*
	 * public void addCourse(e) { courseRepository.save(course); }
	 * 
	 * public void updateCourse(String id, Course course) {
	 * courseRepository.save(course); }
	 * 
	 * 
	 * 
	 * public void deleteCourse(String id) { courseRepository.deleteById(id); }
	 */
	
	
	
	/*
	 * public List<Course> getAllCourses(String topicId) { List<Course> courseList =
	 * new ArrayList<>(); courseRepository.findByTopicTopicId(topicId)
	 * .forEach(courseList :: add); return courseList; }
	 */
	
	/*
	 * @Test public void addCourse() {
	 * 
	 * Course course = new Course("Test","Test","Test","1");
	 * courseServiceMock.addCourse(course);
	 * 
	 * verify(courseRepositoryMock, times(1)).save(course); }
	 */

	
}
