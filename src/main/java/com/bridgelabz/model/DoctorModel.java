package com.bridgelabz.model;

import java.util.ArrayList;

public class DoctorModel {

@Override
	public String toString() {
		return "DoctorModel [mDocName=" + mDocName + ", mId=" + mId + ", clinicId=" + mClinicIdArrayList + ", availability="
				+ mAvailabilityArrayList + ", mSpecialization=" + mSpecialization + ", mAvailability=" + mAvailability + "]";
	}
private String mDocName;
private int mId;
private ArrayList<String> mClinicIdArrayList;
private ArrayList<String> mAvailabilityArrayList;

public ArrayList<String> getAvailability() {
	return mAvailabilityArrayList;
}
public void setAvailability(ArrayList<String> availability) {
	this.mAvailabilityArrayList = availability;
}
public ArrayList<String> getClinicId() {
	return mClinicIdArrayList;
}
public void setClinicId(ArrayList<String> clinicId) {
	this.mClinicIdArrayList = clinicId;
}
private String mSpecialization;
private String mAvailability;
public String getmDocName() {
	return mDocName;
}
public void setmDocName(String mDocName) {
	this.mDocName = mDocName;
}
public int getmId() {
	return mId;
}
public void setmId(int mId) {
	this.mId = mId;
}

public String getmSpecialization() {
	return mSpecialization;
}
public void setmSpecialization(String mSpecialization) {
	this.mSpecialization = mSpecialization;
}
public String getmAvailability() {
	return mAvailability;
}
public void setmAvailability(String mAvailability) {
	this.mAvailability = mAvailability;
}
}
