package com.example.patientmangement;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

     public void onClick(View view){
       Intent i=new Intent(getApplicationContext(),OptionsActivity.class);
       startActivity(i);




     }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
