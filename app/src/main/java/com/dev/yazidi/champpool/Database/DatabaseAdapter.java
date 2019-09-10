package com.dev.yazidi.champpool.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.dev.yazidi.champpool.Model.Score;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAdapter {
    private SQLiteDatabase database;

    public DatabaseAdapter(Context context) {
        DatabaseCreator creator = new DatabaseCreator(context);
        database = creator.getWritableDatabase();
    }

    public String addScore(Score score) {
        try {
            ContentValues values = new ContentValues();
            values.put(DatabaseCreator.SCORE_KEY_CHAMPION, score.getChampion());
            values.put(DatabaseCreator.SCORE_KEY_LANE, score.getLane());
            values.put(DatabaseCreator.SCORE_KEY_SCORE, score.getScore());
            database.insert(DatabaseCreator.SCORE_TABLE_NAME, null, values);
            return "Successfully added";
        }
        catch (Exception e){
            return e.getLocalizedMessage();
        }
    }

    public void updateScore(long id, Score score) {
        ContentValues values = new ContentValues();
        values.put(DatabaseCreator.SCORE_KEY_CHAMPION, score.getChampion());
        values.put(DatabaseCreator.SCORE_KEY_LANE, score.getLane());
        values.put(DatabaseCreator.SCORE_KEY_SCORE, score.getScore());
        database.update(DatabaseCreator.SCORE_TABLE_NAME, values, DatabaseCreator.SCORE_KEY_ID + " = " + id, null);
    }

    public void deleteScore(long id) {
        database.delete(DatabaseCreator.SCORE_TABLE_NAME, DatabaseCreator.SCORE_KEY_ID + " = " + id, null);
    }

    public List<Score> getAllScores() {
        List<Score> scores = new ArrayList<Score>();
        String[] strings = {DatabaseCreator.SCORE_KEY_ID, DatabaseCreator.SCORE_KEY_CHAMPION, DatabaseCreator.SCORE_KEY_LANE, DatabaseCreator.SCORE_KEY_SCORE};
        Cursor cursor = database.query(DatabaseCreator.SCORE_TABLE_NAME, strings, null, null, null, null, null);
        while (cursor.moveToNext()) {
            scores.add(new Score(cursor.getLong(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3)));
        }
        return scores;
    }

    public Score getOneScore(long id) {
        String[] strings = {DatabaseCreator.SCORE_KEY_ID, DatabaseCreator.SCORE_KEY_CHAMPION, DatabaseCreator.SCORE_KEY_LANE, DatabaseCreator.SCORE_KEY_SCORE};
        Cursor cursor = database.query(DatabaseCreator.SCORE_TABLE_NAME, strings, DatabaseCreator.SCORE_KEY_ID + " = " + id, null, null, null, null);
        if (cursor.moveToNext()) {
            return new Score(cursor.getLong(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3));
        }
        return null;
    }

    public List<Score> getTop5ByLane(String lane) {
        List<Score> scores = new ArrayList<Score>();
        String[] strings = {DatabaseCreator.SCORE_KEY_ID, DatabaseCreator.SCORE_KEY_CHAMPION, DatabaseCreator.SCORE_KEY_LANE, DatabaseCreator.SCORE_KEY_SCORE};
        Cursor cursor = database.query(DatabaseCreator.SCORE_TABLE_NAME, strings, DatabaseCreator.SCORE_KEY_LANE + " = '" + lane + "'", null, null, null, DatabaseCreator.SCORE_KEY_SCORE + " DESC", "5");
        while (cursor.moveToNext()) {
            scores.add(new Score(cursor.getLong(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3)));
        }
        return scores;
    }

    public List<String> getPool() {
        List<Score> top = getTop5ByLane("TOP");
        List<Score> jgl = getTop5ByLane("JUNGLE");
        List<Score> mid = getTop5ByLane("MIDDLE");
        List<Score> adc = getTop5ByLane("MARKSMAN");
        List<Score> supp = getTop5ByLane("SUPPORT");

        List<String> pool = new ArrayList<String>();

        for (int i = 0; i < 5; i++) {
            try {
                pool.add(top.get(i).getChampion());
            } catch (Exception e) {
                pool.add("?");
            }
            try {
                pool.add(jgl.get(i).getChampion());
            } catch (Exception e) {
                pool.add("?");
            }
            try {
                pool.add(mid.get(i).getChampion());
            } catch (Exception e) {
                pool.add("?");
            }
            try {
                pool.add(adc.get(i).getChampion());
            } catch (Exception e) {
                pool.add("?");
            }
            try {
                pool.add(supp.get(i).getChampion());
            } catch (Exception e) {
                pool.add("?");
            }
        }
        return pool;
    }
}
