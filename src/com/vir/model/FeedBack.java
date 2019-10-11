package com.vir.model;

public class FeedBack {



	private String TrainerID;

	private String BatchID;

	private String feedBack;

	public FeedBack(String trainerID, String batchID, String feedBack) {

		super();

		TrainerID = trainerID;

		BatchID = batchID;

		this.feedBack = feedBack;

	}

	public String getTrainerID() {

		return TrainerID;

	}

	public void setTrainerID(String trainerID) {

		TrainerID = trainerID;

	}

	public String getBatchID() {

		return BatchID;

	}

	public void setBatchID(String batchID) {

		BatchID = batchID;

	}

	public String getFeedBack() {

		return feedBack;

	}

	public void setFeedBack(String feedBack) {

		this.feedBack = feedBack;

	}

	

	

}