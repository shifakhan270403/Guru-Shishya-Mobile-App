package com.example.gurushishyamobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class adminActivity extends AppCompatActivity {

    RecyclerView rv;
    ArrayList<modd> dataholder;
    FloatingActionButton b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        rv=(RecyclerView) findViewById(R.id.recview);
        rv.setLayoutManager(new LinearLayoutManager(this));
        dataholder=new ArrayList<>();
        b=(FloatingActionButton) findViewById(R.id.actbtn);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),reportActivity.class));
            }
        });
        Cursor c= new dbhandlermain(this).readdata();
        while(c.moveToNext()){
            modd obj=new modd(c.getString(1),c.getString(2),c.getString(3),c.getString(4),c.getString(5));
            dataholder.add(obj);
        }
        adapp a=new adapp(dataholder,this);
        rv.setAdapter(a);
    }
}