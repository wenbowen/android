package com.example.w1936.myapplication;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    private DataBaseHelp dataBaseHelp = new DataBaseHelp(this, "word.db", null, 1);

    private int id = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void insert(View v) {
        EditText enText = (EditText) findViewById(R.id.en_edit);
        EditText chText = (EditText) findViewById(R.id.ch_edit);
        ContentValues contentValues = new ContentValues();
        contentValues.put("en", enText.getText().toString());
        contentValues.put("ch", chText.getText().toString());
        String showToast;
        if (id != -1) {
            dataBaseHelp.getWritableDatabase().update("word", contentValues, "id = ?", new String[]{id + ""});
            showToast = "update success";
        } else {
            dataBaseHelp.getWritableDatabase().insert("word", null, contentValues);
            showToast = "insert success";
        }
        enText.setText("");
        chText.setText("");
        Toast.makeText(this, showToast, Toast.LENGTH_SHORT).show();
    }

    public void search(View v) {
        Cursor cursor = searchWord();
        String result = "";
        if (!cursor.moveToNext()) {
            result = "查无此词";
        }
        while (cursor.moveToNext()) {
            result += cursor.getInt(0) + ";" + cursor.getString(1) + ";" + cursor.getString(2);
        }
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }

    public void delete(View v) {
        EditText searchText = (EditText) findViewById(R.id.search_edit);
        dataBaseHelp.getWritableDatabase().delete("word", "en like ? or ch like ?",
                new String[]{"%" + searchText.getText().toString() + "%", "%" + searchText.getText().toString() + "%"});
        Toast.makeText(this, "delete success", Toast.LENGTH_SHORT).show();
    }

    public void update(View v) {
        Cursor cursor = searchWord();
        cursor.moveToFirst();
        ((EditText) findViewById(R.id.en_edit)).setText(cursor.getString(1));
        ((EditText) findViewById(R.id.ch_edit)).setText(cursor.getString(2));
        id = cursor.getInt(0);
    }

    public Cursor searchWord() {
        String searchText = ((EditText) findViewById(R.id.search_edit)).getText().toString();
        return dataBaseHelp.getReadableDatabase().query("word", null,
                "en like ? or ch like ?",
                new String[]{"%" + searchText + "%", "%" + searchText + "%"},
                null, null, null);
    }
}
