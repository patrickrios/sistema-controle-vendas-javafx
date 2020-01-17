package model.dao;

import model.entity.PersistentEntity;

public interface PersistentDAO {
	void save(PersistentEntity entity);
	void delete(int id);
	void update(PersistentEntity entity);
	boolean findById(int id);
	boolean findByCode(String code);
}
