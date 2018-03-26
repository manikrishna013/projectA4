package com.developers.projectA4.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="genres")
public class Genres implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String genreName;
	private Map<String,String> listOfLanguages = new HashMap<String,String>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	public Map<String, String> getListOfLanguages() {
		return listOfLanguages;
	}
	public void setListOfLanguages(Map<String, String> listOfLanguages) {
		this.listOfLanguages = listOfLanguages;
	}
	
	
	
}
