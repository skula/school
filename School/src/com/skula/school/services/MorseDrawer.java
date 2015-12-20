package com.skula.school.services;

import java.util.List;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import com.skula.school.models.Morse;
import com.skula.school.models.MorseChar;

public class MorseDrawer {
	private final static int X0 = 20;
	private final static int Y0 = 20;
	private final static int DOTS_SEP = 20;
	private final static int DOTS_SIZE = 8;
	private final static int X_CHAR_SEP = DOTS_SEP * 2 + 30;
	private final static int DOTS_COUNT = 6;
	private Paint paint;

	public void draw(Canvas c) {
		drawCharacters(c);
	}

	public MorseDrawer() {
		this.paint = new Paint();
	}

	private void drawCharacters(Canvas c) {
		paint.setColor(Color.BLACK);
		paint.setTextSize(35f);
		paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
		int cptLines = 0;
		int cpt = 0;
		int x = X0;
		int y = Y0;
		List<MorseChar> list = Morse.CHARACTERS;

	}
}