package com.example.baitaplythuyet3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "StudentDB";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_STUDENT = "students";
    private static final String COL_ID = "mssv";
    private static final String COL_NAME = "name";
    private static final String COL_CLASS = "lop";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_STUDENT + "("
                + COL_ID + " TEXT PRIMARY KEY,"
                + COL_NAME + " TEXT,"
                + COL_CLASS + " TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT);
        onCreate(db);
    }

    // Insert
    public void insertStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_ID, student.getMssv());
        values.put(COL_NAME, student.getName());
        values.put(COL_CLASS, student.getLop());
        db.insert(TABLE_STUDENT, null, values);
        db.close();
    }

    // Get all
    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_STUDENT, null);
        if (cursor.moveToFirst()) {
            do {
                list.add(new Student(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2)
                ));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }

    // Update
    public void updateStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, student.getName());
        values.put(COL_CLASS, student.getLop());
        db.update(TABLE_STUDENT, values, COL_ID + "=?", new String[]{student.getMssv()});
        db.close();
    }

    // Delete
    public void deleteStudent(String mssv) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_STUDENT, COL_ID + "=?", new String[]{mssv});
        db.close();
    }
}
