package com.skula.school.models;

import java.util.ArrayList;
import java.util.List;

public class Braille {

	public static List<BrailleChar> CHARACTERS;

	static {
		CHARACTERS = new ArrayList<BrailleChar>();
		CHARACTERS.add(new BrailleChar("A", new int[] { 1, 0, 0, 0, 0, 0 }));// 1
		CHARACTERS.add(new BrailleChar("B", new int[] { 1, 1, 0, 0, 0, 0 })); // 1, 2
		CHARACTERS.add(new BrailleChar("C", new int[] { 1, 0, 0, 1, 0, 0 })); // 1, 4
		CHARACTERS.add(new BrailleChar("D", new int[] { 1, 0, 0, 1, 1, 0 })); // 1, 4,5
		CHARACTERS.add(new BrailleChar("E", new int[] { 1, 0, 0, 0, 1, 0 }));// 1,5}));
		CHARACTERS.add(new BrailleChar("F", new int[] { 1, 1, 0, 1, 0, 0 }));// 1,2,4}));
		CHARACTERS.add(new BrailleChar("G", new int[] { 1, 1, 0, 1, 1, 0 }));// 1,2,4,5}));
		CHARACTERS.add(new BrailleChar("H", new int[] { 1, 1, 0, 0, 1, 0 }));// 1,2,5}));
		CHARACTERS.add(new BrailleChar("I", new int[] { 0, 1, 0, 1, 0, 0 }));// 2,4}));
		CHARACTERS.add(new BrailleChar("J", new int[] { 0, 1, 0, 1, 1, 0 }));// 2,4,5}));
		CHARACTERS.add(new BrailleChar("K", new int[] { 1, 0, 1, 0, 0, 0 }));// 1,3}));
		CHARACTERS.add(new BrailleChar("L", new int[] { 1, 1, 1, 0, 0, 0 }));// 1,2,3}));
		CHARACTERS.add(new BrailleChar("M", new int[] { 1, 0, 1, 1, 0, 0 }));// 1,3,4}));
		CHARACTERS.add(new BrailleChar("N", new int[] { 1, 0, 1, 1, 1, 0 }));// 1,3,4,5}));
		CHARACTERS.add(new BrailleChar("O", new int[] { 1, 0, 1, 0, 1, 0 }));// 1,3,5}));
		CHARACTERS.add(new BrailleChar("P", new int[] { 1, 1, 1, 1, 0, 0 }));// 1,2,3,4}));
		CHARACTERS.add(new BrailleChar("Q", new int[] { 1, 1, 1, 1, 1, 0 }));// 1,2,3,4,5}));
		CHARACTERS.add(new BrailleChar("R", new int[] { 1, 1, 1, 0, 1, 0 }));// 1,2,3,5}));
		CHARACTERS.add(new BrailleChar("S", new int[] { 0, 1, 1, 1, 0, 0 }));// 2,3,4}));
		CHARACTERS.add(new BrailleChar("T", new int[] { 0, 1, 1, 1, 1, 0 }));// 2,3,4,5}));
		CHARACTERS.add(new BrailleChar("U", new int[] { 1, 0, 1, 0, 0, 1 }));// 1,3,6}));
		CHARACTERS.add(new BrailleChar("V", new int[] { 1, 1, 1, 0, 0, 1 }));// 1,2,3,6}));
		CHARACTERS.add(new BrailleChar("W", new int[] { 0, 1, 0, 1, 1, 1 }));// 2,4,5,6}));
		CHARACTERS.add(new BrailleChar("X", new int[] { 1, 0, 1, 1, 0, 1 }));// 1,3,4,6}));
		CHARACTERS.add(new BrailleChar("Y", new int[] { 1, 0, 1, 1, 1, 1 }));// 1,3,4,5,6}));
		CHARACTERS.add(new BrailleChar("Z", new int[] { 1, 0, 1, 0, 1, 1 }));// 1,3,5,6}));

		CHARACTERS.add(new BrailleChar("0", new int[] { 0, 1, 0, 1, 1, 0 }));// 2,4,5}));
		CHARACTERS.add(new BrailleChar("1", new int[] { 1, 0, 0, 0, 0, 0 }));// 1
		CHARACTERS.add(new BrailleChar("2", new int[] { 1, 1, 0, 0, 0, 0 })); // 1, 2
		CHARACTERS.add(new BrailleChar("3", new int[] { 1, 0, 0, 1, 0, 0 })); // 1, 4
		CHARACTERS.add(new BrailleChar("4", new int[] { 1, 0, 0, 1, 1, 0 })); // 1, 4,5
		CHARACTERS.add(new BrailleChar("5", new int[] { 1, 0, 0, 0, 1, 0 }));// 1,5}));
		CHARACTERS.add(new BrailleChar("6", new int[] { 1, 1, 0, 1, 0, 0 }));// 1,2,4}));
		CHARACTERS.add(new BrailleChar("7", new int[] { 1, 1, 0, 1, 1, 0 }));// 1,2,4,5}));
		CHARACTERS.add(new BrailleChar("8", new int[] { 1, 1, 0, 0, 1, 0 }));// 1,2,5}));
		CHARACTERS.add(new BrailleChar("9", new int[] { 0, 1, 0, 1, 0, 0 }));// 2,4}));

		CHARACTERS.add(new BrailleChar("!", new int[] { 0, 1, 1, 0, 1, 0 }));// 2,4}));
		CHARACTERS.add(new BrailleChar("'", new int[] { 0, 0, 1, 0, 0, 0 }));// 2,4}));
		CHARACTERS.add(new BrailleChar(",", new int[] { 0, 1, 0, 0, 0, 0 }));// 2,4}));
		CHARACTERS.add(new BrailleChar("-", new int[] { 0, 0, 1, 0, 0, 1 }));// 2,4}));
		CHARACTERS.add(new BrailleChar(".", new int[] { 0, 1, 0, 0, 1, 1 }));// 2,4}));
		CHARACTERS.add(new BrailleChar("?", new int[] { 0, 1, 1, 0, 0, 1 }));// 2,4}));
	}
}