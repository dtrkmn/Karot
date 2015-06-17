package com.example.casper.karot_system;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;


public class HomePage extends ActionBarActivity {
    ImageButton btn_add_core;
    ImageButton btn_view_core;
    ImageButton btn_upload_data;
    Intent ben;
    String controls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        btn_add_core=(ImageButton)findViewById(R.id.add_core);
        btn_view_core=(ImageButton)findViewById(R.id.show_cores);
        btn_upload_data=(ImageButton)findViewById(R.id.upload);


        btn_upload_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent upload=new Intent(HomePage.this,UploadData.class);
                HomePage.this.startActivity(upload);
                Toast.makeText(HomePage.this, controls, Toast.LENGTH_LONG).show();

            }
        });
        btn_view_core.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toaddcore =new Intent(HomePage.this,ViewCores.class);
                HomePage.this.startActivity(toaddcore);
            }
        });
        btn_add_core.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toddcore=new Intent(HomePage.this,AddCore.class);
                HomePage.this.startActivity(toddcore);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_page, menu);
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
