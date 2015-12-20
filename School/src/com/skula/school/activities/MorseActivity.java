package com.skula.school.activities;

import android.app.Activity;
import android.os.Bundle;

import com.skula.school.activities.views.MorseView;

public class MorseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(new MorseView(this));
	}
}