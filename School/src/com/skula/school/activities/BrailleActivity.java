package com.skula.school.activities;

import android.app.Activity;
import android.os.Bundle;

import com.skula.school.activities.views.BrailleView;

public class BrailleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(new BrailleView(this));
	}
}