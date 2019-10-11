package com.vir.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.vir.connection.DBConnection;
import com.vir.model.Student;
import com.vir.model.Trainer;

public class TrainerDAOImpl implements TrainerDao {
	
	public static Connection connection = DBConnection.getConn();
	
	private String GET_ALL_TRAINER = "select * from trainer";
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
				
			}
			
		}catch(Exception e)
		{
			
		}
		
		return null;
	}

	@Override
	public Trainer findById(String id) {
		
		return null;
	}

	@Override
	public boolean updateTrainer(Trainer trainer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addTrainer(Trainer trainer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeTrainer(Trainer trainer) {
		// TODO Auto-generated method stub
		return false;
	}

}
