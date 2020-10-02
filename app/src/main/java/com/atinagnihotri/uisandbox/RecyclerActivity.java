package com.atinagnihotri.uisandbox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    RecyclerView contactsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        contactsRecyclerView = findViewById(R.id.contactsRecyclerView);

        ArrayList<Contact> contacts = new ArrayList<>();

        contacts.add(new Contact("John Shepard", "cdr.shepard@anmail.org", "https://vignette.wikia.nocookie.net/massfanon/images/2/2c/WpPh0Mlckaov-0.png"));
        contacts.add(new Contact("Firelord Zuko", "firelord@firenation.com", "https://64.media.tumblr.com/342efcc204d04788e53d02c9118fae2c/tumblr_ocdu0yb7tr1sjodmuo1_1280.png"));
        contacts.add(new Contact("Rick Sanchez", "c_137@wubaluba.dubdub", "https://upload.wikimedia.org/wikipedia/en/a/a6/Rick_Sanchez.png"));
        contacts.add(new Contact("Eleanor Shellstrop", "shell.drops@good.place", "https://img.nbc.com/sites/nbcunbc/files/files/images/2016/9/01/2016-0823-TheGoodPlace-KristenBell-1050x1050-CV.jpg"));
        contacts.add(new Contact("Elvi Okoye", "elvi.oky@charterroyal.com", "https://vignette.wikia.nocookie.net/expanse/images/b/b7/Dy5Vi_MWkAQcykr.jpg_large.jpg"));

        ContactsRecyclerViewAdapter adapter = new ContactsRecyclerViewAdapter(this);
        adapter.setContacts(contacts);

        contactsRecyclerView.setAdapter(adapter);
//        contactsRecyclerView.setLayoutManager(new LinearLayoutManager(this)); // Vertical Linear
//        contactsRecyclerView.setLayoutManager(new LinearLayoutManager(
//                this,
//                LinearLayoutManager.HORIZONTAL,
//                false)
//        ); // Horizontal Linear
        contactsRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }
}