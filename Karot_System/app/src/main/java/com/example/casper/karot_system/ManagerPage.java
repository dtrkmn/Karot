package com.example.casper.karot_system;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;


public class ManagerPage extends ActionBarActivity {
    AutoCompleteTextView goller1;
    AutoCompleteTextView goller2;
    Button activate;
    Button deactivate;
    Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_page);
        goller1=(AutoCompleteTextView)findViewById(R.id.lake1);
        goller2=(AutoCompleteTextView)findViewById(R.id.lake2);
        activate=(Button)findViewById(R.id.btn_activate);
        deactivate=(Button)findViewById(R.id.btn_deactivate);
        home=(Button)findViewById(R.id.homepge);
        ArrayAdapter<String> adaptor = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,Universities);
        goller1.setAdapter(adaptor);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ManagerPage.this,Map.class);
                String man="manager";
                i.putExtra("send",man);
                ManagerPage.this.startActivity(i);
            }
        });
        activate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uni=goller1.getText().toString();
                Toast.makeText(ManagerPage.this, "Succesfully Added", Toast.LENGTH_LONG).show();



            }
        });
    }
    private static final String[] Universities = new String[] {
            "Salda Lake","Van Lake", "Tuz Lake"


    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_manager_page, menu);
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
}
