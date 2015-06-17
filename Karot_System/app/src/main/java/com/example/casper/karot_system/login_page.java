package com.example.casper.karot_system;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class login_page extends ActionBarActivity {
    EditText username_txt;
    EditText password_txt;
    Button btnLog;
    Intent intentAdmin;
    LoginDatabaseAdapter adapter;
    Button btn_login_member;
    Intent homepage;
    Intent managerpage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        username_txt= (EditText) findViewById(R.id.username);
        password_txt=(EditText) findViewById(R.id.password);
        btnLog =(Button) findViewById(R.id.btn_login);
        intentAdmin=new Intent(login_page.this, AdminPage.class);
        managerpage=new Intent(login_page.this, ManagerPage.class);



        homepage=new Intent(login_page.this, Map.class);
        btn_login_member=(Button) findViewById(R.id.login_as_member);
        adapter= new LoginDatabaseAdapter(this);
        adapter= adapter.open();
        //adapter.insertEntry("admin","admin","admin");



        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = username_txt.getText().toString();
                String password = password_txt.getText().toString();


                String storedPassword=adapter.getSingleEntry(username);
                String storedTYPE=adapter.getSingleEntry2(username);


                if(username.equals("")){
                    Toast.makeText(login_page.this, "Invalid Password or Username", Toast.LENGTH_LONG).show();



                }
                else if(password.equals(storedPassword)) {
                    if (storedTYPE.equals("admin")) {
                        intentAdmin.putExtra("send", username);
                        login_page.this.startActivity(intentAdmin);
                    } else if (storedTYPE.equals("manager")) {
                        managerpage.putExtra("send", username);
                        login_page.this.startActivity(managerpage);
                    }

                }
                else {
                    Toast.makeText(login_page.this, "Invalid Password or Username", Toast.LENGTH_LONG).show();
                }
            }
        });
        btn_login_member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login_page.this.startActivity(homepage);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_page, menu);
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
