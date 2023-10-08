package com.wicky.androidworks.contactsmanager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AddContacts extends AppCompatActivity {
    private EditText contactName;
    private EditText contactNumber;

    private TextView savedName;
    private TextView savedNumber;

    ArrayList<String> contactList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcontacts);
        contactName = (EditText)findViewById(R.id.nameInput);
        contactNumber = (EditText) findViewById(R.id.numberInput);
        savedName =(TextView) findViewById(R.id.nameView);
        savedNumber=(TextView) findViewById(R.id.numberView);


    }
    public void handleBack(View view){
        sendDataToOtherActivity();
        Intent intent = new Intent(AddContacts.this, MainActivity.class);
        startActivity(intent);

    }


    public void handleSave(View v){
        String name = contactName.getText().toString();
        String number= contactNumber.getText().toString();
        String data = "Name: "+ name + "\nNumber: "+number;
        contactList.add(data);
        Context context = getApplicationContext();
        CharSequence text = "Contact Saved";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context,text,duration);
        toast.show();
        StringBuilder builder =new StringBuilder();
        for (String element : contactList) {
            if (element.contains(name)) {
                builder.append(element).append("\n");
            }
        }
         savedName.setText(builder.toString());
        contactName.setText("");
        contactNumber.setText("");


    }


    private void sendDataToOtherActivity() {
        // Create an intent
        Intent intent = new Intent(this, ViewContacts.class);

        // Get the contact data (for example, from your view)
        intent.putStringArrayListExtra("contactList",contactList);

        // Start the ReceiverActivity with the intent
        startActivity(intent);
    }




}
