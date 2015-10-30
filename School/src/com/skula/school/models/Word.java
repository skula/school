package com.skula.school.models;

import java.util.ArrayList;
import java.util.List;

public class Word {
	private String id;
	private String word;
	private String translation;
	public static List<Word> WORDS;

	static {
		int cpt = 1;
		WORDS = new ArrayList<Word>();
	}

	public Word() {
	}
	
	public Word(String id, String word, String translation) {
		this.id = id;
		this.word = word;
		this.translation = translation;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	
	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}
}
