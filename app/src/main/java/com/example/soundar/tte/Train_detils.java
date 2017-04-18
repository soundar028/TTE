package com.example.soundar.tte;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;

/**
 * Created by soundar on 7/2/17.
 */

public class Train_detils extends Activity{

    static final int DATE_PICKER_ID = 1111;
    Button date;
    String datepicked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train_details);
        date = (Button) findViewById(R.id.numberedt);
    }


    public void PickDate(View v) {

        showDialog(DATE_PICKER_ID);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_PICKER_ID:

                final Calendar c = Calendar.getInstance(Locale.ENGLISH);

                // mYear = c.get(Calendar.YEAR);
                // mMonth = c.get(Calendar.MONTH);
                // mDay = c.get(Calendar.DAY_OF_MONTH);

                // open datepicker dialog.
                // set date picker for current date
                // add pickerListener listner to date picker
                return new DatePickerDialog(this, pickerListener,
                        c.get(Calendar.YEAR), c.get(Calendar.MONTH),
                        c.get(Calendar.DAY_OF_MONTH));
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener pickerListener = new DatePickerDialog.OnDateSetListener() {

        private int year;
        private int month;
        private int day;

        // when dialog box is closed, below method will be called.
        @Override
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {

            year = selectedYear;
            month = selectedMonth;
            day = selectedDay;

            // Show selected date
            // txtBirthDate.setText(new StringBuilder().append(month + 1)
            // .append("-").append(day).append("-").append(year)
            // .append(" "));
            String dummy = monthchange(day) + "-" + monthchange(month+1) + "-"
                    + year;

            date.setText(dummy);

            datepicked =monthchange(day) +"/"+ monthchange(month+1)+ "/"+year;

        }
    };

    public String monthchange(int vl) {
        String val = "";
        if (vl < 10) {

            val = "0" + String.valueOf(vl);
        } else {

            val = String.valueOf(vl);
        }

        return val;

    }

    public void Confirm(View v){
        if (date.getText().toString().equals("Pick Date")||date.getText().toString().equals("")) {

            Toast.makeText(getApplicationContext(), "Please pick the date",
                    Toast.LENGTH_LONG).show();
        }

        else {
            Intent i = new Intent(Train_detils.this,Confirm_details.class);
            startActivity(i);
            finish();
        }
    }



    @Override
    public void onBackPressed() {

        back();
    }


    public void back() {

        Intent i = new Intent(Train_detils.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
