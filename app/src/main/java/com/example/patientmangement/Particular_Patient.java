package com.example.patientmangement;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Particular_Patient extends AppCompatActivity {
    com.example.patientmangement.mDatabaseHelper databaseHelper = new com.example.patientmangement.mDatabaseHelper(this);



    String docname =new String();
    String date=new String();


    String sym=new String();

    String medi =new String();















    Button dbutton;
    com.example.patientmangement.mDatabaseHelper db;
    String s;
    ArrayList<visit_details>  list= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_particular__patient);
        dbutton = (Button) findViewById(R.id.button5);
        Intent intent = getIntent();
        s = intent.getStringExtra("Name oF patient");
        final TextView textView = (TextView) findViewById(R.id.textView6);
        textView.setText("  Patient: " + s);

      /*  ListView listView=(ListView)findViewById(R.id.listOfvisits);
        CustomAdapter customAdapter=new CustomAdapter();
        listView.setAdapter(customAdapter);
        Log.i("docname  ",docname);*/


    }

    public void deleteit(View view){
        db= new com.example.patientmangement.mDatabaseHelper(getApplicationContext());
        int i=db.delete(s);
        if(i>0)
        {
            Toast.makeText(getApplicationContext(), "This item deleted from database", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Particular_Patient.this, OptionsActivity.class);
            startActivity(intent);
        }
    }

    public void toAddVisit(View view){
        Intent iiii=new Intent(getApplicationContext(),addVisit.class);
        iiii.putExtra("name", s);
        startActivity(iiii);
    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 1;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView=getLayoutInflater().inflate(R.layout.customlayout,null);
            TextView text_doc=(TextView) convertView.findViewById(R.id.textView2);
            TextView text_date=(TextView) convertView.findViewById(R.id.textView8);
            TextView text_sym=(TextView) convertView.findViewById(R.id.textView9);
            TextView text_medi=(TextView) convertView.findViewById(R.id.textView10);
            text_doc.setText("DOCTOR ASSIGNENED : "+docname);
            text_date.setText("DATE OF VISIT :"+date);
            text_sym.setText("SYMPTOMS FOUND: "+sym);
            text_medi.setText("MEDICINES GIVEN: "+medi);
            return convertView;

        }
    }



    public void geetData(){
        db=new mDatabaseHelper(getApplicationContext());
        SQLiteDatabase database=db.getReadableDatabase();
        String query="SELECT NAME ,DOCNAME,DATEE,SYMPTOMS,MEDICINES FROM PATIENT_DETAILS";
        Cursor data=database.rawQuery(query,new String[]{});

        if(data==null)
        {
            Log.i("failes","NUll DATA");
        }
            while(data.moveToNext()){
                if(s.equals(data.getString(0))) {
                  Log.i("NAme",data.getString(0));
                  docname=data.getString(1);
                    date=data.getString(2);
                    sym=data.getString(3);
                    medi=data.getString(4);
                  Log.i("docname",docname);


                  ListView listView=(ListView)findViewById(R.id.listOfvisits);
        CustomAdapter customAdapter=new CustomAdapter();
        listView.setAdapter(customAdapter);
        Log.i("docname  ",docname);

                }

            }


    }
    public void callgetdata(View view){

        geetData();
    }
}