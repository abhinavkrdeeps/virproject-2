package com.vir.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vir.model.Batch;
import com.vir.model.Enrollment;

import com.vir.connection.DBConnection;

public class EnrollmentDaoImpl implements EnrollmentDao {
	
	private static final String ADD_ENROLLMENT = "insert into enrollment(batch_id,student_id) values(?,?)";
	private static final String REMOVE_ENROLLMENT = "delete from enrollment where enrollment_id=?";
	private static final String GET_ALL_ENROLLMENT = "select * from enrollment";
	private static final String FIND_BY_STUDENTID = "select * from enrollment where student_id=?";
	private static final String REMOVE_BY_BATCHID= " delete from enrollment where batch_id=?";
	
	public static Connection connection = DBConnection.getConn();
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public boolean addEnrollment(Enrollment enrollment) {
		
			
		try {
			preparedStatement = connection.prepareStatement(ADD_ENROLLMENT);
			//preparedStatement.setInt(1, enrollment.getEnrollmentID());
			preparedStatement.setInt(1,enrollment.getBatchID());
			preparedStatement.setInt(2,enrollment.getStudentID());
			preparedStatement.execute();
			//connection.commit();
			return true;

		}catch(Exception e)
		{
			System.out.println(e.getMessage()+" en add");
		  return false;	
		}finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
		//return false;
	}

	@Override
	public boolean removeEnrollment(Enrollment enrollment) {
		
		try {
			preparedStatement = connection.prepareStatement(REMOVE_ENROLLMENT);
			preparedStatement.setInt(1,enrollment.getEnrollmentID());
			preparedStatement.execute();
			connection.commit();
			return true;
			
		}catch(Exception e)
		{
			return false;
		}
		
		//return false;
	}

	@Override
	public List<Enrollment> getAll() {
		ArrayList<Enrollment> enrollmentList = new ArrayList<>();
		Enrollment enrollment =null;
		try {
			preparedStatement = connection.prepareStatement(GET_ALL_ENROLLMENT);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				enrollment.setBatchID(resultSet.getInt(1));
				enrollment.setEnrollmentID(resultSet.getInt(2));
				enrollment.setStudentID(resultSet.getInt(3));
				enrollmentList.add(enrollment);
			}
			return enrollmentList;
		}catch(Exception e)
		{
			return null;
		}finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public Enrollment findByStudentId(Integer studentId) {
		try {
			preparedStatement = connection.prepareStatement(FIND_BY_STUDENTID);
			preparedStatement.setInt(1, studentId);
			ResultSet resultSet = preparedStatement.executeQuery();
			Enrollment enrollment =null;
			if(resultSet.next())
			{
				enrollment = new Enrollment();
				enrollment.setEnrollmentID(resultSet.getInt(1));
				enrollment.setBatchID(resultSet.getInt(2));
				enrollment.setStudentID(resultSet.getInt(3));
			}
			
			return enrollment;
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}finally {
			
		}
	
	}

	@Override
	public boolean removeByBatch(int id) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = connection.prepareStatement(REMOVE_BY_BATCHID);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			return true;
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}finally {
			try
			{
				preparedStatement.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		
	}

}
