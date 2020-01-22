package controller;

import model.entity.PersistentEntity;

public interface ListItemController {
	void initi(PersistentEntity entity);
	void initiAfterAdded(double width,int index);
}
