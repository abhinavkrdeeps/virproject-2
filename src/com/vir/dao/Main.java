package com.vir.dao;
import java.util.*;

import com.vir.model.Student;
public class Main {

	public static void main(String[] args) {
		
		StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
		
		List<Student> studentList = studentServiceImpl.getAllStudents();
		
		
		for(Student student:studentList)
		{
			System.out.println(student);
		}
		
		

	}

}
