package com.vir.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vir.connection.DBConnection;
import com.vir.model.Course;

public class CourseDAOImpl implements CourseDAO{
	
	public static Connection conn=DBConnection.getConn();
	PreparedStatement ps=null;
	ResultSet rs=null;
	private String query1="select * from Course";
	private String query2="insert into Course values(?,?)";
	private String query3="update Course set CourseName=? where CourseID=?";
	private String query4="delete from Course where CourseID=?";
	private static final String FIND_BY_ID="select * from course where cid=?";
	Course c=null;
	ArrayList<Course> al=new ArrayList<>();

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		try
		{
			ps=conn.prepareStatement(query1);
			rs=ps.executeQuery();
			while(rs.next())
			{
				c=new Course();
				c.setCourseID(rs.getString(1));
				c.setCourseName(rs.getString(2));
				al.add(c);
			}
			return al; 
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally {
			try
			{
				ps.close();
			}
			catch(SQLException e)
			{
				
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public boolean addCourse(Course c) {
		// TODO Auto-generated method stub
		try
		{
			ps=conn.prepareStatement(query2);
			ps.setString(1, c.getCourseID());
			ps.setString(2, c.getCourseName());
			ps.execute();
			conn.commit();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally
		{
			try
			{
				ps.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean updateCourse(Course c) {
		// TODO Auto-generated method stub
		try {
			ps=conn.prepareStatement(query3);
			ps.setString(1, c.getCourseID());
			ps.executeUpdate();
			conn.commit();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean removeCourse() {
		// TODO Auto-generated method stub
		try {
			ps=conn.prepareStatement(query4);
			ps.setString(1, c.getCourseID());
			ps.execute();
			conn.commit();
			return true;
			}
			catch(Exception e) {
				e.printStackTrace();
				return false;
			}
	}

	@Override
	public Course findById(Integer id) {

		 try {
			 ps = conn.prepareStatement(FIND_BY_ID);
			 ps.setInt(1, id);
			 ResultSet resultSet = ps.executeQuery();
			 Course course = null;
			 if(resultSet.next())
			 {
				 course = new Course();
				 course.setCourseID(resultSet.getString(1));
				 course.setCourseName(resultSet.getString(2));
			 }
			 return course;
		 }catch(Exception e)
		 {
			 System.out.println(e.getMessage());
			 return null;
		 }
		//return null;
	}	
	
}
