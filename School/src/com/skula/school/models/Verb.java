package com.skula.school.models;

import java.util.ArrayList;
import java.util.List;

public class Verb {
	private String id;
	private String infinitive;
	private String present;
	private String preterite;
	private String perfect;
	private String translation;
	public static List<Verb> VERBS;

	static {
		int cpt = 1;
		VERBS = new ArrayList<Verb>();
		VERBS.add(new Verb(String.valueOf(cpt++), "anbieten", "bietet an", "bot an", "hat angeboten", "offrir, proposer"));
		VERBS.add(new Verb(String.valueOf(cpt++), "anfangen", "fängt an", "fing an", "hat angefangen", "commencer"));
		VERBS.add(new Verb(String.valueOf(cpt++), "anziehen", "zieht an", "zog an", "hat angezogen", "mettre (vêtement)"));
		VERBS.add(new Verb(String.valueOf(cpt++), "aufgeben", "gibt auf", "gab auf", "hat aufgegeben", "abandonner"));
		VERBS.add(new Verb(String.valueOf(cpt++), "ausblasen", "bläst aus", "blies aus", "hat ausgeblasen", "souffler (bougie)"));
		VERBS.add(new Verb(String.valueOf(cpt++), "ausgeben", "gibt aus", "gab aus", "hat ausgegeben", "dépenser (argent)"));
		VERBS.add(new Verb(String.valueOf(cpt++), "aussehen", "sieht aus", "sah aus", "hat ausgesehen", "avoir l'air"));
		VERBS.add(new Verb(String.valueOf(cpt++), "ausziehen", "zieht aus", "zog aus", "hat ausgezogen", "enlever (vêtement)"));
		VERBS.add(new Verb(String.valueOf(cpt++), "ausziehen", "zieht aus", "zog aus", "ist ausgezogen", "déménager"));
		VERBS.add(new Verb(String.valueOf(cpt++), "backen", "bäckt", "backte / buk", "hat gebacken", "faire cuire au four(pâtisserie)"));
	}

	public Verb() {
	}
	
	public Verb(String id, String infinitive, String present, String preterite, String perfect, String translation) {
		this.id = id;
		this.infinitive = infinitive;
		this.present = present;
		this.preterite = preterite;
		this.perfect = perfect;
		this.translation = translation;
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
}
