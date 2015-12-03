package com.skula.school.models;

public class Word {
	private String id;
	private String article;
	private String word;
	private String translation;

	public Word() {
	}

	public Word(String id, String article, String word, String translation) {
		this.id = id;
		this.word = word;
		this.translation = translation;
		this.article = article;
	}

	public Word(String id, String word, String translation) {
		this.id = id;
		this.word = word;
		this.translation = translation;
		this.article = "";
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

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}
}
