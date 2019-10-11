package com.vir.dao;

import java.util.List;

import com.vir.model.Trainer;

public interface TrainerDao {
	
	List<Trainer> getAllTrainer();
	Trainer findById(int id);
	boolean addTrainer(Trainer trainer);
	boolean removeTrainer(Trainer trainer);
	Trainer findByUsername(String username);

}
