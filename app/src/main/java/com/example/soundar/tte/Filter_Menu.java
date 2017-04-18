package com.example.soundar.tte;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by soundar on 18/2/17.
 */

public class Filter_Menu extends Activity  {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filtermenu);

        }


   public void aadhar(View v){
        Intent intent = new Intent(Filter_Menu.this,Filter_aadhar.class);
        startActivity(intent);
        finish();
    }

    public  void name (View v){

        Intent intent = new Intent(Filter_Menu.this,Filter_Name.class);
        startActivity(intent);
        finish();

    }

    public void pnrnum (View v){

        Intent intent = new Intent(Filter_Menu.this,Filter_Pnrno.class);
        startActivity(intent);
        finish();

    }

    public void  seatno (View v){

        Intent intent = new Intent(Filter_Menu.this,Filter_Seatno.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(Filter_Menu.this,S1.class);
        startActivity(intent);
        finish();
    }



}
