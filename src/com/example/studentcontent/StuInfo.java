package com.example.studentcontent;

public class StuInfo {
	private String ID;
	private String Name;
	private int s1;
	private int s2;
	private int s3;
	public static int NUM=0;
	public StuInfo(){
	}
	public StuInfo(String ID, String Name, int s1, int s2, int s3) {
		setInfo(ID, Name, s1, s2, s3);
		NUM++;
	}
	void setInfo(String ID, String Name, int s1, int s2, int s3) {
		this.ID=ID;
		this.Name=Name;
		this.s1=s1;
		this.s2=s2;
		this.s3=s3;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getS1() {
		return s1;
	}

	public void setS1(int s1) {
		this.s1 = s1;
	}

	public int getS2() {
		return s2;
	}

	public void setS2(int s2) {
		this.s2 = s2;
	}

	public int getS3() {
		return s3;
	}

	public void setS3(int s3) {
		this.s3 = s3;
	}
	public String showInfo(){
		return getID()+","+getName();
	}
}
