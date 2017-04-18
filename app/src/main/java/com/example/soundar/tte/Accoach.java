package com.example.soundar.tte;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by soundar on 7/2/17.
 */

public class Accoach extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accoach);

    }

    public void S1(View view){
        Intent intent = new Intent(Accoach.this,S1.class);
        startActivity(intent);
        finish();
    }


    @Override
    public void onBackPressed() {

        back();
    }


    public void back() {

        Intent i = new Intent(Accoach.this, Coach_position.class);
        startActivity(i);
        finish();
    }

}
