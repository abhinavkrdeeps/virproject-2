package com.vir.dao;

import java.util.List;

import com.vir.model.Batch;

public interface BatchDao {
	
	List<Batch> getAllBatch();

	boolean addBatch(Batch batch);

	boolean removeBatch(Batch batch);

	boolean updateBatch(Batch batch);
	
	Batch findById(Integer id);
}
