package com.vir.dao;

import java.util.List;

import com.vir.model.Enrollment;

public class EnrollmentServiceImpl implements EnrollmentService{
	
	private EnrollmentDaoImpl edao = new EnrollmentDaoImpl();

	@Override
	public boolean addEnrollment(Enrollment enrollment) {
		// TODO Auto-generated method stub
		return edao.addEnrollment(enrollment);
	}

	@Override
	public boolean removeEnrollment(Enrollment enrollment) {
		// TODO Auto-generated method stub
		return edao.removeEnrollment(enrollment);
	}

	@Override
	public List<Enrollment> getAll() {
		// TODO Auto-generated method stub
		return edao.getAll();
	}

	
	@Override
	public Enrollment findByStudentId(Integer studentId) {
		// TODO Auto-generated method stub
		return edao.findByStudentId(studentId);
	}

	@Override
	public boolean removeByBatch(int id) {
		// TODO Auto-generated method stub
		return edao.removeByBatch(id);
	}

}
