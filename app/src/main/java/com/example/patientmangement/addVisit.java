package com.example.patientmangement;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class addVisit extends AppCompatActivity {
   // Particular_Patient p=new Particular_Patient(getApplicationContext());

    String name;
    String date;
    String sympo;
    String medicines;
    EditText doc_name,daate,symp,medi;
    String namep;


    com.example.patientmangement.mDatabaseHelper helper;

    public void saveDataaa(View view){
        if(doc_name.getText().toString().isEmpty() || symp.getText().toString().isEmpty() || medi.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Fill all the details", Toast.LENGTH_SHORT).show();
        }
        else {
            name = doc_name.getText().toString();
             date=daate.getText().toString();
             sympo=symp.getText().toString();
             medicines=medi.getText().toString();

            // AddDataa(name, date, sympo, medicines);
            doc_name.setText("");
            daate.setText("");
            symp.setText("");
            medi.setText("");
        }
        ContentValues values = new ContentValues();
        values.put("DOCNAME",name);
        values.put("DATEE",date);
        values.put("SYMPTOMS",sympo);
        values.put("MEDICINES",medicines);
        SQLiteDatabase db = helper.getWritableDatabase();
        int r=db.update("PATIENT_DETAILS", values, "NAME = ?", new String[]{namep});;
        if(r>0)
        {
            Toast.makeText(getApplicationContext(), namep + " Updated", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Rows not updated", Toast.LENGTH_SHORT).show();
        }

       // p.geetData();


    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_visit);

        doc_name=(EditText)findViewById(R.id.editText1);
        daate=(EditText)findViewById(R.id.editText2);
        symp=(EditText)findViewById(R.id.editText3);
        medi=(EditText)findViewById(R.id.editText4);
        helper = new com.example.patientmangement.mDatabaseHelper(this);
        Intent intent = getIntent();
        namep = intent.getStringExtra("name");
        Log.i("name",namep);


    }


    /*public void AddDataa(String Name, String date, String sympotoms, String medicines) {
        boolean insertData = helper.addDatavisit(Name,date,sympotoms,medicines);
        if(insertData==true)
            Toast.makeText(this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
    }*/

}



