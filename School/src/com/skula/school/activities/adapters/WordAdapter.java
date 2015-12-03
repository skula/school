package com.skula.school.activities.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.skula.school.R;
import com.skula.school.models.Word;

public class WordAdapter extends ArrayAdapter<Word> {

	Context context;
	int layoutResourceId;
	Word data[] = null;

	public WordAdapter(Context context, int layoutResourceId, Word[] data) {
		super(context, layoutResourceId, data);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.data = data;
	}

	@SuppressLint("ViewHolder")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Word w = data[position];
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.word_item_layout, parent, false);
		
		TextView id = (TextView) rowView.findViewById(R.id.word_item_id);
		id.setText(w.getId());	
		TextView word = (TextView) rowView.findViewById(R.id.word_item_word);
		String article = w.getArticle();
		if(article.isEmpty()){
			word.setText(w.getWord());
		}else{
			word.setText(article + " " + w.getWord());
		}
		TextView translation = (TextView) rowView.findViewById(R.id.word_item_translation);
		translation.setText(w.getTranslation());
		
		return rowView;
	}
}