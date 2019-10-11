package com.vir.controller;

import java.util.*;
import com.vir.model.*;
import com.vir.dao.*;


public class BuisnessService {
	
	StudentDao studentdao = new StudentDaoImpl();
	TrainerDao tdao=new TrainerDAOImpl();	
	
	public boolean checkForUniqueUsername(String username)
	{
		if(studentdao.findByUsername(username)!=null)
			return false;
		
		return true;
	}
	
	public Student validateStudent(String username,String password,String type) {
			Student student = studentdao.findByUsername(username);
		if(student!=null)
		{
			if(student.getPass().equals(password))
			{
				return student;
			}
			else
			{
				return null;
			}
		}else {
			return new Student();
		}
			
	}
	
	public boolean isAlreadyEnrolledInSomeCourse(Integer StudentId)
	{
		EnrollmentService enrollmentService = new EnrollmentServiceImpl();
		Enrollment enrollment = enrollmentService.findByStudentId(StudentId);
		if(enrollment!=null)
			return true;
		else
			return false;
		
	}
	public boolean checkForUniqueTrainer(String username)
	{
		if(tdao.findByUsername(username)!=null)
			return false;
		
		return true;
	}
	

}
