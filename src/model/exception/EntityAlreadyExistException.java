package model.exception;

public class EntityAlreadyExistException extends Exception{
	
	private String identify;
	
	public EntityAlreadyExistException(String identify) {
		this.identify = identify;
	}
	
	@Override
	public String toString() {
		return this.identify+" já existe";
	}
}
