package com.skula.school.services;

import java.util.Map;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.skula.school.models.Braille;

public class BrailleDrawer {
	private final static int X0 = 10;
	private final static int Y0 = 10;
	private final static int DOTS_SEP = 25;
	private final static int DOTS_SIZE = 10;
	private final static int CHAR_SEP = DOTS_SEP * 2 + 20;
	private final static int DOTS_COUNT = 6;
	private Paint paint;

	public void draw(Canvas c) {
		drawCharacters(c);
	}

	public BrailleDrawer() {
		this.paint = new Paint();
	}

	private void drawCharacters(Canvas c) {
		paint.setColor(Color.BLACK);
		paint.setTextSize(40f);
		int x = X0;
		int y = Y0;
		Map<String, int[]> map = Braille.CHARACTERS;
		int[] pts = null;
		for (String key : map.keySet()) {
			pts = map.get(key);
			for (int i = 0; i < DOTS_COUNT; i++) {
				if (pts[i] == 1) {
					switch (i) {
					case 0:
						c.drawCircle(x, y, DOTS_SIZE, paint);
						break;
					case 1:
						c.drawCircle(x, y + DOTS_SEP, DOTS_SIZE, paint);
						break;
					case 2:
						c.drawCircle(x, y + DOTS_SEP * 2, DOTS_SIZE, paint);
						break;
					case 3:
						c.drawCircle(x + DOTS_SEP, y, DOTS_SIZE, paint);
						break;
					case 4:
						c.drawCircle(x + DOTS_SEP, y + DOTS_SEP, DOTS_SIZE, paint);
						break;
					case 5:
						c.drawCircle(x + DOTS_SEP, y + DOTS_SEP * 2, DOTS_SIZE, paint);
						break;
					}
				}
			}
			c.drawText(key, x-2, y+DOTS_SIZE*3+DOTS_SEP+40, paint);
			x += CHAR_SEP;
		}
	}
}