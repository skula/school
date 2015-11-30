package com.skula.school.activities.dialogs;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.skula.school.R;
import com.skula.school.activities.CategoryActivity;
import com.skula.school.services.DatabaseService;

public class CategoryDialog extends Dialog implements OnClickListener {
	public DatabaseService dbs;
	public Button btnCancel;
	public Button btnSave;
	private EditText title;
	private String label;
	private String categoryId;
	private CategoryActivity parentActivity;

	public CategoryDialog(CategoryActivity parentActivity, DatabaseService dbs) {
		super(parentActivity);
		this.dbs = dbs;
		this.parentActivity = parentActivity;
	}
	
	public CategoryDialog(CategoryActivity parentActivity, DatabaseService dbs, String label, String categoryId) {
		super(parentActivity);
		this.dbs = dbs;
		this.label = label;
		this.categoryId = categoryId;
		this.parentActivity = parentActivity;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.category_dial_layout);

		title = (EditText) findViewById(R.id.category_dial_title);

		btnCancel = (Button) findViewById(R.id.category_dial_btn_cancel);
		btnCancel.setOnClickListener(this);
		btnSave = (Button) findViewById(R.id.category_dial_btn_save);
		btnSave.setOnClickListener(this);
		
		if(categoryId==null){
			btnSave.setText("Ajouter");
		}else{
			btnSave.setText("Modifier");
			title.setText(label);
		}
	}

	@SuppressLint("NewApi")
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.category_dial_btn_cancel:
			dismiss();
			break;
		case R.id.category_dial_btn_save:
			String t = title.getText().toString();
			if (!t.isEmpty()) {
				if(label==null){
					dbs.insertCategory(t, "allemand");
					parentActivity.updateList();
				}else{
					dbs.updateCategory(categoryId, t);
					parentActivity.updateList();
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