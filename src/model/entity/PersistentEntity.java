package model.entity;

import model.exception.EntityAlreadyExistException;

public interface PersistentEntity {
	void createIfNotExist() throws EntityAlreadyExistException;
	void deleteThis();
	void updateThis();
	boolean verifyExistent();
}
