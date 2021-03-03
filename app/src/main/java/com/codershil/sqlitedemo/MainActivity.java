package com.codershil.sqlitedemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.codershil.sqlitedemo.data.MyDbHandler;
import com.codershil.sqlitedemo.models.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = findViewById(R.id.listView);
        MyDbHandler db = new MyDbHandler(MainActivity.this);



//        // Creating a contact object for the db
//        Contact harry = new Contact();
//        harry.setPhoneNumber("9090909090");
//        harry.setName("Harry");
//
//        // Adding a contact to the db
//        db.addContact(harry);
//
//        // Creating a contact object for the db
//        Contact larry = new Contact();
//        larry.setPhoneNumber("9090459090");
//        larry.setName("Larry");
//
//        // Adding a contact to the db
//        db.addContact(larry);
//
//        // Creating a contact object for the db
//        Contact tehri = new Contact();
//        tehri.setPhoneNumber("9090675409");
//        tehri.setName("Tehri");
//
//        // Adding a contact to the db
//        db.addContact(tehri);
//
//        tehri.setId(2);
//        tehri.setName("tehri new  new  newname");
//        tehri.setPhoneNumber("0000000000000000");
//        db.updateContact(tehri);
//
//        db.deleteContactById(5);
//        db.deleteContactById(1);
//        db.deleteContactById(2);

        ArrayList<String> contacts = new ArrayList<>();

        ArrayList<Contact> allContacts = db.getAllContacts();
        for (Contact contact : allContacts){
            Log.d("database","id :"+contact.getId()+" name : "+contact.getName()+
                    " phone :"+contact.getPhoneNumber());

            contacts.add(contact.getName()+ " (" + contact.getPhoneNumber() + "  )");

        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,contacts);
        mListView.setAdapter(arrayAdapter);

        // this will log the number of contacts in the database
//        Log.d("database1","you have "+db.getCount()+ " contacts in your app");

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "item "+position +" is "+ contacts.get(position), Toast.LENGTH_SHORT).show();
            }
        });


    }
}