package com.bridgelabz.model;

import java.util.ArrayList;

public class PatientsModel {
private String mMobileNo;
private ArrayList<String> mPatientsClinicId;
@Override
public String toString() {
	return "PatientsModel [mMobileNo=" + mMobileNo + ", mPatientsClinicId=" + mPatientsClinicId + ", mAge=" + mAge
			+ ", mName=" + mName + ", mId=" + mId + "]";
}
private int mAge;
private String mName;
private int mId;
public String getmMobileNo() {
	return mMobileNo;
}
public void setmMobileNo(String mMobileNo) {
	this.mMobileNo = mMobileNo;
}
public ArrayList<String> getmPatientsClinicId() {
	return mPatientsClinicId;
}
public void setmPatientsClinicId(ArrayList<String> mPatientsClinicId) {
	this.mPatientsClinicId = mPatientsClinicId;
}
public int getmAge() {
	return mAge;
}
public void setmAge(int patientAge) {
	this.mAge = patientAge;
}
public String getmName() {
	return mName;
}
public void setmName(String mName) {
	this.mName = mName;
}
public int getmId() {
	return mId;
}
public void setmId(int mId) {
	this.mId = mId;
}
}
