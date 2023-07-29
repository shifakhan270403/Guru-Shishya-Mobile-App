package com.example.gurushishyamobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class searchmedikhnewalaActivity extends AppCompatActivity {

    RecyclerView rv;
    ArrayList<indmodd> dataholder;
    inddadapp a;
    SearchView s;
    LinearLayout l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchmedikhnewala);

        rv=(RecyclerView) findViewById(R.id.review);
        rv.setLayoutManager(new LinearLayoutManager(this));
        dataholder=new ArrayList<>();
        s=findViewById(R.id.sv);
        l=(LinearLayout) findViewById(R.id.clickyy);



        s.clearFocus();
        s.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filter(s);
                return false;
            }
        });

        Cursor c= new dbhandlermain(this).readEndata();
        while(c.moveToNext()){
            indmodd obj=new indmodd(c.getString(1),c.getString(2),c.getString(3),c.getString(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),c.getString(10));
            dataholder.add(obj);
        }
        a=new inddadapp(dataholder,this);
        rv.setAdapter(a);
        /*rv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
    }

   private void filter(String s) {
        ArrayList<indmodd> filteredlist=new ArrayList<>();
        for(indmodd item:dataholder){
            if(item.getN().toLowerCase().contains(s.toLowerCase())){
                filteredlist.add(item);
            }
        }
        if(filteredlist.isEmpty()){
            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
        }
        else{
            a.setfilteredlist(filteredlist);
        }
    }
}