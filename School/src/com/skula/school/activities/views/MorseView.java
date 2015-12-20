package com.skula.school.activities.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import com.skula.school.services.MorseDrawer;

public class MorseView extends View {
	private Paint paint;
	private Resources res;
	private MorseDrawer drawer;

	private String msg;

	public MorseView(Context context) {
		super(context);
		this.drawer = new MorseDrawer();
		this.paint = new Paint();
		this.msg = "";
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int x = (int) event.getX();
		int y = (int) event.getY();

		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			break;
		case MotionEvent.ACTION_MOVE:
			break;
		case MotionEvent.ACTION_UP:
			break;
		}
		invalidate();
		return true;
	}

	@Override
	public void draw(Canvas canvas) {
		drawer.draw(canvas);

	}
}