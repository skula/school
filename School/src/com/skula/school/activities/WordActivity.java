package com.skula.school.activities;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.skula.school.R;
import com.skula.school.activities.adapters.WordAdapter;
import com.skula.school.activities.dialogs.WordDialog;
import com.skula.school.models.Word;
import com.skula.school.services.DatabaseService;

public class WordActivity extends Activity {
	public static final int DISPLAY_LEARN = 0;
	public static final int DISPLAY_CHECK = 1;
	private TextView id;
	private TextView translation;
	private TextView word;
	private TextView wCount;

	private Menu menu;

	private ListView wordList;

	private DatabaseService dbs;
	private List<Integer> ids;
	private String categoryId;

	private boolean displayed;
	private int wordsCount;
	private int wordsPassCount;

	private int typeUI;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.word_layout);

		this.categoryId = getIntent().getExtras().getString("categoryid");

		this.dbs = new DatabaseService(this);

		this.wordList = (ListView) findViewById(R.id.word_list);
		this.id = (TextView) findViewById(R.id.wId);
		this.id.setVisibility(View.GONE);
		this.translation = (TextView) findViewById(R.id.wTranslation);
		this.word = (TextView) findViewById(R.id.wWord);
		this.wCount = (TextView) findViewById(R.id.wcount);

		this.typeUI = DISPLAY_LEARN;
		initUI();
	}

	public void initUI() {
		if (typeUI == DISPLAY_CHECK) {
			if(menu != null){
				setMenuItemTitle(R.id.typeUI, "Réviser");
				hideMenuItem(R.id.add);
			}
			wordList.setVisibility(View.GONE);
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
		} else {
			ids = null;
			
			if(menu != null){
				setMenuItemTitle(R.id.typeUI, "Reciter");
				showMenuItem(R.id.add);
			}
		
			id.setVisibility(View.GONE);
			translation.setVisibility(View.GONE);
			word.setVisibility(View.GONE);
			wordList.setVisibility(View.VISIBLE);

			List<Word> list = dbs.getWords(categoryId);
			list.size();
			Word itemArray[] = (Word[]) list.toArray(new Word[list.size()]);
			WordAdapter adapter = new WordAdapter(this, R.layout.word_item_layout, itemArray);
			wordList.setAdapter(adapter);
			
			final WordActivity wa  = this;
			wordList.setOnItemLongClickListener(new OnItemLongClickListener() {
				@Override
				public boolean onItemLongClick(AdapterView<?> a, View v, int position, long id) {
					Word item = (Word) wordList.getItemAtPosition(position);
					WordActivity wa = getActivity();
					WordDialog ad = new WordDialog(wa, dbs, item, true);
					ad.show();
					return true;
				}
			});
		}
	}
	
	public WordActivity getActivity(){
		return this;
	}

	private void nextWord() {
		if (ids == null || ids.size() == 0) {
			this.ids = dbs.getWordsIds(categoryId);
			wordsCount = ids.size();
			wordsPassCount = 0;
			Collections.shuffle(ids);
		}

		if (ids.size() > 0) {
			Word w = null;
			w = dbs.getWord(String.valueOf(ids.remove(0)));
			id.setText(w.getId());
			id.setVisibility(View.GONE);

			Random r = new Random();
			if (r.nextInt(10) % 2 == 0) {
				translation.setText(w.getTranslation());
				word.setText(w.getWord());
			} else {
				translation.setText(w.getWord());
				word.setText(w.getTranslation());
			}
			word.setVisibility(View.VISIBLE);
			translation.setVisibility(View.GONE);

			wordsPassCount++;
			wCount.setText(wordsPassCount + "/" + wordsCount);
		}
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

	private void hideMenuItem(int itemId) {
		menu.findItem(itemId).setVisible(false);
	}

	private void showMenuItem(int itemId) {
		menu.findItem(itemId).setVisible(true);
	}

	private void setMenuItemTitle(int itemId, String title) {
		menu.findItem(itemId).setTitle(title);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		this.menu = menu;
		getMenuInflater().inflate(R.menu.words, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		WordDialog ad;
		switch (item.getItemId()) {
		case R.id.typeUI:
			typeUI= typeUI==DISPLAY_LEARN?DISPLAY_CHECK:DISPLAY_LEARN;
			initUI();
			return true;
		case R.id.add:
			ad = new WordDialog(this, dbs, categoryId);
			ad.show();
			return true;
		case R.id.modify:
			ad = new WordDialog(this, dbs,
					dbs.getWord(id.getText().toString()), false);
			ad.show();
			return true;
		case R.id.remove:
			dbs.deleteWord(id.getText().toString());
			this.ids = null;
			nextWord();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
