package com.vir.model;

public class Student {




private Integer StudentID;

private String SName;

private String FName;

private String UID;

private int Age;


private String username;

private String pass;






public Student(String sName, String fName, String uID, int age, String username, String pass) {
	super();
	SName = sName;
	FName = fName;
	UID = uID;
	Age = age;
	this.username = username;
	this.pass = pass;
}







public Integer getStudentID() {
	return StudentID;
}







public void setStudentID(Integer studentID) {
	StudentID = studentID;
}







public String getSName() {

	return SName;

}



public void setSName(String sName) {

	SName = sName;

}



public String getFName() {

	return FName;

}



public void setFName(String fName) {

	FName = fName;

}



public String getUID() {

	return UID;

}



public void setUID(String uID) {

	UID = uID;

}



public int getAge() {

	return Age;

}



public void setAge(int age) {

	Age = age;

}



public Student() {
	super();
	// TODO Auto-generated constructor stub
}



public String getUsername() {

	return username;

}



public void setUsername(String username) {

	this.username = username;

}



public String getPass() {

	return pass;

}



public void setPass(String pass) {

	this.pass = pass;

}



@Override
public String toString() {
	return "Student [StudentID=" + StudentID + ", SName=" + SName + ", FName=" + FName + ", UID=" + UID + ", Age=" + Age
			+ ", username=" + username + ", pass=" + pass + "]";
}






}
