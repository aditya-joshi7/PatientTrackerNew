package com.example.patientmangement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.jar.Attributes;

import static android.os.Build.VERSION_CODES.M;

public class mDatabaseHelper extends SQLiteOpenHelper {

    public static final String DBNAMEE = "PatientDatabase2";

    public static final int version = 1;

    mDatabaseHelper(Context context){
        super(context,DBNAMEE,null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE PATIENT_DETAILS (id INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, AGE INT, GENDER INT, PHONE TEXT, DOCNAME TEXT,DATEE TEXT, SYMPTOMS TEXT, MEDICINES TEXT)";
        db.execSQL(sql);


        // Insert
//        insertData("Gaurav Sharma", 19, 'M', "7999339524", db );
    }

    public int delete(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        int i=db.delete("PATIENT_DETAILS", "NAME = ?", new String[]{name});
        return i;
    }
    public int Count_rows()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String count = "SELECT count(*) FROM PATIENT_DETAILS";
        Cursor mcursor = db.rawQuery(count, null);
        mcursor.moveToFirst();
        int icount = mcursor.getInt(0);
        return icount;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //String sqll = "CREATE TABLE PATIENT_VISIT (id INTEGER PRIMARY KEY AUTOINCREMENT,DOCNAME TEXT,DATE TEXT,SYMPTOMS TEXT,MEDICINES TEXT)";
        //db.execSQL(sqll);
        //Log.i("2nd table","2nd table created");

    }

    public boolean addData(String Name, int Age, char Gender, String Phone) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("NAME",Name);
        values.put("AGE",Age);
        values.put("GENDER",(int) Gender);
        values.put("PHONE",Phone);
        long result = database.insert("PATIENT_DETAILS", null, values);
        if(result==-1)
            return false;
        else
            return true;
    }


    /*public boolean addDatavisit(String docname, String date, String symp, String medi) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("DOCNAME",docname);
        values.put("DATE",date);
        values.put("SYMPTOMS",symp);
        values.put("MEDICINES",medi);
        long result = database.insert("PATIENT_VISIT", null, values);
        if(result==-1)
            return false;
        else
            return true;
    }*/






}
