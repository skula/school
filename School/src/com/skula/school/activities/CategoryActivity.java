package com.skula.school.activities;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.skula.school.R;
import com.skula.school.activities.adapters.CategoryAdapter;
import com.skula.school.activities.dialogs.CategoryDialog;
import com.skula.school.activities.dialogs.WordDialog;
import com.skula.school.models.Category;
import com.skula.school.services.DatabaseService;
import com.skula.school.utils.FileCreator;

public class CategoryActivity extends Activity {
	private ListView itemList;
	private DatabaseService dbService;
	private String language;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.category_layout);

		this.language = getIntent().getExtras().getString("language");
		
		dbService = new DatabaseService(this);
		itemList = (ListView) findViewById(R.id.category_list);
		updateList();

		itemList.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {
				Category item = (Category) itemList.getItemAtPosition(position);
				Bundle mBundle = new Bundle();
				mBundle.putString("categoryid", item.getId());
				Intent intent = new Intent(v.getContext(), WordActivity.class);
				intent.putExtras(mBundle);
				startActivity(intent);
			}
		});
	}

	public void updateList() {
		List<Category> list = dbService.getCategories(language);
		Category itemArray[] = (Category[]) list.toArray(new Category[list.size()]);
		CategoryAdapter adapter = new CategoryAdapter(this, R.layout.category_item_layout, itemArray);
		itemList.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.category, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		CategoryDialog ad;
		switch (item.getItemId()) {
		case R.id.add:
			ad = new CategoryDialog(this, dbService);
			ad.show();
			return true;
		case R.id.export:
			FileCreator.writeFile("categories", dbService.exportCategories());		
			FileCreator.writeFile("mots", dbService.exportWords());			
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
