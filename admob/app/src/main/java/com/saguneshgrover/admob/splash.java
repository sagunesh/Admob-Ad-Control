package com.saguneshgrover.admob;

/*---
App Author : Sagunesh Grover
Website : www.saguneshgrover.com

--- */

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONException;
import org.json.JSONObject;

public class splash extends AppCompatActivity {


    DatabaseReference rootRef,demoRef;
    //TextView demoValue,demoValuea;

    public static final String MY_PREFS_NAME = "admobads";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

//        demoValuea = (TextView) findViewById(R.id.tvValue1);
//        demoValue = (TextView) findViewById(R.id.tvValue);

        new PrefetchData().execute();









    }


    private class PrefetchData extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // before making http calls

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            /*
             * Will make http call here This call will download required data
             * before launching the app
             * example:
             * 1. Downloading and storing in SQLite
             * 2. Downloading images
             * 3. Fetching and parsing the xml / json
             * 4. Sending device information to server
             * 5. etc.,
             */


            //database reference pointing to root of database
                    rootRef = FirebaseDatabase.getInstance().getReference();
            //database reference pointing to demo node
            demoRef = rootRef.child("demo");


            //downloading banner ad
            demoRef.child("badd").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    //demoValue.setText(value);
                    //Shared preference
                    SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                    editor.putString("badd", value);
                    editor.apply();


                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });
            //downloading interstial add
            demoRef.child("iadd").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    //demoValuea.setText(value);
                    //Shared preference
                    SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                    editor.putString("iadd", value);
                    editor.apply();
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });


            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // After completing http call
            // will close this activity and lauch main activity
            Intent i = new Intent(splash.this, MainActivity.class);

            startActivity(i);

            // close this activity
            finish();
        }

    }
}
