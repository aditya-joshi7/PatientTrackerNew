package com.example.patientmangement;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PatientList extends AppCompatActivity {

    com.example.patientmangement.mDatabaseHelper databaseHelper = new com.example.patientmangement.mDatabaseHelper(this);
    ArrayList<String> patient_list = new ArrayList<>();

    private ListView listView; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_list);
        listView = (ListView) findViewById(R.id.patient_list);
        getData();
    }

    public void getData(){
        SQLiteDatabase database = databaseHelper.getReadableDatabase();
        String query = "SELECT NAME FROM PATIENT_DETAILS";
        Cursor data = database.rawQuery(query, new String[]{} );
        if(data!=null)
            data.moveToNext();

        do{
            String name = data.getString(0);
            patient_list.add(name);
        }while (data.moveToNext());

        ListAdapter adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,patient_list){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                // Get the Item from ListView
                View view = super.getView(position, convertView, parent);

                // Initialize a TextView for ListView each Item
                TextView tv = (TextView) view.findViewById(android.R.id.text1);

                // Set the text color of TextView (ListView Item)
                tv.setTextColor(Color.RED);
                tv.setTextSize(30);
                tv.setPadding(0,10,0,0);

                // Generate ListView Item using TextView
                return view;
            }
        };
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent ii=new Intent(PatientList.this,Particular_Patient.class);
                ii.putExtra("Name oF patient",patient_list.get(position));
                startActivity(ii);
            }
        });

    }
}
