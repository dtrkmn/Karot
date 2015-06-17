package com.example.casper.karot_system;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddUnivesity extends ActionBarActivity {

    AutoCompleteTextView uni;
    EditText manager;
    Button  btn_add;
    LoginDatabaseAdapter adapter;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_univesity);
        uni=(AutoCompleteTextView)findViewById(R.id.university_txt);
        manager=(EditText)findViewById(R.id.mngr);
        password=(EditText)findViewById(R.id.mpass_text);

        btn_add=(Button)findViewById(R.id.add_register);
        adapter=new LoginDatabaseAdapter(this);
        adapter= adapter.open();
        ArrayAdapter<String> adaptor = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,Universities);
        uni.setAdapter(adaptor);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String university= uni.getText().toString();
                String managers=manager.getText().toString();
                String sifre=password.getText().toString();
                //Toast.makeText(AddUnivesity.this ,"Succesfully added",Toast.LENGTH_LONG ).show();
                if(university.equals("")||managers.equals("")||sifre.equals("")){
                    Toast.makeText(AddUnivesity.this, "Fill in the blanks", Toast.LENGTH_LONG).show();

                }
                else{
                adapter.insertEntryUNIVERSITY(university,managers,sifre);
                adapter.insertEntry(managers,sifre,"manager");
                Toast.makeText(AddUnivesity.this ,"Succesfully added",Toast.LENGTH_LONG ).show();
            }
            }
        });
    }

    private static final String[] Universities = new String[] {
            "Muğla Sıtkı Koçman Üniversitesi","İstanbul Teknik Üniversitesi", "Dokuz Eylül Üniversitesi"


    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_univesity, menu);
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
