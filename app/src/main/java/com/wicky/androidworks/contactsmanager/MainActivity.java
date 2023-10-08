package com.wicky.androidworks.contactsmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void handleClick(View view) {
        Log.d(TAG,"onClick: Clicked Add buttonToAddContacts");
        Intent intent = new Intent(MainActivity.this,AddContacts.class);
        startActivity(intent);
    }

    public void viewClick(View v) {
        Log.d(TAG,"onClick: Clicked View Contacts Button");
        Intent intent = new Intent(MainActivity.this,ViewContacts.class);
        startActivity(intent);
    }

}