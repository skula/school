package com.skula.school.activities;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.skula.school.R;
import com.skula.school.activities.adapters.CategoryAdapter;
import com.skula.school.models.Category;
import com.skula.school.services.DatabaseService;

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

	private void updateList() {
		try {
			List<Category> list = dbService.getCategories(language);
			Category itemArray[] = (Category[]) list.toArray(new Category[list.size()]);
			CategoryAdapter adapter = new CategoryAdapter(this, R.layout.category_item_layout, itemArray);
			itemList.setAdapter(adapter);
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
