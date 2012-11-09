package models;

import java.util.ArrayList;

import business.SeekUsersWithGivenSubject;

public class TraineeWithField{
	private ArrayList<User> trainee;
	private String field;
	
	public TraineeWithField(){
		trainee = new ArrayList<User>();
		field = "";
	}
	
	public TraineeWithField(String field){
		this.field = field;
		trainee = new SeekUsersWithGivenSubject(field).getTrainee();
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public ArrayList<User> getTrainee() {
		return trainee;
	}

	public void setTrainee(ArrayList<User> trainee) {
		this.trainee = trainee;
	}
}
