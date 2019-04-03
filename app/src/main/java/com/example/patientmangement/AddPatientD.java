package com.example.patientmangement;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddPatientD extends AppCompatActivity {
    EditText e_name,e_age,e_gender,e_phno;
    String name,phone;
    int age;
    char gender;
    com.example.patientmangement.mDatabaseHelper helper;

    public void saveData(View view){
        if(e_phno.getText().toString().isEmpty() || e_name.getText().toString().isEmpty() || e_gender.getText().toString().isEmpty() || e_age.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Fill all the details", Toast.LENGTH_SHORT).show();
        }
        else {
            name = e_name.getText().toString();
            String iage = e_age.getText().toString();
            age = Integer.parseInt(iage);
            String igen = e_gender.getText().toString();
            gender = igen.charAt(0);
            phone = e_phno.getText().toString();
            AddData(name, age, gender, phone);
            e_age.setText("");
            e_gender.setText("");
            e_name.setText("");
            e_phno.setText("");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient_d);
        e_name=(EditText)findViewById(R.id.pname);
        e_age=(EditText)findViewById(R.id.page);
        e_gender=(EditText)findViewById(R.id.pgen);
        e_phno=(EditText)findViewById(R.id.ppno);
        helper = new com.example.patientmangement.mDatabaseHelper(this);


    }

    public void AddData(String Name, int Age, char Gender, String Phone) {
        boolean insertData = helper.addData(Name,Age,Gender,Phone);
        if(insertData==true)
            Toast.makeText(this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
    }
}
