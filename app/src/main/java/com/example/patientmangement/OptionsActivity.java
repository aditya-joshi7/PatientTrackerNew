package com.example.patientmangement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class OptionsActivity extends AppCompatActivity {

    public void toPatientList(View view){

        mDatabaseHelper db = new mDatabaseHelper(getApplicationContext());
        int c= db.Count_rows();
        if(c>0)
        {
            Intent ii=new Intent(getApplicationContext(),PatientList.class);
            startActivity(ii);
        }
        else
            Toast.makeText(getApplicationContext(), "No Patient in Database", Toast.LENGTH_SHORT).show();
        }

    public void toAddDetails(View view){

        Intent iii=new Intent(getApplicationContext(),AddPatientD.class);
        startActivity(iii);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
    }
}
