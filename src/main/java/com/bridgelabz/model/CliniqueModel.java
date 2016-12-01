package com.bridgelabz.model;

public class CliniqueModel {
private int mcliniqueId;
@Override
public String toString() {
	return "CliniqueModel [cliniqueId=" + mcliniqueId + ", cliniqueName=" + mcliniqueName + "]";
}
private String mcliniqueName;
public int getCliniqueId() {
	return mcliniqueId;
}
public void setCliniqueId(int cliniqueId) {
	this.mcliniqueId = cliniqueId;
}
public String getCliniqueName() {
	return mcliniqueName;
}
public void setCliniqueName(String cliniqueName) {
	this.mcliniqueName = cliniqueName;
}
}
