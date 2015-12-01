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
import com.skula.school.activities.WordActivity;
import com.skula.school.models.Word;
import com.skula.school.services.DatabaseService;

public class WordDialog extends Dialog implements OnClickListener {
	public DatabaseService dbs;
	public Button btnCancel;
	public Button btnSave;
	public Button btnDelete;
	private EditText word;
	private EditText translation;
	private Word w;
	private String categoryId;
	private boolean canDelete;
	private WordActivity wordActivity;

	public WordDialog(WordActivity parentActivity, DatabaseService dbs, String categoryId) {
		super(parentActivity);
		this.dbs = dbs;
		this.categoryId = categoryId;
		this.wordActivity = parentActivity;
	}
	
	public WordDialog(WordActivity parentActivity, DatabaseService dbs, Word w, boolean canDelete) {
		super(parentActivity);
		this.wordActivity = parentActivity;
		this.dbs = dbs;
		this.w =w;
		this.categoryId = null;
		this.canDelete = canDelete;
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
		btnDelete = (Button) findViewById(R.id.word_dial_btn_delete);
		btnDelete.setOnClickListener(this);
		if(!canDelete){
			btnDelete.setVisibility(View.GONE);
		}
		
		if(w==null){
			btnSave.setText("Ajouter");
		}else{
			btnSave.setText("Modifier");
			word.setText(w.getWord());
			translation.setText(w.getTranslation());
		}
	}

	@SuppressLint("NewApi")
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.word_dial_btn_cancel:
			dismiss();
			break;
		case R.id.word_dial_btn_save:
			String wo = word.getText().toString();
			String t = translation.getText().toString();
			if (!wo.isEmpty() && !t.isEmpty()) {
				if(w==null){
					dbs.insertWord(wo, t, categoryId);
				}else{
					dbs.updateWord(w.getId(), wo, t);
				}
				wordActivity.initUI();
				dismiss();
			}
			break;
		case R.id.word_dial_btn_delete:
			dbs.deleteWord(w.getId());
			wordActivity.initUI();
			dismiss();
			break;
		default:
			dismiss();
			break;
		}
	}
}