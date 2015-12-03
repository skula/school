package com.skula.school.services;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import com.skula.school.models.Category;
import com.skula.school.models.Data;
import com.skula.school.models.Verb;
import com.skula.school.models.Word;

public class DatabaseService {
	private static final String DATABASE_NAME = "school.db";
	private static final int DATABASE_VERSION = 1;
	private static final String TABLE_VERB = "verb";
	private static final String TABLE_WORD = "word";
	private static final String TABLE_CATEGORY = "category";
	private static final String TABLE_LANGUAGE = "language";

	private Context context;
	private SQLiteDatabase database;
	private SQLiteStatement statement;

	public DatabaseService(Context context) {
		this.context = context;
		OpenHelper openHelper = new OpenHelper(this.context);
		this.database = openHelper.getWritableDatabase();
	}

	public void bouchon() {				
		database.execSQL("DROP TABLE IF EXISTS " + TABLE_LANGUAGE);
		database.execSQL("CREATE TABLE " + TABLE_LANGUAGE + "(id INTEGER PRIMARY KEY, label TEXT)");
		
		database.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORY);
		database.execSQL("CREATE TABLE " + TABLE_CATEGORY + "(id INTEGER PRIMARY KEY, label TEXT, languageid TEXT)");
		
		database.execSQL("DROP TABLE IF EXISTS " + TABLE_WORD);
		database.execSQL("CREATE TABLE " + TABLE_WORD + "(id INTEGER PRIMARY KEY, categoryid INTEGER, article TEXT, word TEXT, translation TEXT)");

		database.execSQL("DROP TABLE IF EXISTS " + TABLE_VERB);
		database.execSQL("CREATE TABLE " + TABLE_VERB + "(id integer PRIMARY KEY, infinitive TEXT, present TEXT, preterite TEXT, perfect TEXT, translation TEXT, languageid TEXT)");
		
