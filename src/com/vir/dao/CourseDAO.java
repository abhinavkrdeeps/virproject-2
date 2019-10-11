package com.vir.dao;

import java.util.List;

import com.vir.model.Course;


public interface CourseDAO {
	List<Course> getAllCourses();
	boolean addCourse(Course c);
	boolean updateCourse(Course c);
	boolean removeCourse();
	Course findById(Integer id);
}
