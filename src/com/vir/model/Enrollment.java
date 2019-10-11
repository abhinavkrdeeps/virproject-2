package com.vir.model;

public class Enrollment {



	private Integer EnrollmentID;

	private Integer BatchID;

	private Integer StudentID;

	

	public Enrollment() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Enrollment(Integer enrollmentID, Integer batchID, Integer studentID) {

		super();

		EnrollmentID = enrollmentID;

		BatchID = batchID;

		StudentID = studentID;

	}



	public Integer getEnrollmentID() {

		return EnrollmentID;

	}



	public void setEnrollmentID(Integer enrollmentID) {

		EnrollmentID = enrollmentID;

	}



	public Integer getBatchID() {

		return BatchID;

	}



	public void setBatchID(Integer batchID) {

		BatchID = batchID;

	}



	public Integer getStudentID() {

		return StudentID;

	}



	public void setStudentID(Integer studentID) {

		StudentID = studentID;

	}

	

	

}