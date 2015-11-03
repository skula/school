package com.skula.school.activities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Collections;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.skula.school.R;
import com.skula.school.activities.dialogs.VerbDialog;
import com.skula.school.models.Verb;
import com.skula.school.services.DatabaseService;
import com.skula.school.utils.FileCreator;

public class VerbActivity extends Activity {
	private static final int CLICK_WORD = 0;
	private static final int CLICK_TRANSLATE = 1;
	private static final int CLICK_CONJ = 2;

	private TextView vId;
	private TextView vTranslation;
	private TextView vInfinitive;
	private TextView vPresent;
	private TextView vPreterite;
	private TextView vPerfect;

	private DatabaseService dbs;
	private List<Integer> ids;

	private int clickType;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.verb_layout);

		this.vId = (TextView) findViewById(R.id.vid);
		vId.setVisibility(View.GONE);
		this.vTranslation = (TextView) findViewById(R.id.vtranslation);
		this.vInfinitive = (TextView) findViewById(R.id.vinfinitive);
		this.vPresent = (TextView) findViewById(R.id.vpresent);
		this.vPreterite = (TextView) findViewById(R.id.vpreterite);
		this.vPerfect = (TextView) findViewById(R.id.vperfect);

		this.dbs = new DatabaseService(this);
		// this.dbs.bouchon();

		nextVerb();
		this.clickType = CLICK_WORD;

		LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout);
		layout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				switch (clickType) {
				case CLICK_WORD:
					clickType = CLICK_TRANSLATE;
					vInfinitive.setVisibility(View.VISIBLE);
					break;
				case CLICK_TRANSLATE:
					clickType = CLICK_CONJ;
					vPresent.setVisibility(View.VISIBLE);
					vPreterite.setVisibility(View.VISIBLE);
					vPerfect.setVisibility(View.VISIBLE);
					break;
				case CLICK_CONJ:
					clickType = CLICK_WORD;
					nextVerb();
					break;
				default:
					break;
				}
			}
		});
	}

	private void nextVerb() {
		if (ids == null || ids.size() == 0) {
			this.ids = dbs.getVerbsGerIds();
			Collections.shuffle(ids);
		}

		Verb v = dbs.getVerbGer(String.valueOf(ids.remove(0)));
		vId.setText(v.getId());
		vTranslation.setText(v.getTranslation());
		vTranslation.setVisibility(View.VISIBLE);
		vInfinitive.setText(v.getInfinitive());
		vInfinitive.setVisibility(View.GONE);
		vPresent.setText(v.getPresent());
		vPresent.setVisibility(View.GONE);
		vPreterite.setText(v.getPreterite());
		vPreterite.setVisibility(View.GONE);
		vPerfect.setText(v.getPerfect());
		vPerfect.setVisibility(View.GONE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.verben, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		VerbDialog ad;
		switch (item.getItemId()) {
		case R.id.add:
			ad = new VerbDialog(this, dbs);
			ad.show();
			return true;
		case R.id.modify:
			ad = new VerbDialog(this, dbs, dbs.getVerbGer(vId.getText().toString()));
			ad.show();
			return true;
		case R.id.remove:
			dbs.deleteVerbGer(vId.getText().toString());
			this.ids = null;
			nextVerb();
			return true;
		case R.id.export:
			FileCreator.writeFile("verbsGer", dbs.exportVerbGer());			
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
