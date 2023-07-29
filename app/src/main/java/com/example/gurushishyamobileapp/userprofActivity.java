package com.example.gurushishyamobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class userprofActivity extends AppCompatActivity {

    TextView t1,t2,t3,t4,t5,t6,t7,t8,tr;
    String tn;
    Button btn,btnR,btnRe,kit,rit;
    EditText e1,e2;
    Dialog rankd,repd;
    RatingBar rbar;
    dbhandlermain db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprof);

        dbhandlermain dd=new dbhandlermain(getApplicationContext());

        ArrayList<indmodd> m=new ArrayList<>();
        String s=getIntent().getStringExtra("nome");
        Cursor roo= dd.indacc(s);
        while(roo.moveToNext()){
            indmodd obj=new indmodd(roo.getString(1),roo.getString(2),roo.getString(3),roo.getString(4),roo.getString(5),roo.getString(6),roo.getString(7),roo.getString(8),roo.getString(9),roo.getString(10));
            m.add(obj);
        }
        

        t1=(TextView) findViewById(R.id.naamkyahai);
        t2=(TextView) findViewById(R.id.konhaitu);
        t3=(TextView) findViewById(R.id.aboutme);
        t4=(TextView) findViewById(R.id.kyadhundrahehai);
        t5=(TextView) findViewById(R.id.kyaatahai);
        t6=(TextView) findViewById(R.id.experiencebata);
        t7=(TextView) findViewById(R.id.kyamangtahai);
        t8=(TextView) findViewById(R.id.lang);
        tr=(TextView) findViewById(R.id.ratingkitna);
        btn=(Button) findViewById(R.id.button);
        btnR=(Button) findViewById(R.id.buttonrate);
        btnRe=(Button) findViewById(R.id.buttonreport);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String no=m.get(0).getP();
                String wpurl="https://wa.me/+91"+no+"?text=Helloo?";
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(wpurl));
                startActivity(i);
            }
        });

        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*createDialog di=new createDialog();
                di.show(getSupportFragmentManager(), "createDialog");*/
                rankd=new Dialog(userprofActivity.this);
                rankd.setContentView(R.layout.ratedia);
                rankd.setCancelable(true);
                rbar=(RatingBar) rankd.findViewById(R.id.ratingBar);
                kit=(Button) rankd.findViewById(R.id.btnratekiya);
                kit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        rankd.dismiss();
                        Toast.makeText(getApplicationContext(), "Rate Recorded", Toast.LENGTH_SHORT).show();
                        tr.setText(""+rbar.getRating()+" Stars");
                    }
                });
                rankd.show();

            }
        });

        btnRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repd=new Dialog(userprofActivity.this);
                repd.setContentView(R.layout.reportkaro);
                repd.setCancelable(true);
                rit=(Button) repd.findViewById(R.id.btnrepokiya);
                e1=(EditText) repd.findViewById(R.id.reponam);
                e2=(EditText) repd.findViewById(R.id.msg);

                rit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        db=new dbhandlermain(getApplicationContext());
                        tn=sharedpref.getInstance(getApplicationContext()).getU();
                        String r=db.addrepo(tn,e1.getText().toString(),e2.getText().toString());
                        if(r=="Data Successfully Inserted"){
                            repd.dismiss();
                            Toast.makeText(getApplicationContext(), "Report Recorded", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            repd.dismiss();
                            Toast.makeText(getApplicationContext(), "There was some problem in reporting, Please try again after some time", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                repd.show();
            }
        });
        t1.setText(m.get(0).getN());
        t2.setText(m.get(0).getT());
        t3.setText(m.get(0).getM());
        t4.setText(m.get(0).getS());
        t5.setText(m.get(0).getW());
        t6.setText(m.get(0).getRg());
        t7.setText(m.get(0).getR());
        t8.setText(m.get(0).getL());
    }
}