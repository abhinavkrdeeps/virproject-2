package com.vir.dao;

import java.util.List;

import com.vir.model.Student;

public class StudentServiceImpl implements StudentService{
	
	private StudentDaoImpl sdao = new StudentDaoImpl();

	@Override
	public Student findById(String id) {
		// TODO Auto-generated method stub
		return sdao.findById(id);
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return sdao.getAllStudents();
	}

	@Override
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		return sdao.addStudent(student);
	}

	@Override
	public boolean removeStudent(Student student) {
		// TODO Auto-generated method stub
		return sdao.removeStudent(student);
	}

	@Override
	public boolean updateStudent(Student student) {
		// TODO Auto-generated method stub
		return sdao.updateStudent(student);
	}

}
