package com.skula.school.models;

public class MorseChar {
	private String character;
	private int[] points;

	public MorseChar(String character, int[] points) {
		this.character = character;
		this.points = points;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public int[] getPoints() {
		return points;
	}

	public void setPoints(int[] points) {
		this.points = points;
	}
}
