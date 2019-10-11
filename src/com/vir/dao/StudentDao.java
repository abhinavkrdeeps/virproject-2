package com.vir.dao;

import java.util.*;

import com.vir.model.Student;
public interface StudentDao {
	
	
	Student findById(String id);
	List<Student> getAllStudents();
	boolean addStudent(Student student);
	boolean removeStudent(Student student);
	boolean updateStudent(Student student);
	Student findByUsername(String username);
	 

}
