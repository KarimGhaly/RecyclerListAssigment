package com.example.admin.recyclerlistassigment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.admin.recyclerlistassigment.R.id.parent;

/**
 * Created by Admin on 9/13/2017.
 */

public class Database extends SQLiteOpenHelper {

    public static final String Database_Name = "DB";
    public static final int Database_Version = 4;
    public static final String Table_Name = "AnimalsTBL";
    public static final String TAG = "SQLDATABASESQL";
    public static final String Column_Name = "Name";
    public static final String Column_Category = "Category";
    public static final String Column_Age = "Age";
    public static final String Column_Weight = "Weight";
    public static final String Column_ImgID = "ImgID";

    public Database(Context context) {
        super(context, Database_Name, null, Database_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CreateQuery = "CREATE TABLE " + Table_Name + " (" + Column_Name + " Text," + Column_Category + " Text," + Column_Age + " integer," + Column_Weight + " integer," + Column_ImgID + " integer)";
        db.execSQL(CreateQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_Name);
        onCreate(db);
    }

    public boolean InsertAnimals(List<Animals> animalsList) {
        boolean Status = true;
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        for (Animals a : animalsList) {
            ContentValues cv = new ContentValues();
            cv.put(Column_Name, a.getName());
            cv.put(Column_Category, a.getCategory());
            cv.put(Column_Age, a.getAge());
            cv.put(Column_Weight, a.getWeight());
            cv.put(Column_ImgID,a.getImageID());
            long isSaved = sqLiteDatabase.insert(Table_Name, null, cv);
            if (isSaved < 0) {
                return false;
            }
        }
        return Status;
    }

    public void DeleteItem(String Name) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(Table_Name, Column_Name  + "='" + Name + "'", null);

    }

    public List<Animals> getAnimalsList() {

        List<Animals> animalsList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String query = "Select * FROM " + Table_Name;
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Animals a = new Animals(cursor.getString(0), cursor.getString(1), cursor.getInt(2), cursor.getInt(3), cursor.getInt(4));
                Log.d(TAG, "getAnimalsList: "+cursor.getInt(2));
                animalsList.add(a);
            } while (cursor.moveToNext());
        }
        return animalsList;
    }

}
