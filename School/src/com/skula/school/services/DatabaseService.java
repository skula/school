package com.skula.school.services;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import com.skula.school.models.Verb;
import com.skula.school.models.Word;

public class DatabaseService {
	private static final String DATABASE_NAME = "school.db";
	private static final int DATABASE_VERSION = 1;
	private static final String TABLE_NAME_VERB_GERMAN = "verbGER";
	private static final String TABLE_NAME_WORD_GERMAN = "wordGER";

	private Context context;
	private SQLiteDatabase database;
	private SQLiteStatement statement;

	public DatabaseService(Context context) {
		this.context = context;
		OpenHelper openHelper = new OpenHelper(this.context);
		this.database = openHelper.getWritableDatabase();
	}

	public void bouchon() {
		database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_VERB_GERMAN);
		database.execSQL("CREATE TABLE "
				+ TABLE_NAME_VERB_GERMAN
				+ "(id integer PRIMARY KEY, infinitive TEXT, present TEXT, preterite TEXT, perfect TEXT, translation TEXT)");

		database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_WORD_GERMAN);
		database.execSQL("CREATE TABLE " + TABLE_NAME_WORD_GERMAN
				+ "(id integer PRIMARY KEY, word TEXT, translation TEXT)");

		insertVerbGer(Verb.VERBS.get(0));
		insertWordGer("der Frühling", "le printemps");
		/*
		 * for (Verb v : Verb.VERBS) { insertVerbGer(v); }
		 */
	}

	public void insertVerbGer(Verb v) {
		String sql = "insert into " + TABLE_NAME_VERB_GERMAN
				+ "(id, infinitive, present, preterite, perfect, translation) values (?,?,?,?,?,?)";
		statement = database.compileStatement(sql);
		statement.bindString(1, v.getId());
		statement.bindString(2, v.getInfinitive());
		statement.bindString(3, v.getPresent());
		statement.bindString(4, v.getPreterite());
		statement.bindString(5, v.getPerfect());
		statement.bindString(6, v.getTranslation());
		statement.executeInsert();
	}

	public void insertVerbGer(String infinitive, String present, String preterite, String perfect, String translation) {
		String sql = "insert into " + TABLE_NAME_VERB_GERMAN
				+ "(id, infinitive, present, preterite, perfect, translation) values (?,?,?,?,?,?)";
		statement = database.compileStatement(sql);
		statement.bindString(1, String.valueOf(getNextVerbGerId()));
		statement.bindString(2, infinitive);
		statement.bindString(3, present);
		statement.bindString(4, preterite);
		statement.bindString(5, perfect);
		statement.bindString(6, translation);
		statement.executeInsert();
	}
	
	public void updateVerbGer(String id, String infinitive, String present, String preterite, String perfect, String translation) {
		ContentValues args = new ContentValues();
		args.put("infinitive", infinitive);
		args.put("present", present);
		args.put("preterite", preterite);
		args.put("perfect", perfect);
		args.put("translation", translation);
		database.update(TABLE_NAME_VERB_GERMAN, args, "id=" + id, null);
	}

	public void deleteAllVerbsGer() {
		database.delete(TABLE_NAME_VERB_GERMAN, null, null);
	}

	public void deleteVerbGer(String id) {
		database.delete(TABLE_NAME_VERB_GERMAN, "id='" + id + "'", null);
	}

	public Verb getVerbGer(String id) {
		Cursor cursor = database.query(TABLE_NAME_VERB_GERMAN,
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

	public List<Integer> getVerbsGerIds() {
		List<Integer> res = new ArrayList<Integer>();
		Cursor cursor = database.query(TABLE_NAME_VERB_GERMAN, new String[] { "id" }, null, null, null, null, null);
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
	
	public List<List<String>> exportVerbGer() {
		List<List<String>> res = new ArrayList<List<String>>();
		Cursor cursor = database.query(TABLE_NAME_VERB_GERMAN,
				new String[] { "id, infinitive, present, preterite, perfect, translation" }, null, null,
				null, null, null);
		if (cursor.moveToFirst()) {
			do {
				List<String> line= new ArrayList<String>();
				for(int i = 0; i<6; i++){
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

	public int getNextVerbGerId() {
		Cursor cursor = database
				.query(TABLE_NAME_VERB_GERMAN, new String[] { "max(id)" }, null, null, null, null, null);
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

	public void insertWordGer(String word, String translation) {
		String sql = "insert into " + TABLE_NAME_WORD_GERMAN + "(id, word, translation) values (?,?,?)";
		statement = database.compileStatement(sql);
		statement.bindString(1, String.valueOf(getNextWordGerId()));
		statement.bindString(2, word);
		statement.bindString(3, translation);
		statement.executeInsert();
	}
	
	public void updateWordGer(String id, String word, String translation) {
		ContentValues args = new ContentValues();
		args.put("word", word);
		args.put("translation", translation);
		database.update(TABLE_NAME_WORD_GERMAN, args, "id=" + id, null);
	}

	public void deleteAllWordsGer() {
		database.delete(TABLE_NAME_WORD_GERMAN, null, null);
	}

	public void deleteWordGer(String id) {
		database.delete(TABLE_NAME_WORD_GERMAN, "id='" + id + "'", null);
	}

	public Word getWordGer(String id) {
		Cursor cursor = database.query(TABLE_NAME_WORD_GERMAN, new String[] { "id, word, translation" }, "id='" + id
				+ "'", null, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				return new Word(cursor.getString(0), cursor.getString(1), cursor.getString(2));
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		return null;
	}

	public List<Integer> getWordsGerIds() {
		List<Integer> res = new ArrayList<Integer>();
		Cursor cursor = database.query(TABLE_NAME_WORD_GERMAN, new String[] { "id" }, null, null, null, null, null);
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

	public List<List<String>> exportWordsGer() {
		List<List<String>> res = new ArrayList<List<String>>();
		Cursor cursor = database.query(TABLE_NAME_WORD_GERMAN,
				new String[] { "id, word, translation" }, null, null,
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
	
	public int getNextWordGerId() {
		Cursor cursor = database
				.query(TABLE_NAME_WORD_GERMAN, new String[] { "max(id)" }, null, null, null, null, null);
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
		public void onCreate(SQLiteDatabase db) {
			db.execSQL("CREATE TABLE "
					+ TABLE_NAME_VERB_GERMAN
					+ "(id integer PRIMARY KEY, infinitive TEXT, present TEXT, preterite TEXT, perfect TEXT, translation TEXT)");
			db.execSQL("CREATE TABLE " + TABLE_NAME_WORD_GERMAN
					+ "(id integer PRIMARY KEY, word TEXT, translation TEXT)");
		}

		@Override
		public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
			database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_VERB_GERMAN);
			database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_WORD_GERMAN);
			onCreate(database);
		}
	}
}