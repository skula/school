package com.skula.school.activities.dialogs;

import android.annotation.SuppressLint;
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

public class VerbDialog extends Dialog implements OnClickListener {
	public DatabaseService dbs;
	public Button btnCancel;
	public Button btnSave;
	private EditText infinitive;
	private EditText present;
	private EditText preterite;
	private EditText perfect;
	private EditText translation;

	public VerbDialog(Activity parentActivity, DatabaseService dbs) {
		super(parentActivity);
		this.dbs = dbs;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.verb_dial_layout);

		infinitive = (EditText) findViewById(R.id.verb_dial_infinitive);
		present = (EditText) findViewById(R.id.verb_dial_present);
		preterite = (EditText) findViewById(R.id.verb_dial_preterite);
		perfect = (EditText) findViewById(R.id.verb_dial_perfect);
		translation = (EditText) findViewById(R.id.verb_dial_translation);

		btnCancel = (Button) findViewById(R.id.verb_dial_btn_cancel);
		btnCancel.setOnClickListener(this);
		btnSave = (Button) findViewById(R.id.verb_dial_btn_save);
		btnSave.setOnClickListener(this);
	}

	@SuppressLint("NewApi")
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.verb_dial_btn_cancel:
			dismiss();
			break;
		case R.id.verb_dial_btn_save:
			String i = infinitive.getText().toString();
			String pres = present.getText().toString();
			String pret = preterite.getText().toString();
			String perf = perfect.getText().toString();
			String t = translation.getText().toString();
			if (!i.isEmpty() && !pres.isEmpty() && !pret.isEmpty() && !perf.isEmpty() && !t.isEmpty()) {
				dbs.insertVerbGer(i, pres, pret, perf, t);
			}
			dismiss();
			break;
		default:
			dismiss();
			break;
		}
	}
}