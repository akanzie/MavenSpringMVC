package com.javaweb.dao;

import java.util.List;

import com.javaweb.model.NewModel;

public interface INewDAO extends GenericDAO<NewModel>{
	NewModel findOne(Long id);
	List<NewModel> findCategoryId(Long categoryId);
	Long save(NewModel newModel);
	void update(NewModel updateNew);
	void delete(long id);
	List<NewModel> findAll();
	int getTotalItem();
}
