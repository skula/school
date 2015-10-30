package com.skula.school.activities.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.skula.school.R;
import com.skula.school.services.DatabaseService;

public class WordDialog extends Dialog implements OnClickListener {
	public DatabaseService dbs;
	public Button btnCancel;
	public Button btnSave;
	private EditText word;
	private EditText translation;

	public WordDialog(Activity parentActivity, DatabaseService dbs) {
		super(parentActivity);
		this.dbs = dbs;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.word_dial_layout);

		word = (EditText) findViewById(R.id.word_dial_word);
		translation = (EditText) findViewById(R.id.word_dial_translation);

		btnCancel = (Button) findViewById(R.id.word_dial_btn_cancel);
		btnCancel.setOnClickListener(this);
		btnSave = (Button) findViewById(R.id.word_dial_btn_save);
		btnSave.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.word_dial_btn_cancel:
			dismiss();
			break;
		case R.id.word_dial_btn_save:
			String w = word.getText().toString();
			String t = translation.getText().toString();
			if (!w.isEmpty() && !t.isEmpty()) {
				dbs.insertWordGer(w, t);
			}
			dismiss();
			break;
		default:
			dismiss();
			break;
		}
	}
}