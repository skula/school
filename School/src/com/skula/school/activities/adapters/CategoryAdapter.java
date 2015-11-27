package com.skula.school.activities.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.skula.school.R;
import com.skula.school.models.Category;

public class CategoryAdapter extends ArrayAdapter<Category> {

	Context context;
	int layoutResourceId;
	Category data[] = null;

	public CategoryAdapter(Context context, int layoutResourceId, Category[] data) {
		super(context, layoutResourceId, data);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.data = data;
	}

	@SuppressLint("ViewHolder")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Category episode = data[position];
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.category_item_layout, parent, false);
		
		TextView shortcut = (TextView) rowView.findViewById(R.id.category_id);
		shortcut.setText(episode.getId());	
		TextView season = (TextView) rowView.findViewById(R.id.category_label);
		season.setText(episode.getLabel());
		
		return rowView;
	}
}