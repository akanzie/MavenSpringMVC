package com.javaweb.dao.impl;

import java.util.List;

import com.javaweb.dao.INewDAO;
import com.javaweb.mapper.NewMapper;
import com.javaweb.model.NewModel;

public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {
	 @Override
	 public List<NewModel> findCategoryId(Long categoryId){ 
		 String sql = "SELECT * FROM news where categoryid = ?";
		 return query(sql,new NewMapper(), categoryId);
	 }

	@Override
	public NewModel findOne(Long id) {
		String sql = "SELECT * FROM news WHERE id = ?";
		List<NewModel> news = query(sql, new NewMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public Long save(NewModel newModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO news (title, content,");
		sql.append(" thumbnail, shortdescription, categoryid, createddate, createdby)");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(), newModel.getTitle(), newModel.getContent(), 
				newModel.getThumbnail(), newModel.getShortDescription(), newModel.getCategoryId(),
				newModel.getCreatedDate(), newModel.getCreatedBy());
	}
	@Override
	public void update(NewModel updateNew) {
		StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumbnail = ?,");
		sql.append(" shortdescription = ?, content = ?, categoryid = ?,");
		sql.append(" createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? WHERE id = ?");
		update(sql.toString(), updateNew.getTitle(), updateNew.getThumbnail(), updateNew.getShortDescription(),
				updateNew.getContent(), updateNew.getCategoryId(), updateNew.getCreatedDate(), 
				updateNew.getCreatedBy(), updateNew.getModifiedDate(), 
				updateNew.getModifiedBy(), updateNew.getId());
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM news WHERE id = ?";
		update(sql, id);
	}

	@Override
	public List<NewModel> findAll() {
		String sql = "SELECT * FROM news";
		 return query(sql,new NewMapper());
	}

	@Override
	public int getTotalItem() {
		
		return 0;
	}

}
