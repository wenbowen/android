package com.example.w1936.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

public class dao {

    private DataBase dataBase;

    public dao(Context context){
        dataBase=new DataBase(context,"firstDb.db", null, 1);

    }
    public boolean insert(JavaBean j){
        SQLiteDatabase db=dataBase.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("englishText",j.englishText);
        contentValues.put("chinaText",j.chinaText);
        long i = db.insert("firstDb", null, contentValues);
        db.close();
        if(i == -1){
            return false;
        }
        return true;
    }

    public void search(JavaBean j){
        SQLiteDatabase db=dataBase.getReadableDatabase();
        Cursor cursor=db.query("firstDb",new String[]{"_id","englishText","chinaText"},"englishText = ?",new String[]{j.englishText},null,null,"_id desc");
        if(cursor!=null&&cursor.getCount()>0){
            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                String e = cursor.getString(1);
                String c = cursor.getString(2);
                Log.d("msg", id + " " + e + " " + c);
            }cursor.close();
        }    db.close();
    }

    public void delete(JavaBean j,Context context){
        SQLiteDatabase db = dataBase.getReadableDatabase();

        int i =  db.delete("firstDb","englishText = ? ",new String[]{j.englishText});
        db.delete("firstDb","chinaText = ? ",new String[]{j.chinaText});
        Toast.makeText(context, "删除了" + i + "行",
                Toast.LENGTH_SHORT).show();
        db.close();

    }

    public  void update(JavaBean javaBean,Context context){
        SQLiteDatabase db = dataBase.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("englishText",javaBean.englishText);
        contentValues.put("chinaText",javaBean.chinaText);
        int resule = db.update("firstDb",contentValues,"englishText = ?",new String[]{javaBean.englishText});
        Toast.makeText(context,"修改了"+ resule + "行",Toast.LENGTH_SHORT).show();
        db.close();
    }
}