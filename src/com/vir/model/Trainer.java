package com.vir.model;

public class Trainer {



	private String TrainerID;
	private String TrainerName;
	private String UID;
	private int age;
	private String Specialization;
	private String username;
	private String password;

	
	public Trainer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trainer(String trainerID, String trainerName, String uID, String specialization, String username,

			String password) {

		super();

		TrainerID = trainerID;

		TrainerName = trainerName;

		UID = uID;

		Specialization = specialization;

		this.username = username;

		this.password = password;

	}

	public String getTrainerID() {

		return TrainerID;

	}

	public void setTrainerID(String trainerID) {

		TrainerID = trainerID;

	}

	public int getAge() {

		return age;

	}

	public void setAge(int age) {

		this.age = age;

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
}