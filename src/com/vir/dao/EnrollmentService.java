package com.vir.dao;

import java.util.List;

import com.vir.model.Enrollment;

public interface EnrollmentService {
	
	
	boolean addEnrollment(Enrollment enrollment);
	boolean removeEnrollment(Enrollment enrollment);
	List<Enrollment> getAll();
	Enrollment findByStudentId(Integer studentId);
	
	boolean removeByBatch(int id);

}
