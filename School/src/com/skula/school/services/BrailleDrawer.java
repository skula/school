package com.skula.school.services;

import java.util.List;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import com.skula.school.models.Braille;
import com.skula.school.models.BrailleChar;

public class BrailleDrawer {
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

	public BrailleDrawer() {
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
		List<BrailleChar> list = Braille.CHARACTERS;

		int[] pts = null;
		for (BrailleChar bc : list) {
			if(cpt!=0 && cpt%7==0){
				y+=115;
				x = X0;
			}
			pts = bc.getPoints();
			for (int i = 0; i < DOTS_COUNT; i++) {
				if (pts[i] == 1) {
					paint.setColor(Color.BLACK);
				}else{
					paint.setColor(Color.LTGRAY);
				}
				
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
			paint.setColor(Color.RED);
			c.drawText(bc.getCharacter(), x-2, y+DOTS_SIZE*3+DOTS_SEP+40, paint);
			x += X_CHAR_SEP;
			cpt++;
		}
	}
}