package com.skula.school.models;

import java.util.ArrayList;
import java.util.List;

public class Morse {
	public static final int SHORT = 0;
	public static final int LONG = 1;
	public static List<MorseChar> CHARACTERS;

	static {
		CHARACTERS = new ArrayList<MorseChar>();
		CHARACTERS.add(new MorseChar("A", new int[] { SHORT, LONG }));
		CHARACTERS.add(new MorseChar("B", new int[] { LONG, SHORT, SHORT, SHORT }));
		CHARACTERS.add(new MorseChar("C", new int[] { LONG, SHORT, LONG, SHORT }));
		CHARACTERS.add(new MorseChar("D", new int[] { LONG, SHORT, SHORT }));
		CHARACTERS.add(new MorseChar("E", new int[] { SHORT }));
		CHARACTERS.add(new MorseChar("F", new int[] { SHORT, SHORT, LONG, SHORT }));
		CHARACTERS.add(new MorseChar("G", new int[] { LONG, LONG, SHORT }));
		CHARACTERS.add(new MorseChar("H", new int[] { SHORT, SHORT, SHORT, SHORT }));
		CHARACTERS.add(new MorseChar("I", new int[] { SHORT, SHORT }));
		CHARACTERS.add(new MorseChar("J", new int[] { SHORT, LONG, LONG, LONG }));
		CHARACTERS.add(new MorseChar("K", new int[] { LONG, SHORT, LONG }));
		CHARACTERS.add(new MorseChar("L", new int[] { SHORT, LONG, SHORT, SHORT }));
		CHARACTERS.add(new MorseChar("M", new int[] { LONG, LONG }));
		CHARACTERS.add(new MorseChar("N", new int[] { LONG, SHORT }));
		CHARACTERS.add(new MorseChar("O", new int[] { LONG, LONG, LONG }));
		CHARACTERS.add(new MorseChar("P", new int[] { SHORT, LONG, LONG, SHORT }));
		CHARACTERS.add(new MorseChar("Q", new int[] { LONG, LONG, SHORT, LONG }));
		CHARACTERS.add(new MorseChar("R", new int[] { SHORT, LONG, SHORT }));
		CHARACTERS.add(new MorseChar("S", new int[] { SHORT, SHORT, SHORT }));
		CHARACTERS.add(new MorseChar("T", new int[] { LONG }));
		CHARACTERS.add(new MorseChar("U", new int[] { SHORT, SHORT, LONG }));
		CHARACTERS.add(new MorseChar("V", new int[] { SHORT, SHORT, SHORT, LONG }));
		CHARACTERS.add(new MorseChar("W", new int[] { SHORT, LONG, LONG }));
		CHARACTERS.add(new MorseChar("X", new int[] { LONG, SHORT, SHORT, LONG }));
		CHARACTERS.add(new MorseChar("Y", new int[] { LONG, SHORT, LONG, LONG }));
		CHARACTERS.add(new MorseChar("Z", new int[] { LONG, LONG, SHORT, SHORT }));

		CHARACTERS.add(new MorseChar("0", new int[] { LONG, LONG, LONG, LONG, LONG }));
		CHARACTERS.add(new MorseChar("1", new int[] { SHORT, LONG, LONG, LONG, LONG }));
		CHARACTERS.add(new MorseChar("2", new int[] { SHORT, SHORT, LONG, LONG, LONG }));
		CHARACTERS.add(new MorseChar("3", new int[] { SHORT, SHORT, SHORT, LONG, LONG }));
		CHARACTERS.add(new MorseChar("4", new int[] { SHORT, SHORT, SHORT, SHORT, LONG }));
		CHARACTERS.add(new MorseChar("5", new int[] { SHORT, SHORT, SHORT, SHORT, SHORT }));
		CHARACTERS.add(new MorseChar("6", new int[] { LONG, SHORT, SHORT, SHORT, SHORT }));
		CHARACTERS.add(new MorseChar("7", new int[] { LONG, LONG, SHORT, SHORT, SHORT }));
		CHARACTERS.add(new MorseChar("8", new int[] { LONG, LONG, LONG, SHORT, SHORT }));
		CHARACTERS.add(new MorseChar("9", new int[] { LONG, LONG, LONG, LONG, SHORT }));
	}
}