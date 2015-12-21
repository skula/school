package com.skula.school.services;

import java.util.List;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;

import com.skula.school.models.Morse;
import com.skula.school.models.MorseChar;

public class MorseDrawer {
	private final static int X0 = 20;
	private final static int X1 = 305;
	private final static int Y0 = 30;
	private final static int DOTS_SEP = 20;
	private final static int DOTS_SHORT_SIZE = 5;
	private final static int DOTS_LONG_WIDTH = 20;
	private final static int DOTS_LONG_HEIGHT = 8;

	private final static int Y_CHAR_SEP = 38;
	private final static int DOTS_COUNT = 6;
	private Paint paint;

	public void draw(Canvas c) {
		drawCharacters(c);
	}

	public MorseDrawer() {
		this.paint = new Paint();
	}

	private void drawCharacters(Canvas c) {
		paint.setTextSize(35f);
		paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));

		int y = Y0;
		List<MorseChar> list = Morse.CHARACTERS;
		int mid = list.size() / 2;
		for (int i = 0; i < list.size(); i++) {
			if (i == mid) {
				y = Y0;
			}

			if (i < mid) {
				drawChar(c, list.get(i), X0, y);
			} else {
				drawChar(c, list.get(i), X1, y);
			}
			y += Y_CHAR_SEP;
		}

	}

	private void drawChar(Canvas canvas, MorseChar c, int xd, int yd) {
		int x = xd;
		int y = yd;
		paint.setColor(Color.RED);
		canvas.drawText(c.getCharacter(), x, y, paint);
		x += 40;
		y -= 10;
		paint.setColor(Color.BLACK);
		for (int i : c.getPoints()) {
			if (i == Morse.SHORT) {
				canvas.drawCircle(x, y, DOTS_SHORT_SIZE, paint);
				x += DOTS_SHORT_SIZE + DOTS_SEP;
			} else {
				canvas.drawRect(new Rect(x - (DOTS_LONG_WIDTH) / 2, y - (DOTS_LONG_HEIGHT / 2), x + (DOTS_LONG_WIDTH)
						/ 2, y + DOTS_LONG_HEIGHT / 2), paint);
				x += DOTS_SHORT_SIZE + DOTS_SEP;
			}
		}
	}
}