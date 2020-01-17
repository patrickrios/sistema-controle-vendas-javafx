package model.entity;

public interface PersistentEntity {
	void createIfNotExist();
	void deleteThis();
	void updateThis();
	boolean verifyExistent();
}
