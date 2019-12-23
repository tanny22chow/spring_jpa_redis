package com.springPrac.springredisdemo.AppException.GenericExceptionModel;

import java.util.Date;

public class ExceptionModel {
	private Date timpstamp;
	private String messege;
	public ExceptionModel(Date timpstamp, String messege) {
		this.timpstamp = timpstamp;
		this.messege = messege;
	}
	public Date getTimpstamp() {
		return timpstamp;
	}
	public String getMessege() {
		return messege;
	}
	
}
