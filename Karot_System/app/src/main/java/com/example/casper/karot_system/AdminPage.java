package com.example.casper.karot_system;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class AdminPage extends ActionBarActivity {
   Intent ben;
    String name;
    TextView admin_name;
    Intent add_uni_intent;
    Intent add_lake_intent;
    Intent home_page_intent;
    Button btn_add_uni;
    Button btn_add_lake;
    Button btn_home_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);
        ben=getIntent();
        name=ben.getStringExtra("send");
        admin_name=(TextView)findViewById(R.id.admin_text);
        admin_name.setText(name);

        add_uni_intent=new Intent(AdminPage.this,AddUnivesity.class);
        add_lake_intent=new Intent(AdminPage.this,add_lake.class);
        home_page_intent=new Intent(AdminPage.this, Map.class);

        btn_home_page=(Button)findViewById(R.id.btn_Homepage);
        btn_home_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminPage.this.startActivity(home_page_intent);
            }
        });

        btn_add_lake=(Button)findViewById(R.id.btn_addLake);
        btn_add_lake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminPage.this.startActivity(add_lake_intent);
            }
        });

        btn_add_uni=(Button)findViewById(R.id.btn_addUni);
        btn_add_uni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminPage.this.startActivity(add_uni_intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_admin_page, menu);
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
