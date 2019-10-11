package com.vir.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vir.connection.DBConnection;
import com.vir.model.Batch;
import com.vir.model.Course;

public class BatchDAOImpl implements BatchDao {
	public static Connection conn=DBConnection.getConn();
	PreparedStatement ps=null;
	ResultSet rs=null;
	private String query1="select * from Batch";
	private String query2="insert into Batch(course_id,start_date,end_date,course_fee) values(?,?,?,?)";
	private String query3="update Batch set CourseID=?,StartDate=?,EndDate=?,Price=? where batch_id=?";
	private String query4="delete from Batch where batch_id=?";
	private static final String FIND_BY_ID = "select * from batch where batch_id=?";
	Batch b=null;
	ArrayList<Batch> al=new ArrayList<>();

	public ArrayList<Batch> getAllBatch() {
		// TODO Auto-generated method stub
		try
		{
			ps=conn.prepareStatement(query1);
			rs=ps.executeQuery();
			while(rs.next())
			{
				b=new Batch();
				b.setBatchID(rs.getInt(1));
				b.setCourseID(rs.getInt(2));
				b.setStartDate(rs.getDate(3));
				b.setEndDate(rs.getDate(4));
				b.setPrice(rs.getDouble(5));
				al.add(b);
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

	public boolean addBatch(Batch b) {
		// TODO Auto-generated method stub
		try
		{
			ps=conn.prepareStatement(query2);
			//ps.setInt(1, b.getBatchID());
			ps.setInt(1, b.getCourseID());
			ps.setDate(2,b.getStartDate());
			ps.setDate(3, b.getEndDate());
			ps.setDouble(4, b.getPrice());
			ps.executeUpdate();
			//conn.commit();
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

	public boolean updateCourse(Batch b) {
		// TODO Auto-generated method stub
		try {
			ps=conn.prepareStatement(query3);
			ps.setInt(1, b.getBatchID());
			ps.executeUpdate();
			conn.commit();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean removeBatch(Batch b) {
		// TODO Auto-generated method stub
		try {
			ps=conn.prepareStatement(query4);
			ps.setInt(1, b.getBatchID());
			ps.executeUpdate();
			return true;
			}
			catch(Exception e) {
				e.printStackTrace();
				return false;
			}
	}

	@Override
	public boolean updateBatch(Batch batch) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Batch findById(Integer id) {

     try {
    	 ps = conn.prepareStatement(FIND_BY_ID);
    	 ps.setInt(1, id);
    	 ResultSet resultSet = ps.executeQuery();
    	 Batch batch = null;
    	 if(resultSet.next())
    	 {
    		 batch = new Batch();
    		 batch.setBatchID(resultSet.getInt(1));
    		 batch.setCourseID(resultSet.getInt(2));
    		 batch.setStartDate(resultSet.getDate(3));
    		 batch.setEndDate(resultSet.getDate(4));
    		 batch.setPrice(resultSet.getDouble(5));
    		
    	 }
    	 return batch;
     }catch(Exception e)
     {
    	 System.out.println(e.getMessage());
    	 return null;
     }finally {
    	 
     }
	//return b;
	}	
}
