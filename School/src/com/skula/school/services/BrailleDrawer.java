package com.skula.school.services;

import java.util.Map;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.skula.school.models.Braille;

public class BrailleDrawer {
	private final static int DOTS_SEP = 10;
	private final static int DOTS_COUNT = 6;
	private Paint paint;

	public void draw(Canvas c) {
		drawCharacters(c);
	}

	public BrailleDrawer() {
		paint.setColor(Color.BLACK);
	}

	private void drawCharacters(Canvas c) {
		int x = 0;
		int y = 0;
		Map<String, int[]> map = Braille.CHARACTERS;
		int[] pts = null;
		for (String key : map.keySet()) {
			pts = map.get(key);
			for (int i = 0; i < DOTS_COUNT; i++) {
				if (pts[i] == 1) {
					switch (i) {
					case 0:
						c.drawCircle(x, y, 5, paint);
						break;
					case 1:
						c.drawCircle(x, y + DOTS_SEP, 5, paint);
						break;
					case 2:
						c.drawCircle(x, y + DOTS_SEP * 2, 5, paint);
						break;
					case 3:
						c.drawCircle(x + DOTS_SEP, y, 5, paint);
						break;
					case 4:
						c.drawCircle(x + DOTS_SEP, y + DOTS_SEP, 5, paint);
						break;
					case 5:
						c.drawCircle(x + DOTS_SEP, y + DOTS_SEP * 2, 5, paint);
						break;

					}
				}
			}
			c.drawText(key, x, y + 20, paint);
			x += 30;
		}
	}
}