package com.example.gurushishyamobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class reportActivity extends AppCompatActivity {

    RecyclerView rv;
    ArrayList<repomod> dataholder;
    FloatingActionButton b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        rv=(RecyclerView) findViewById(R.id.recview);
        rv.setLayoutManager(new LinearLayoutManager(this));
        dataholder=new ArrayList<>();

        Cursor c= new dbhandlermain(this).readrepo();
        while(c.moveToNext()){
            repomod obj=new repomod(c.getString(1),c.getString(2),c.getString(3));
            dataholder.add(obj);
        }
        repoadap a=new repoadap(dataholder,this);
        rv.setAdapter(a);
    }
}