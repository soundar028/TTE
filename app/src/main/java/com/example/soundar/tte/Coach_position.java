package com.example.soundar.tte;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by soundar on 7/2/17.
 */

    public class Coach_position extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coach_position);
    }

    public void SMS(View v) {


        Intent i = new Intent(Coach_position.this, Accoach.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onBackPressed() {

        back();
    }


    public void back() {

        Intent i = new Intent(Coach_position.this, Confirm_details.class);
        startActivity(i);
        finish();
    }
}
