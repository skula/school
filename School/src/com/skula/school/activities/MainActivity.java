package com.skula.school.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.skula.school.R;
import com.skula.school.services.DatabaseService;

public class MainActivity extends Activity {
	private DatabaseService db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_layout);

		this.db = new DatabaseService(this);
		// MOCK
		//db.bouchon();

		Button btnVerbsEng = (Button) findViewById(R.id.btn_verbs_eng);
		btnVerbsEng.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Bundle mBundle = new Bundle();
				mBundle.putString("languageid", db.getLanguageId("ENG"));
				Intent intent = new Intent(v.getContext(), VerbActivity.class);
				intent.putExtras(mBundle);
				startActivity(intent);
			}
		});

		/*Button btnVerbsGer = (Button) findViewById(R.id.btn_verbs_ger);
		btnVerbsGer.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Bundle mBundle = new Bundle();
				mBundle.putString("languageid", db.getLanguageId("GER"));
				Intent intent = new Intent(v.getContext(), VerbActivity.class);
				intent.putExtras(mBundle);
				startActivity(intent);
			}
		});

		Button btnWordsGer = (Button) findViewById(R.id.btn_words_ger);
		btnWordsGer.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Bundle mBundle = new Bundle();
				mBundle.putString("languageid", db.getLanguageId("GER"));
				Intent intent = new Intent(v.getContext(), CategoryActivity.class);
				intent.putExtras(mBundle);
				startActivity(intent);
			}
		});*/

		Button btnWordsEng = (Button) findViewById(R.id.btn_words_eng);
		btnWordsEng.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Bundle mBundle = new Bundle();
				mBundle.putString("languageid", db.getLanguageId("ENG"));
				Intent intent = new Intent(v.getContext(), CategoryActivity.class);
				intent.putExtras(mBundle);
				startActivity(intent);
			}
		});
	}
}
