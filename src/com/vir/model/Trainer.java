package com.vir.model;

public class Trainer {



	private int TrainerID;
	private String TrainerName;
	private String UID;
	private int age;
	private String Specialization;
	private String username;
	private String password;
	public Trainer() {
		super();
	}
	public Trainer(int trainerID, String trainerName, String uID, int age, String specialization, String username,
			String password) {
		super();
		TrainerID = trainerID;
		TrainerName = trainerName;
		UID = uID;
		this.age = age;
		Specialization = specialization;
		this.username = username;
		this.password = password;
	}
	public int getTrainerID() {
		return TrainerID;
	}
	public void setTrainerID(int trainerID) {
		TrainerID = trainerID;
	}
	public String getTrainerName() {
		return TrainerName;
	}
	public void setTrainerName(String trainerName) {
		TrainerName = trainerName;
	}
	public String getUID() {
		return UID;
	}
	public void setUID(String uID) {
		UID = uID;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSpecialization() {
		return Specialization;
	}
	public void setSpecialization(String specialization) {
		Specialization = specialization;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Trainer [TrainerID=" + TrainerID + ", TrainerName=" + TrainerName + ", UID=" + UID + ", age=" + age
				+ ", Specialization=" + Specialization + ", username=" + username + ", password=" + password + "]";
	}

	
	
}