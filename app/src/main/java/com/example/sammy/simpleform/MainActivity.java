package com.example.sammy.simpleform;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final EditText etFname = (EditText) findViewById(R.id.etFname);
        final EditText etLname = (EditText) findViewById(R.id.etLname);
        final EditText etEmail = (EditText) findViewById(R.id.etEmail);
        final EditText etAddress = (EditText) findViewById(R.id.etAddress);
        final Spinner spGender = (Spinner) findViewById(R.id.spGender);
        final Spinner spState = (Spinner) findViewById(R.id.spState);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
        final Button btnReset = (Button) findViewById(R.id.btnReset);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = etFname.getText().toString().trim();
                String lastname = etLname.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String address = etAddress.getText().toString().trim();
                String gender = spGender.getItemAtPosition(spGender.getSelectedItemPosition()).toString();
                String state = spState.getItemAtPosition(spState.getSelectedItemPosition()).toString();

                if (TextUtils.isEmpty(firstname)) {
                    Toast.makeText(getApplicationContext(), "First name cannot be empty", Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(lastname)) {
                    Toast.makeText(getApplicationContext(), "Last name cannot be empty", Toast.LENGTH_LONG).show();
                }
                else if (email.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Email cannot be empty", Toast.LENGTH_LONG).show();
                }
                else if (!email.contains("@")){
                    etEmail.setError("Invalid email format");
                }
                else if (address.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Address cannot be empty", Toast.LENGTH_LONG).show();
                }
                else if (gender.equalsIgnoreCase("Select gender")) {
                    Toast.makeText(getApplicationContext(), "Gender cannot be empty", Toast.LENGTH_LONG).show();
                }
                else if (state.equalsIgnoreCase("Select state")) {
                    Toast.makeText(getApplicationContext(), "State cannot be empty", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Form submission unsuccessful", Toast.LENGTH_LONG).show();
                }

                FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                });
            }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
        });
    }
}
