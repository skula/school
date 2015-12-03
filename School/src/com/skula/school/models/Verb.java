package com.skula.school.models;

import java.util.List;

public class Verb {
	private String id;
	private String infinitive;
	private String present;
	private String preterite;
	private String perfect;
	private String translation;
	private String languageId;
	public static List<Verb> VERBS;

	public Verb() {
	}

	public Verb(String id, String infinitive, String present, String preterite, String perfect, String translation,
			String languageId) {
		this.id = id;
		this.infinitive = infinitive;
		this.present = present;
		this.preterite = preterite;
		this.perfect = perfect;
		this.translation = translation;
		this.languageId = languageId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInfinitive() {
		return infinitive;
	}

	public void setInfinitive(String infinitive) {
		this.infinitive = infinitive;
	}

	public String getPresent() {
		return present;
	}

	public void setPresent(String present) {
		this.present = present;
	}

	public String getPreterite() {
		return preterite;
	}

	public void setPreterite(String preterite) {
		this.preterite = preterite;
	}

	public String getPerfect() {
		return perfect;
	}

	public void setPerfect(String perfect) {
		this.perfect = perfect;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	public String getLanguage() {
		return languageId;
	}

	public void setLanguage(String languageId) {
		this.languageId = languageId;
	}
}
