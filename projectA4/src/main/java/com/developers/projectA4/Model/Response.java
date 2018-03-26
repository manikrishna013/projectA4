package com.developers.projectA4.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Response<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<T> data;
	private String message;
	private boolean success;
	private int status;
	private String type;
	
	private Iterable<Country> countries;
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public void setData(T data) {
		List<T> tempList = new ArrayList<T>();
		tempList.add(data);
		this.data = tempList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	public void setData(Iterable<Country> countries) {		
		this.countries = countries;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}