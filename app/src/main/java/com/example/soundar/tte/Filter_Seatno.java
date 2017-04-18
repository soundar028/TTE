package com.example.soundar.tte;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by soundar on 18/2/17.
 */

public class Filter_Seatno extends Activity implements View.OnClickListener {
    Button btn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter_seatno);
        btn = (Button) findViewById(R.id.btnConfirm);
        btn.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(Filter_Seatno.this,DisplayContact.class);
        startActivity(i);
        finish();
        Toast.makeText(getApplicationContext(),"Clicked",Toast.LENGTH_LONG).show();
    }

}
