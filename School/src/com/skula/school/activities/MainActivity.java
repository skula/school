package com.skula.school.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.skula.school.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_layout);

		Button btnVerben = (Button) findViewById(R.id.btn_verben);
		btnVerben.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), VerbActivity.class);
				startActivity(intent);
			}
		});
		
		Button btnWords = (Button) findViewById(R.id.btn_words);
		btnWords.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), WordActivity.class);
				startActivity(intent);
			}
		});
	}
}
