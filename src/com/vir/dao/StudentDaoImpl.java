package com.vir.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.vir.model.Student;

import com.vir.connection.DBConnection;

public class StudentDaoImpl implements StudentDao{
	
	public static Connection connection = DBConnection.getConn();
	
	
	private String FIND_BY_ID = "select * from book where id=?";
	private String FIND_BY_USERNAME ="select * from student where username=?";
	private String GET_ALL_STUDENTS = "select * from student";
	private String ADD_STUDENT = " insert into student(name,father_name,adhar_id,age,username,password) values(?,?,?,?,?,?)";
	private String REMOVE_STUDENT = "delete from student where id=?";
	private String UPDATE_STUDENT = "update student set name=?";
	
	PreparedStatement preparedStatement = null;
	Student student = null;

	@Override
	public List<Student> getAllStudents() {
		System.out.println(connection+" studentdaoimpl");
		ArrayList<Student> studentList = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(GET_ALL_STUDENTS);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				student = new Student();
				student.setSID(resultSet.getString(1));
				student.setSName(resultSet.getString(2));
				student.setFName(resultSet.getString(3));
				student.setUID(resultSet.getString(4));
				student.setAge(Integer.parseInt(resultSet.getString(5)));
				student.setUsername(resultSet.getString(6));
				student.setPass(resultSet.getString(7));
				
			
				System.out.println(student);
				studentList.add(student);
				
			}
			resultSet.close();
			return studentList;
			
		} catch (SQLException e) {
			return null;
		}finally {
			
		}
		
		
	}

	@Override
	public boolean addStudent(Student student) {
		
		try {
			preparedStatement = connection.prepareStatement(ADD_STUDENT);
			//preparedStatement.setInt(1, 1);
			preparedStatement.setString(1, student.getSName());
			preparedStatement.setString(2,student.getFName());
			preparedStatement.setString(3,student.getUID());
			preparedStatement.setInt(4,student.getAge());
			preparedStatement.setString(5,student.getUsername());
			preparedStatement.setString(6,student.getPass());
			
			preparedStatement.execute();
			//connection.commit();
			return true;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//return false;
	}

	@Override
	public boolean removeStudent(Student student) {
		try {
			preparedStatement = connection.prepareStatement(REMOVE_STUDENT);
			preparedStatement.setString(1, student.getSID());
//			/ResultSet resultSet = preparedStatement.executeQuery();
			preparedStatement.execute();
			connection.commit();
			return true;
		} catch (SQLException e) {
			return false;
		}finally {
			try {
				preparedStatement.close();
			}
			
			catch(Exception e) {}
		}
		
		
	}

	@Override
	public boolean updateStudent(Student student) {
		try {
			preparedStatement = connection.prepareStatement(UPDATE_STUDENT);
			preparedStatement.setString(1, student.getSID());
			preparedStatement.executeUpdate();
			connection.commit();
			return true;
			
		}catch(Exception e)
		{
			return false;
			
		}finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public Student findById(String id) {
		Student student =null;
		try {
			preparedStatement = connection.prepareStatement(FIND_BY_ID);
			preparedStatement.setString(1,id);
		    ResultSet resultSet = preparedStatement.executeQuery();
		    if(resultSet.next())
		    {
		    	student = new Student();
		    	student.setSID(resultSet.getString(1));
		    	student.setSName(resultSet.getString(2));
				student.setFName(resultSet.getString(3));
				student.setUID(resultSet.getString(4));
				student.setAge(Integer.parseInt(resultSet.getString(5)));
				student.setUsername(resultSet.getString(6));
				student.setPass(resultSet.getString(7));
		    }
		    
		    return student;
			
		}catch(Exception e)
		{
			return student;
		}
	}

	@Override
	public Student findByUsername(String username) {
		
		try {
			preparedStatement = connection.prepareStatement(FIND_BY_USERNAME);
			preparedStatement.setString(1,username);
			ResultSet resultSet = preparedStatement.executeQuery();
			Student student = new Student();
			
			if(resultSet.next())
			{
				student.setSID(resultSet.getString(1));
				student.setSName(resultSet.getString(2));
				student.setFName(resultSet.getString(3));
				student.setUID(resultSet.getString(4));
				student.setAge(Integer.parseInt(resultSet.getString(5)));
				student.setUsername(resultSet.getString(6));
				student.setPass(resultSet.getString(7));
				return student;
				
			}else {
				return null;
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
			
		}finally {
			
		}
		//return false;
	}

}
