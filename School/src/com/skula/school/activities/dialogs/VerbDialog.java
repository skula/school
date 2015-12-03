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
import com.skula.school.models.Verb;
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
	private Verb verb;
	private String languageId;

	public VerbDialog(Activity parentActivity, DatabaseService dbs, String languageId) {
		super(parentActivity);
		this.dbs = dbs;
		this.verb = null;
		this.languageId = languageId;
	}
	
	public VerbDialog(Activity parentActivity, DatabaseService dbs, Verb verb) {
		super(parentActivity);
		this.dbs = dbs;
		this.verb = verb;
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
		
		if(verb == null){
			btnSave.setText("Ajouter");
		}else{
			btnSave.setText("Modifier");
			infinitive.setText(verb.getInfinitive());
			present.setText(verb.getPresent());
			preterite.setText(verb.getPreterite());
			perfect.setText(verb.getPerfect());
			translation.setText(verb.getTranslation());
		}
	}

	@SuppressLint("NewApi")
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.verb_dial_btn_cancel:
			dismiss();
			break;
		case R.id.verb_dial_btn_save:
			String inf = infinitive.getText().toString();
			String pres = present.getText().toString();
			String pret = preterite.getText().toString();
			String perf = perfect.getText().toString();
			String trans = translation.getText().toString();
			if (!inf.isEmpty() && !pres.isEmpty() && !pret.isEmpty() && !perf.isEmpty() && !trans.isEmpty()) {
				if(verb == null){
					dbs.insertVerb(inf, pres, pret, perf, trans, languageId);
				}else{
					dbs.updateVerb(verb.getId(), inf, pres, pret, perf, trans);
				}
			}
			dismiss();
			break;
		default:
			dismiss();
			break;
		}
	}
}