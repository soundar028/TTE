package com.example.soundar.tte;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by soundar on 17/2/17.
 */

public class Confirm_details extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.traindetails);
    }


    public void Confirm(View v) {

        Intent i = new Intent(Confirm_details.this,Coach_position.class);
        startActivity(i);
        finish();
    }


    @Override
    public void onBackPressed() {

        back();
    }


    public void back() {

        Intent i = new Intent(Confirm_details.this, Train_detils.class);
        startActivity(i);
        finish();
    }
}
