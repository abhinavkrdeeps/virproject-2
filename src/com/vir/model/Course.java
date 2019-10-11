package com.vir.model;

public class Course {



	 private String CourseID;

	 private String CourseName;

	 

	 

	public Course() {

		super();

	}

	public Course(String courseID, String courseName) {

		super();

		CourseID = courseID;

		CourseName = courseName;

	}

	public String getCourseID() {

		return CourseID;

	}

	public void setCourseID(String courseID) {

		CourseID = courseID;

	}

	public String getCourseName() {

		return CourseName;

	}

	public void setCourseName(String courseName) {

		CourseName = courseName;

	}

	 



	}
