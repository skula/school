package com.skula.school.models;

import java.util.ArrayList;
import java.util.List;

public class Morse {
	public static final int SHORT = 0;
	public static final int LONG = 1;
	public static List<MorseChar> CHARACTERS;

	static {
		CHARACTERS = new ArrayList<MorseChar>();
		CHARACTERS.add(new MorseChar("A", new int[] { SHORT, LONG }));// 1
		CHARACTERS.add(new MorseChar("B", new int[] { LONG, SHORT, SHORT, SHORT })); // 1, 2
		CHARACTERS.add(new MorseChar("C", new int[] { LONG, SHORT, LONG, SHORT })); // 1, 4
		CHARACTERS.add(new MorseChar("D", new int[] { 1, 0, 0, 1, 1, 0 })); // 1, 4,5
		CHARACTERS.add(new MorseChar("E", new int[] { 1, 0, 0, 0, 1, 0 }));// 1,5}));
		CHARACTERS.add(new MorseChar("F", new int[] { 1, 1, 0, 1, 0, 0 }));// 1,2,4}));
		CHARACTERS.add(new MorseChar("G", new int[] { 1, 1, 0, 1, 1, 0 }));// 1,2,4,5}));
		CHARACTERS.add(new MorseChar("H", new int[] { 1, 1, 0, 0, 1, 0 }));// 1,2,5}));
		CHARACTERS.add(new MorseChar("I", new int[] { 0, 1, 0, 1, 0, 0 }));// 2,4}));
		CHARACTERS.add(new MorseChar("J", new int[] { 0, 1, 0, 1, 1, 0 }));// 2,4,5}));
		CHARACTERS.add(new MorseChar("K", new int[] { 1, 0, 1, 0, 0, 0 }));// 1,3}));
		CHARACTERS.add(new MorseChar("L", new int[] { 1, 1, 1, 0, 0, 0 }));// 1,2,3}));
		CHARACTERS.add(new MorseChar("M", new int[] { 1, 0, 1, 1, 0, 0 }));// 1,3,4}));
		CHARACTERS.add(new MorseChar("N", new int[] { 1, 0, 1, 1, 1, 0 }));// 1,3,4,5}));
		CHARACTERS.add(new MorseChar("O", new int[] { 1, 0, 1, 0, 1, 0 }));// 1,3,5}));
		CHARACTERS.add(new MorseChar("P", new int[] { 1, 1, 1, 1, 0, 0 }));// 1,2,3,4}));
		CHARACTERS.add(new MorseChar("Q", new int[] { 1, 1, 1, 1, 1, 0 }));// 1,2,3,4,5}));
		CHARACTERS.add(new MorseChar("R", new int[] { 1, 1, 1, 0, 1, 0 }));// 1,2,3,5}));
		CHARACTERS.add(new MorseChar("S", new int[] { 0, 1, 1, 1, 0, 0 }));// 2,3,4}));
		CHARACTERS.add(new MorseChar("T", new int[] { 0, 1, 1, 1, 1, 0 }));// 2,3,4,5}));
		CHARACTERS.add(new MorseChar("U", new int[] { 1, 0, 1, 0, 0, 1 }));// 1,3,6}));
		CHARACTERS.add(new MorseChar("V", new int[] { 1, 1, 1, 0, 0, 1 }));// 1,2,3,6}));
		CHARACTERS.add(new MorseChar("W", new int[] { 0, 1, 0, 1, 1, 1 }));// 2,4,5,6}));
		CHARACTERS.add(new MorseChar("X", new int[] { 1, 0, 1, 1, 0, 1 }));// 1,3,4,6}));
		CHARACTERS.add(new MorseChar("Y", new int[] { 1, 0, 1, 1, 1, 1 }));// 1,3,4,5,6}));
		CHARACTERS.add(new MorseChar("Z", new int[] { 1, 0, 1, 0, 1, 1 }));// 1,3,5,6}));

		CHARACTERS.add(new MorseChar("0", new int[] { 0, 1, 0, 1, 1, 0 }));// 2,4,5}));
		CHARACTERS.add(new MorseChar("1", new int[] { 1, 0, 0, 0, 0, 0 }));// 1
		CHARACTERS.add(new MorseChar("2", new int[] { 1, 1, 0, 0, 0, 0 })); // 1, 2
		CHARACTERS.add(new MorseChar("3", new int[] { 1, 0, 0, 1, 0, 0 })); // 1, 4
		CHARACTERS.add(new MorseChar("4", new int[] { 1, 0, 0, 1, 1, 0 })); // 1, 4,5
		CHARACTERS.add(new MorseChar("5", new int[] { 1, 0, 0, 0, 1, 0 }));// 1,5}));
		CHARACTERS.add(new MorseChar("6", new int[] { 1, 1, 0, 1, 0, 0 }));// 1,2,4}));
		CHARACTERS.add(new MorseChar("7", new int[] { 1, 1, 0, 1, 1, 0 }));// 1,2,4,5}));
		CHARACTERS.add(new MorseChar("8", new int[] { 1, 1, 0, 0, 1, 0 }));// 1,2,5}));
		CHARACTERS.add(new MorseChar("9", new int[] { 0, 1, 0, 1, 0, 0 }));// 2,4}));
	}
}