package com.example.soundar.tte;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1;
        b1 = (Button) findViewById(R.id.btnConfirm);
        b1.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {


        EditText etpass = (EditText) findViewById(R.id.editText1);
        String password = etpass.getText().toString();

        EditText etmobile = (EditText) findViewById(R.id.MobileNo);
        String mobileno = etmobile.getText().toString();


        if (mobileno.toString().trim().length() == 0)
        {

            etmobile.setError("Invalid Number");

        }

        if(password.toString().trim().length() == 0)
        {
            etpass.setError("Invalid Password");
        }


        else if (password.toString().equalsIgnoreCase("12345"))
        {
            Intent i = new Intent(getApplicationContext(), Train_detils.class);
            startActivity(i);
            setContentView(R.layout.activity_main);
        }

        else {
            Toast.makeText(getApplicationContext(), "User Name and Password not match!",
                    Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Exit");
        alert.setMessage("Do you want to exit?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(DialogInterface dialog, int which) {

                finishAffinity();

            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });
        AlertDialog alet1 = alert.create();
        alet1.show();

    }
}
