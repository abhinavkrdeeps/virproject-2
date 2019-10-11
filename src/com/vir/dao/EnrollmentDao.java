package com.vir.dao;

import com.vir.model.Enrollment;
import java.util.List;

public interface EnrollmentDao {
	
	boolean addEnrollment(Enrollment enrollment);
	boolean removeEnrollment(Enrollment enrollment);
	List<Enrollment> getAll();
	Enrollment findByStudentId(Integer studentId);
	
	boolean removeByBatch(int id);
	
	

}
