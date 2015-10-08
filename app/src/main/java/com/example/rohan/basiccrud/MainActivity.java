package com.example.rohan.basiccrud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    EditText vendor_name;
    EditText vendor_address;
    TextView display;
    DBHandler myDBHandle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vendor_name=(EditText) findViewById(R.id.vendorname);
        vendor_address=(EditText) findViewById(R.id.vendoraddress);
        myDBHandle= new DBHandler(this,null,null,1);
        printDatatbase();
    }

    //Add a button click
    public void addButtonClicked(View v){
        Vendors vendor=new Vendors(vendor_name.getText().toString(),vendor_address.getText().toString());
        myDBHandle.addVendor(vendor);
//        printDatatbase();
    }

    public void printDatatbase() {
        String dbString=myDBHandle.databaseToString();
        display.setText(dbString);
        vendor_name.setText("");
        vendor_address.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
