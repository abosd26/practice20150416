package com.example.tcumi_h505.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class Spinner3Activity extends ActionBarActivity implements AdapterView.OnItemSelectedListener{
    String[] tea = {"請選擇", "紅茶", "綠茶", "奶茶"};
    ArrayAdapter<String> a1;
    Spinner s3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner3);
        s3 = (Spinner)findViewById(R.id.spinner3);
        a1 = new ArrayAdapter<String>(this, R.layout.forspinner, tea);
        a1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s3.setAdapter(a1);
        s3.setOnItemSelectedListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_spinner3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String appear = "\n";
        TextView t = (TextView)findViewById(R.id.textView10);
        if(position == 0){
            appear += "請選擇飲料\n";
        }
        if(appear.equals("\n")){
            t.setText("您點的飲料是: " + tea[position]);
            t.setVisibility(View.VISIBLE);
        }
        else{
            t.setVisibility(View.INVISIBLE);
            Toast.makeText(this.getApplicationContext(), appear, Toast.LENGTH_SHORT).show();
            appear = "\n";
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
