package com.vir.model;

public class Fees {



	private String StudentID;

	private String BatchID;

	private double FeesPaid;

	private double FeesDue;

	public Fees(String studentID, String batchID, double feesPaid, double feesDue) {

		super();

		StudentID = studentID;

		BatchID = batchID;

		FeesPaid = feesPaid;

		FeesDue = feesDue;

	}

	public String getStudentID() {

		return StudentID;

	}

	public void setStudentID(String studentID) {

		StudentID = studentID;

	}

	public String getBatchID() {

		return BatchID;

	}

	public void setBatchID(String batchID) {

		BatchID = batchID;

	}

	public double getFeesPaid() {

		return FeesPaid;

	}

	public void setFeesPaid(double feesPaid) {

		FeesPaid = feesPaid;

	}

	public double getFeesDue() {

		return FeesDue;

	}

	public void setFeesDue(double feesDue) {

		FeesDue = feesDue;

	}

	

	

}