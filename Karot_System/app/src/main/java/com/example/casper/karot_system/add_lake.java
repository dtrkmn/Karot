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


public class add_lake extends ActionBarActivity {
    AutoCompleteTextView lake;
    EditText longi;
    EditText lati;
    Button btn_add;
    LoginDatabaseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lake);
        longi=(EditText)findViewById(R.id.long_txt);
        lati=(EditText)findViewById(R.id.lat_txt);
        lake=(AutoCompleteTextView)findViewById(R.id.lake_txt);
        ArrayAdapter<String> adaptor = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,Lakes);
        lake.setAdapter(adaptor);

        lake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String lakename=lake.getText().toString();

                if(lakename.equals("Salda Lake")){
                    longi.setText("29.6814");
                    lati.setText("37.5525");
                }
            }
        });

        btn_add=(Button)findViewById(R.id.add_register);
        adapter=new LoginDatabaseAdapter(this);
        adapter= adapter.open();

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=lake.getText().toString();
                String longt=longi.getText().toString();
                String latit=lati.getText().toString();
                if (name.equals("")){
                    Toast.makeText(add_lake.this, "Please Add Lake ",Toast.LENGTH_LONG).show();

                }else{
                //adapter.insertEntryLake(name, longt,latit);
                Toast.makeText(add_lake.this, "Successfully Added",Toast.LENGTH_LONG).show();}
            }
        });
    }
    private static final String[] Lakes = new String[] {
            "Salda Lake","Kucuk Çekmece Ladün"
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_lake, menu);
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
