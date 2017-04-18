package com.example.soundar.tte;

/**
 * Created by soundar on 13/2/17.
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EdgeEffect;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayContact extends Activity {
    int from_Where_I_Am_Coming = 0;
    private DBHelper mydb ;

    TextView name ;
    TextView phone;
    TextView email;
    TextView street;
    TextView place,aadharno,countno;
    int id_To_Update = 0;
    CheckBox ck;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contact);
        name = (TextView) findViewById(R.id.editTextName);
        phone = (TextView) findViewById(R.id.editTextPhone);
        email = (TextView) findViewById(R.id.editTextStreet);
        street = (TextView) findViewById(R.id.editTextEmail);
        place = (TextView) findViewById(R.id.editTextCity);
        aadharno = (TextView) findViewById(R.id.aadharno);
        countno = (TextView) findViewById(R.id.count);
        ck = (CheckBox) findViewById(R.id.checkbox);
        btn = (Button) findViewById(R.id.button2);
        ck.setVisibility(View.GONE);
        btn.setVisibility(View.GONE);
        mydb = new DBHelper(this);

        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            int Value = extras.getInt("id");

            if(Value>0){
                //means this is the view part not the add contact part.
                Cursor rs = mydb.getData(Value);
                id_To_Update = Value;
                rs.moveToFirst();

                String nam = rs.getString(rs.getColumnIndex(DBHelper.S1_COLUMN_NAME));
                String phon = rs.getString(rs.getColumnIndex(DBHelper.S1_COLUMN_PNRNUMER));
                String emai = rs.getString(rs.getColumnIndex(DBHelper.s1_COLUMN_AGE));
                String stree = rs.getString(rs.getColumnIndex(DBHelper.S1_COLUMN_GENDER));
                String plac = rs.getString(rs.getColumnIndex(DBHelper.S1_COLUMN_SEATNO));
                String aadhar = rs.getString(rs.getColumnIndex(DBHelper.S1_COLUMN_AADHARNO));
                String count = rs.getString(rs.getColumnIndex(DBHelper.S1_COLUMN_PASSEMGERCOUNT));

                if (!rs.isClosed())  {
                    rs.close();
                }
                Button b = (Button)findViewById(R.id.button1);
                b.setVisibility(View.INVISIBLE);
                ck.setVisibility(View.VISIBLE);
                btn.setVisibility(View.VISIBLE);

                name.setText((CharSequence)nam);
                name.setFocusable(false);
                name.setClickable(false);

                phone.setText((CharSequence)phon);
                phone.setFocusable(false);
                phone.setClickable(false);

                email.setText((CharSequence)emai);
                email.setFocusable(false);
                email.setClickable(false);

                street.setText((CharSequence)stree);
                street.setFocusable(false);
                street.setClickable(false);

                place.setText((CharSequence)plac);
                place.setFocusable(false);
                place.setClickable(false);

                aadharno.setText((CharSequence)aadhar);
                aadharno.setFocusable(false);
                aadharno.setClickable(false);

                countno.setText((CharSequence)count);
                countno.setFocusable(false);
                countno.setClickable(false);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        Bundle extras = getIntent().getExtras();

        if(extras !=null) {
            int Value = extras.getInt("id");
            if(Value>0){
                getMenuInflater().inflate(R.menu.display_contact, menu);
            } else{
                getMenuInflater().inflate(R.menu.main_menu,menu);
            }
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()) {
            case R.id.Edit_Contact:
                Button b = (Button)findViewById(R.id.button1);
                b.setVisibility(View.VISIBLE);
                name.setEnabled(false);
                name.setFocusableInTouchMode(false);
                name.setClickable(false);

                phone.setEnabled(false);
                phone.setFocusableInTouchMode(false);
                phone.setClickable(false);

                email.setEnabled(false);
                email.setFocusableInTouchMode(false);
                email.setClickable(false);

                street.setEnabled(false);
                street.setFocusableInTouchMode(false);
                street.setClickable(false);

                place.setEnabled(false);
                place.setFocusableInTouchMode(false);
                place.setClickable(false);

                aadharno.setEnabled(false);
                aadharno.setFocusableInTouchMode(false);
                aadharno.setClickable(false);

                countno.setEnabled(false);
                countno.setFocusableInTouchMode(false);
                countno.setClickable(false);

                return true;
            case R.id.Delete_Contact:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(R.string.deleteContact)
                        .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                mydb.deleteContact(id_To_Update);
                                Toast.makeText(getApplicationContext(), "Deleted Successfully",
                                        Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });

                AlertDialog d = builder.create();
                d.setTitle("Are you sure");
                d.show();

                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    public void ok (View v){

        Toast.makeText(getApplicationContext(),"You Suceessfully Updated",Toast.LENGTH_LONG).show();

    }

    public void run(View view) {
        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            int Value = extras.getInt("id");
            if(Value>0){
                if(mydb.updateContact(id_To_Update,name.getText().toString(),
                        phone.getText().toString(), email.getText().toString(),
                        street.getText().toString(), place.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),S1.class);
                    startActivity(intent);
                } else{
                    Toast.makeText(getApplicationContext(), "not Updated", Toast.LENGTH_SHORT).show();
                }
            } else{
                if(mydb.insertContact(name.getText().toString(), phone.getText().toString(),
                        email.getText().toString(), street.getText().toString(),
                        place.getText().toString(),aadharno.getText().toString(),countno.getText().toString())){
                    Toast.makeText(getApplicationContext(), "done",
                            Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(getApplicationContext(), "not done",
                            Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(getApplicationContext(),S1.class);
                startActivity(intent);
            }
        }
    }

    @Override
    public void onBackPressed() {

        back();
    }


    public void back() {

        Intent i = new Intent(DisplayContact.this, S1.class);
        startActivity(i);
        finish();
    }
}