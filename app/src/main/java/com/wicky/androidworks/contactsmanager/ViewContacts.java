package com.wicky.androidworks.contactsmanager;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewContacts extends AppCompatActivity {
    private EditText contactsListView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_contacts);
        contactsListView = findViewById(R.id.listView);
        viewContactList();

        }

    public void handleBack2(View v){
        Intent intent = new Intent(ViewContacts.this, MainActivity.class);
        startActivity(intent);

    }
    public void viewContactList(){
        Intent intent = getIntent();
        ArrayList<String> contactList = intent.getStringArrayListExtra("contactList");

        StringBuilder builder =new StringBuilder();

        for (String element : contactList) {
            builder.append(element).append("\n");
        }

        String items = builder.toString();

        contactsListView.setText(items);

    }





}
