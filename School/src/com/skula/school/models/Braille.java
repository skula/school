package com.skula.school.models;

import java.util.HashMap;
import java.util.Map;

public class Braille {

	public static Map<String, int[]> CHARACTERS;

	static {
		CHARACTERS = new HashMap<String, int[]>();
		CHARACTERS.put("A", new int[] { 1, 0, 0, 0, 0, 0 });// 1
		CHARACTERS.put("B", new int[] { 1, 1, 0, 0, 0, 0 }); // 1, 2
		CHARACTERS.put("C", new int[] { 1, 0, 0, 1, 0, 0 }); // 1, 4
		CHARACTERS.put("D", new int[] { 1, 0, 0, 1, 1, 0 }); // 1, 4,5
		CHARACTERS.put("E", new int[] { 1, 0, 0, 0, 1, 0 });// 1,5});
		CHARACTERS.put("F", new int[] { 1, 1, 0, 1, 0, 0 });// 1,2,4});
		CHARACTERS.put("G", new int[] { 1, 1, 0, 1, 1, 0 });// 1,2,4,5});
		CHARACTERS.put("H", new int[] { 1, 1, 0, 0, 1, 0 });// 1,2,5});
		CHARACTERS.put("I", new int[] { 0, 1, 0, 1, 0, 0 });// 2,4});
		CHARACTERS.put("J", new int[] { 0, 1, 0, 1, 1, 0 });// 2,4,5});
		CHARACTERS.put("K", new int[] { 1, 0, 1, 0, 0, 0 });// 1,3});
		CHARACTERS.put("L", new int[] { 1, 1, 1, 0, 0, 0 });// 1,2,3});
		CHARACTERS.put("M", new int[] { 1, 0, 1, 1, 0, 0 });// 1,3,4});
		CHARACTERS.put("N", new int[] { 1, 0, 1, 1, 1, 0 });// 1,3,4,5});
		CHARACTERS.put("O", new int[] { 1, 0, 1, 0, 1, 0 });// 1,3,5});
		CHARACTERS.put("P", new int[] { 1, 1, 1, 1, 0, 0 });// 1,2,3,4});
		CHARACTERS.put("Q", new int[] { 1, 1, 1, 1, 1, 0 });// 1,2,3,4,5});
		CHARACTERS.put("R", new int[] { 1, 1, 1, 0, 1, 0 });// 1,2,3,5});
		CHARACTERS.put("S", new int[] { 0, 1, 1, 1, 0, 0 });// 2,3,4});
		CHARACTERS.put("T", new int[] { 0, 1, 1, 1, 1, 0 });// 2,3,4,5});
		CHARACTERS.put("U", new int[] { 1, 0, 1, 0, 0, 1 });// 1,3,6});
		CHARACTERS.put("V", new int[] { 1, 1, 1, 0, 0, 1 });// 1,2,3,6});
		CHARACTERS.put("W", new int[] { 0, 1, 0, 1, 1, 1 });// 2,4,5,6});
		CHARACTERS.put("X", new int[] { 1, 0, 1, 1, 0, 1 });// 1,3,4,6});
		CHARACTERS.put("Y", new int[] { 1, 0, 1, 1, 1, 1 });// 1,3,4,5,6});
		CHARACTERS.put("Z", new int[] { 1, 0, 1, 0, 1, 1 });// 1,3,5,6});

		CHARACTERS.put("0", new int[] { 0, 1, 0, 1, 1, 0 });// 2,4,5});
		CHARACTERS.put("1", new int[] { 1, 0, 0, 0, 0, 0 });// 1
		CHARACTERS.put("2", new int[] { 1, 1, 0, 0, 0, 0 }); // 1, 2
		CHARACTERS.put("3", new int[] { 1, 0, 0, 1, 0, 0 }); // 1, 4
		CHARACTERS.put("4", new int[] { 1, 0, 0, 1, 1, 0 }); // 1, 4,5
		CHARACTERS.put("5", new int[] { 1, 0, 0, 0, 1, 0 });// 1,5});
		CHARACTERS.put("6", new int[] { 1, 1, 0, 1, 0, 0 });// 1,2,4});
		CHARACTERS.put("7", new int[] { 1, 1, 0, 1, 1, 0 });// 1,2,4,5});
		CHARACTERS.put("8", new int[] { 1, 1, 0, 0, 1, 0 });// 1,2,5});
		CHARACTERS.put("9", new int[] { 0, 1, 0, 1, 0, 0 });// 2,4});
		CHARACTERS.put("9", new int[] { 0, 1, 0, 1, 0, 0 });// 2,4});

		CHARACTERS.put("!", new int[] { 0, 1, 1, 0, 1, 0 });// 2,4});
		CHARACTERS.put("'", new int[] { 0, 0, 1, 0, 0, 0 });// 2,4});
		CHARACTERS.put(",", new int[] { 0, 1, 0, 0, 0, 0 });// 2,4});
		CHARACTERS.put("-", new int[] { 0, 0, 1, 0, 0, 1 });// 2,4});
		CHARACTERS.put(".", new int[] { 0, 1, 0, 0, 1, 1 });// 2,4});
		CHARACTERS.put("?", new int[] { 0, 1, 1, 0, 0, 1 });// 2,4});
	}
}