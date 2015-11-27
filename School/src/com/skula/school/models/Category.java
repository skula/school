package com.skula.school.models;

import java.util.ArrayList;
import java.util.List;

public class Category {
	private String id;
	private String label;
	private String language;

	public Category() {
	}
	
	public Category(String id, String label, String language) {
		this.id = id;
		this.label = label;
		this.language = language;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}
