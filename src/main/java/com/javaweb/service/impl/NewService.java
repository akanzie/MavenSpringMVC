package com.javaweb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.javaweb.dao.ICategoryDAO;
import com.javaweb.dao.INewDAO;
import com.javaweb.model.CategoryModel;
import com.javaweb.model.NewModel;
import com.javaweb.service.INewService;

public class NewService implements INewService {
	@Inject
	private INewDAO newDao;

	@Inject
	private ICategoryDAO categoryDAO;

	@Override
	public List<NewModel> findCategoryId(Long categoryId) {
		return newDao.findCategoryId(categoryId);
	}
	@Override
	public NewModel save(NewModel newModel) {
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		newModel.setCreatedBy("");
		Long newId = newDao.save(newModel);
		return newDao.findOne(newId);
	}

	@Override
	public NewModel update(NewModel updateNew) {
		NewModel oldNew = newDao.findOne(updateNew.getId());
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		updateNew.setModifiedBy("");
		newDao.update(updateNew);
		return newDao.findOne(updateNew.getId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id: ids) {
			//1.delete comment (khoa ngoai new_id)
			//2.delete news
			newDao.delete(id);
		}
	}
	@Override
	public List<NewModel> findAll() {
		return newDao.findAll();
	}

	
}
