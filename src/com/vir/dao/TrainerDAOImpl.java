package com.vir.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vir.connection.DBConnection;
import com.vir.model.Course;
import com.vir.model.Student;
import com.vir.model.Trainer;

import jdk.nashorn.internal.runtime.Specialization;

public class TrainerDAOImpl implements TrainerDao {
	
	public static Connection connection = DBConnection.getConn();
	
	private String GET_ALL_TRAINER = "select * from trainer";
	private String FIND_BY_ID = "select * from trainer where tid=?";
	private String REMOVE_BY_ID= "delete from trainer where tid=?";
	private String ADD	=" insert into trainer(name,uid,age,specialization,username,password) values(?,?,?,?,?,?)";
	private String FIND_BY_USERNAME = "select * from trainer where name=?";
	
	PreparedStatement preparedStatement = null;

	@Override
	public List<Trainer> getAllTrainer() {
		ArrayList<Trainer> trainerList = new ArrayList<>();
		Trainer trainer =null;
		
		try {
            preparedStatement = connection.prepareStatement(GET_ALL_TRAINER);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				trainer = new Trainer();
				trainer.setTrainerID(resultSet.getInt(1));
				trainer.setTrainerName(resultSet.getString(2));
				trainer.setUID(resultSet.getString(3));
				trainer.setAge(resultSet.getInt(4));
				trainer.setUsername(resultSet.getString(5));
				trainer.setPassword(resultSet.getString(6));
				trainerList.add(trainer);
				
			}
			return trainerList;
			
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
		finally
		{
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

	@Override
	public Trainer findById(int id) {
		//Trainer trainer = null;
		 try {
			// trainer =new Trainer();
			 preparedStatement = connection.prepareStatement(FIND_BY_ID);
			 preparedStatement.setInt(1, id);
			 ResultSet resultSet = preparedStatement.executeQuery();
			 Trainer trainer = null;
			 if(resultSet.next())
			 {
				 trainer = new Trainer();
				 trainer.setTrainerID(resultSet.getInt(1));
				 trainer.setTrainerName(resultSet.getString(2));
				 trainer.setUID(resultSet.getString(3));
				 trainer.setAge(resultSet.getInt(4));
				 trainer.setUsername(resultSet.getString(5));
				 trainer.setPassword(resultSet.getString(6));
			 }
			 return trainer;
		 }catch(Exception e)
		 {
			 System.out.println(e.getMessage());
			 return null;
		 }
	}

	
	@Override
	public boolean addTrainer(Trainer trainer) {
		// TODO Auto-generated method stub
		
		try {
			preparedStatement = connection.prepareStatement(ADD);
			preparedStatement.setString(1, trainer.getTrainerName());
			preparedStatement.setString(2,trainer.getUID());
			preparedStatement.setInt(3,trainer.getAge());
			preparedStatement.setString(4,trainer.getSpecialization());
			preparedStatement.setString(5,trainer.getUsername());
			preparedStatement.setString(6,trainer.getPassword());
			preparedStatement.execute();
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
	}

	@Override
	public boolean removeTrainer(Trainer trainer) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = connection.prepareStatement(REMOVE_BY_ID);
			preparedStatement.setInt(1, trainer.getTrainerID());
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

	@Override
	public Trainer findByUsername(String username) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = connection.prepareStatement(FIND_BY_USERNAME);
			preparedStatement.setString(1,username);
			ResultSet resultSet = preparedStatement.executeQuery();
			Trainer t=new Trainer();
			
			if(resultSet.next())
			{
				t.setTrainerID(resultSet.getInt(1));
				t.setTrainerName(resultSet.getString(2));
				t.setUID(resultSet.getString(3));
				t.setAge(resultSet.getInt(4));
				t.setSpecialization(resultSet.getString(5));
				t.setUsername(resultSet.getString(6));
				t.setPassword(resultSet.getString(7));
				return t;
				
			}else {
				return null;
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
			
		}finally {
			
		}
		
	}

}