		Data.insert(this);
	}

	/*****************************************************/
	/******************* LANGAGES ************************/
	/*****************************************************/
	public String insertLanguage(String language) {
		String sql = "insert into " + TABLE_LANGUAGE
				+ "(id, label) values (?,?)";
		String id = String.valueOf(getNextLanguageId());
		statement = database.compileStatement(sql);
		statement.bindString(1, id);
		statement.bindString(2, language);
		statement.executeInsert();
		
		return id;
	}
	
	public void updateLanguage(String id, String newLabel) {
		ContentValues args = new ContentValues();
		args.put("label", newLabel);;
		database.update(TABLE_LANGUAGE, args, "id=" + id, null);
	}

	public void deleteLanguage(String id) {
		database.delete(TABLE_LANGUAGE, "id='" + id + "'", null);
	}

	public String getLanguageId(String language) {
		Cursor cursor = database.query(TABLE_LANGUAGE,
				new String[] { "id" }, "label='" + language + "'", null,
				null, null, null);
		if (cursor.moveToFirst()) {
			do {
				String res = cursor.getString(0);
				return cursor.getString(0);
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		return null;
	}

	public int getNextLanguageId() {
		Cursor cursor = database
				.query(TABLE_LANGUAGE, new String[] { "max(id)" }, null, null, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				return cursor.getInt(0) + 1;
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		return 1;
	}
	
	/*****************************************************/
	/****************** CATEGORIES ***********************/
	/*****************************************************/
	public String insertCategory(String label, String languageId) {
		String sql = "insert into " + TABLE_CATEGORY + "(id, label, languageid) values (?,?,?)";
		String id = String.valueOf(getNextCategoryId());
		statement = database.compileStatement(sql);
		statement.bindString(1, id);
		statement.bindString(2, label);
		statement.bindString(3, languageId);
		statement.executeInsert();
		return id;
	}
	
	public void updateCategory(String oldLabel, String label) {
		ContentValues args = new ContentValues();
		args.put("label", label);
		database.update(TABLE_CATEGORY, args, "label='" + oldLabel + "'", null);
	}

	public void deleteCategory(String id) {
		database.delete(TABLE_WORD, "categoryid='"+id+"'", null);
		database.delete(TABLE_CATEGORY, "id='" + id + "'", null);
	}

	public List<Category> getCategories(String languageId) {
		List<Category> res = new ArrayList<Category>();
		Cursor cursor = database.query(TABLE_CATEGORY, new String[] { "id", "label", "languageid" }, "languageid='" + languageId + "'", null, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				res.add(new Category(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		return res;
	}

	public int getNextCategoryId() {
		Cursor cursor = database
				.query(TABLE_CATEGORY, new String[] { "max(id)" }, null, null, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				return cursor.getInt(0) + 1;
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		return 1;
	}
	
	public List<List<String>> exportCategories() {
		List<List<String>> res = new ArrayList<List<String>>();
		Cursor cursor = database.query(TABLE_CATEGORY,
				new String[] { "id, label, languageid" }, null, null,
				null, null, null);
		if (cursor.moveToFirst()) {
			do {
				List<String> line= new ArrayList<String>();
				for(int i = 0; i<3; i++){
					line.add(cursor.getString(i));
				}
				res.add(line);
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		return res;
	}
	
	/*****************************************************/
	/******************** VERBES *************************/
	/*****************************************************/
	public String insertVerb(Verb v) {
		String sql = "insert into " + TABLE_VERB
				+ "(id, infinitive, present, preterite, perfect, translation, languageid) values (?,?,?,?,?,?,?)";
		String id = String.valueOf(getNextVerbId());
		statement = database.compileStatement(sql);
		statement.bindString(1, id);
		statement.bindString(2, v.getInfinitive());
		statement.bindString(3, v.getPresent());
		statement.bindString(4, v.getPreterite());
		statement.bindString(5, v.getPerfect());
		statement.bindString(6, v.getTranslation());
		statement.bindString(7, v.getLanguage());
		statement.executeInsert();		
		return id;
	}

	public String insertVerb(String infinitive, String present, String preterite, String perfect, String translation, String languageId) {
		String sql = "insert into " + TABLE_VERB
				+ "(id, infinitive, present, preterite, perfect, translation, languageid) values (?,?,?,?,?,?,?)";
		String id = String.valueOf(getNextVerbId());
		statement = database.compileStatement(sql);
		statement.bindString(1, id);
		statement.bindString(2, infinitive);
		statement.bindString(3, present);
		statement.bindString(4, preterite);
		statement.bindString(5, perfect);
		statement.bindString(6, translation);
		statement.bindString(7, languageId);
		statement.executeInsert();
		return id;
	}
	
	public void updateVerb(String id, String infinitive, String present, String preterite, String perfect, String translation) {
		ContentValues args = new ContentValues();
		args.put("infinitive", infinitive);
		args.put("present", present);
		args.put("preterite", preterite);
		args.put("perfect", perfect);
		args.put("translation", translation);
		database.update(TABLE_VERB, args, "id=" + id, null);
	}

	public void deleteAllVerbs(String languageId) {
		database.delete(TABLE_VERB, "languageid='" + languageId + "'", null);
	}

	public void deleteVerb(String id) {
		database.delete(TABLE_VERB, "id='" + id + "'", null);
	}

	public Verb getVerb(String id) {
		Cursor cursor = database.query(TABLE_VERB,
				new String[] { "id, infinitive, present, preterite, perfect, translation" }, "id='" + id + "'", null,
				null, null, null);
		if (cursor.moveToFirst()) {
			do {
				Verb v = new Verb();
				v.setId(cursor.getString(0));
				v.setInfinitive(cursor.getString(1));
				v.setPresent(cursor.getString(2));
				v.setPreterite(cursor.getString(3));
				v.setPerfect(cursor.getString(4));
				v.setTranslation(cursor.getString(5));
				return v;
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		return null;
	}

	public List<Integer> getVerbsIds(String languageId) {
		List<Integer> res = new ArrayList<Integer>();
		Cursor cursor = database.query(TABLE_VERB, new String[] { "id" }, "languageid='" + languageId + "'", null, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				res.add(cursor.getInt(0));
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		return res;
	}
	
	public List<List<String>> exportVerb(String languageId) {
		List<List<String>> res = new ArrayList<List<String>>();
		Cursor cursor = database.query(TABLE_VERB,
				new String[] { "id, infinitive, present, preterite, perfect, translation, languageid" }, "languageid='" + languageId + "'", null,
				null, null, null);
		if (cursor.moveToFirst()) {
			do {
				List<String> line= new ArrayList<String>();
				for(int i = 0; i<7; i++){
					line.add(cursor.getString(i));
				}
				res.add(line);
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		return res;
	}

	public int getNextVerbId() {
		Cursor cursor = database
				.query(TABLE_VERB, new String[] { "max(id)" }, null, null, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				return cursor.getInt(0) + 1;
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		return 1;
	}

	/*****************************************************/
	/********************* MOTS **************************/
	/*****************************************************/
	public String insertWord(String article, String word, String translation, String categoryId) {
		String sql = "insert into " + TABLE_WORD + "(id, categoryid, article, word, translation) values (?,?,?,?,?)";
		String id = String.valueOf(getNextWordId());
		statement = database.compileStatement(sql);
		statement.bindString(1, id);
		statement.bindString(2, categoryId);
		statement.bindString(3, article);
		statement.bindString(4, word);
		statement.bindString(5, translation);
		statement.executeInsert();
		return id;
	}
	
	public void updateWord(String id, String article, String word, String translation) {
		ContentValues args = new ContentValues();
		args.put("article", article);
		args.put("word", word);
		args.put("translation", translation);
		database.update(TABLE_WORD, args, "id=" + id, null);
	}
	
	public void deleteWord(String id) {
		database.delete(TABLE_WORD, "id='" + id + "'", null);
	}

	public Word getWord(String id) {
		Cursor cursor = database.query(TABLE_WORD, new String[] { "id, article, word, translation" }, "id='" + id
				+ "'", null, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				return new Word(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		return null;
	}

	public List<Integer> getWordsIds(String categoryId) {
		List<Integer> res = new ArrayList<Integer>();
		Cursor cursor = database.query(TABLE_WORD, new String[] { "id" }, "categoryid='" + categoryId + "'", null, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				res.add(cursor.getInt(0));
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		return res;
	}
	
	public List<Word> getWords(String categoryId) {
		List<Word> res = new ArrayList<Word>();
		Cursor cursor = database.query(TABLE_WORD, new String[] { "id, article, word, translation" }, "categoryid='" + categoryId + "'", null, null, null, "word asc");
		if (cursor.moveToFirst()) {
			do {
				res.add(new Word(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		return res;
	}

	public List<List<String>> exportWords() {
		List<List<String>> res = new ArrayList<List<String>>();
		Cursor cursor = database.query(TABLE_WORD,
				new String[] { "id, article, word, translation, categoryid" }, null, null,
				null, null, null);
		if (cursor.moveToFirst()) {
			do {
				List<String> line= new ArrayList<String>();
				for(int i = 0; i<5; i++){
					line.add(cursor.getString(i));
				}
				res.add(line);
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		return res;
	}
	
	public int getNextWordId() {
		Cursor cursor = database
				.query(TABLE_WORD, new String[] { "max(id)" }, null, null, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				return cursor.getInt(0) + 1;
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		return 1;
	}
	
	private static class OpenHelper extends SQLiteOpenHelper {
		public OpenHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase database) {
			database.execSQL("CREATE TABLE " + TABLE_LANGUAGE + "(id INTEGER PRIMARY KEY, label TEXT)");
			database.execSQL("CREATE TABLE " + TABLE_CATEGORY
				+ "(id INTEGER PRIMARY KEY, label TEXT, language TEXT)");
			database.execSQL("CREATE TABLE "
					+ TABLE_VERB
					+ "(id integer PRIMARY KEY, infinitive TEXT, present TEXT, preterite TEXT, perfect TEXT, translation, languageid TEXT)");
			database.execSQL("CREATE TABLE " + TABLE_WORD
					+ "(id integer PRIMARY KEY, categoryid INTEGER, article TEXT, word TEXT, translation TEXT)");
		}

		@Override
		public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
			database.execSQL("DROP TABLE IF EXISTS " + TABLE_LANGUAGE);
			database.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORY);
			database.execSQL("DROP TABLE IF EXISTS " + TABLE_VERB);
			database.execSQL("DROP TABLE IF EXISTS " + TABLE_WORD);
			onCreate(database);
		}
	}
}