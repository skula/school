package com.skula.school.activities;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.skula.school.R;
import com.skula.school.activities.dialogs.WordDialog;
import com.skula.school.models.Word;
import com.skula.school.services.DatabaseService;

public class WordActivity extends Activity {
	private TextView id;
	private TextView translation;
	private TextView word;

	private DatabaseService dbs;
	private List<Integer> ids;

	private boolean displayed;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.word_layout);

		this.id = (TextView) findViewById(R.id.wId);
		id.setVisibility(View.GONE);
		this.translation = (TextView) findViewById(R.id.wTranslation);
		this.word = (TextView) findViewById(R.id.wWord);

		this.dbs = new DatabaseService(this);
		//this.dbs.bouchon();

		nextWord();
		this.displayed = false;

		LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout);
		layout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (isDisplayed()) {
					nextWord();
					setDisplayed(false);
				} else {
					displayTranslation();
					setDisplayed(true);
				}
			}
		});
	}

	private void nextWord() {
		if (ids == null || ids.size() == 0) {
			this.ids = dbs.getWordsGerIds();
			Collections.shuffle(ids);
		}
		Word w = null;
		try {
			w = dbs.getWordGer(String.valueOf(ids.remove(0)));
		} catch (Exception e) {
			e.getMessage();
		}
		id.setText(w.getId());
		id.setVisibility(View.GONE);
		
		Random r = new Random();
		if(r.nextInt(10)%2 == 0){
			translation.setText(w.getTranslation());
			word.setText(w.getWord());
		}else{
			translation.setText(w.getWord());
			word.setText(w.getTranslation());
		}
		word.setVisibility(View.VISIBLE);
		translation.setVisibility(View.GONE);
	}

	private void displayTranslation() {
		word.setVisibility(View.VISIBLE);
		translation.setVisibility(View.VISIBLE);
	}

	public boolean isDisplayed() {
		return displayed;
	}

	public void setDisplayed(boolean displayed) {
		this.displayed = displayed;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.verben, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		WordDialog ad;
		switch (item.getItemId()) {
		case R.id.add:
			ad = new WordDialog(this, dbs);
			ad.show();
			return true;
		case R.id.modify:
			ad = new WordDialog(this, dbs, dbs.getWordGer(id.getText().toString()));
			ad.show();
			return true;
		case R.id.remove:
			dbs.deleteWordGer(id.getText().toString());
			this.ids = null;
			nextWord();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
