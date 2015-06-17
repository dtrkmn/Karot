package com.example.casper.karot_system;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class AddCore extends ActionBarActivity {
    Button btnadd;
    EditText name;
    EditText lati;
    EditText longi;
    EditText depth;
    EditText date;
    EditText comment;
    EditText worker;
    Spinner type;
    LoginDatabaseAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_core);

        type = (Spinner)findViewById(R.id.options);
        ArrayAdapter<String> typearrayadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.types));
        type.setAdapter(typearrayadapter);
        adapter=new LoginDatabaseAdapter(this);
        adapter=adapter.open();

        name=(EditText)findViewById(R.id.core_name_text);
        lati=(EditText)findViewById(R.id.lati_text);
        longi=(EditText)findViewById(R.id.longi_test);
        date=(EditText)findViewById(R.id.date_text);
        comment=(EditText)findViewById(R.id.comment_text);
        worker=(EditText)findViewById(R.id.worker);
        depth=(EditText)findViewById(R.id.depth_text);








        btnadd=(Button)findViewById(R.id.addcore);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String corename=name.getText().toString();
                String corelati=lati.getText().toString();
                String corelongi=longi.getText().toString();
                String coretype=type.getSelectedItem().toString();
                String corecomment=comment.getText().toString();
                String coredate=date.getText().toString();
                String coreworker=worker.getText().toString();
                String coredepth=depth.getText().toString();

                if(corename.equals("")||coretype.equals("")||coredate.equals("")||coredepth.equals("")||corelati.equals("")||corelongi.equals("")){
                    Toast.makeText(AddCore.this, "Fill in the blanks", Toast.LENGTH_LONG).show();

                }
                else{
                    adapter.insertCore(corename,corelati,corelongi,coredepth,coredate,coretype, corecomment,coreworker);
                    Toast.makeText(AddCore.this ,"Succesfully added",Toast.LENGTH_LONG ).show();

                }


            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_core, menu);
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
