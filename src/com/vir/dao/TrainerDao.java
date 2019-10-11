package com.vir.dao;

import java.util.List;

import com.vir.model.Trainer;

public interface TrainerDao {
	
	List<Trainer> getAllTrainer();
	Trainer findById(String id);
	boolean updateTrainer(Trainer trainer);
	boolean addTrainer(Trainer trainer);
	boolean removeTrainer(Trainer trainer);
	

}
