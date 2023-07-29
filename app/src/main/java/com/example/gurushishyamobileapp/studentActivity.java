package com.example.gurushishyamobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class studentActivity extends AppCompatActivity {

    EditText n,p,t,e,s,w,r,l,m;
    RadioGroup rg;
    RadioButton en,ma,sc,vx,ex,ar;
    Button btn;
    dbhandlermain db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        n=(EditText) findViewById(R.id.fulname);
        p=(EditText) findViewById(R.id.phoneno);
        t=(EditText) findViewById(R.id.st);
        e=(EditText) findViewById(R.id.mail);
        s=(EditText) findViewById(R.id.edu);
        w=(EditText) findViewById(R.id.workie);
        r=(EditText) findViewById(R.id.req);
        l=(EditText) findViewById(R.id.lang);
        m=(EditText) findViewById(R.id.me);
        rg=(RadioGroup) findViewById(R.id.rg);
        en=(RadioButton) findViewById(R.id.en);
        ma=(RadioButton) findViewById(R.id.ma);
        sc=(RadioButton) findViewById(R.id.sc);
        vx=(RadioButton) findViewById(R.id.vx);
        ex=(RadioButton) findViewById(R.id.ex);
        ar=(RadioButton) findViewById(R.id.ar);
        btn=(Button) findViewById(R.id.button2);
        db= new dbhandlermain(this);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ne =n.getText().toString();
                String pe =p.getText().toString();
                String te=t.getText().toString();
                String ee=e.getText().toString();
                String se=s.getText().toString();
                String we=w.getText().toString();
                String re=r.getText().toString();
                String le=l.getText().toString();
                String me=m.getText().toString();


                int i=rg.getCheckedRadioButtonId();

                switch(i){
                    case R.id.en:
                        String rge=en.getText().toString();
                        String r=db.addEnr(ne,pe,te,ee,se,we,re,le,me,rge);
                        if(r=="Data Successfully Inserted"){
                            Toast.makeText(studentActivity.this, "Your response has been recorded", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),homeActivity.class));
                        }
                        else{
                            Toast.makeText(studentActivity.this, "There was some error, Please try again", Toast.LENGTH_SHORT).show();
                        }

                        break;
                    case R.id.ma:
                        String rg=ma.getText().toString();
                        String res=db.addEnr(ne,pe,te,ee,se,we,re,le,me,rg);
                        if(res=="Data Successfully Inserted"){
                            Toast.makeText(studentActivity.this, "Your response has been recorded", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),homeActivity.class));
                        }
                        else{
                            Toast.makeText(studentActivity.this, "There was some error, Please try again", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.sc:
                        String rgee=en.getText().toString();
                        String ret=db.addEnr(ne,pe,te,ee,se,we,re,le,me,rgee);
                        if(ret=="Data Successfully Inserted"){
                            Toast.makeText(studentActivity.this, "Your response has been recorded", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),homeActivity.class));
                        }
                        else{
                            Toast.makeText(studentActivity.this, "There was some error, Please try again", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.vx:
                        String rgeee=en.getText().toString();
                        String rett=db.addEnr(ne,pe,te,ee,se,we,re,le,me,rgeee);
                        if(rett=="Data Successfully Inserted"){
                            Toast.makeText(studentActivity.this, "Your response has been recorded", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),homeActivity.class));
                        }
                        else{
                            Toast.makeText(studentActivity.this, "There was some error, Please try again", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.ex:
                        String rgeeee=en.getText().toString();
                        String retttt=db.addEnr(ne,pe,te,ee,se,we,re,le,me,rgeeee);
                        if(retttt=="Data Successfully Inserted"){
                            Toast.makeText(studentActivity.this, "Your response has been recorded", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),homeActivity.class));
                        }
                        else{
                            Toast.makeText(studentActivity.this, "There was some error, Please try again", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.ar:
                        String rggee=en.getText().toString();
                        String reet=db.addEnr(ne,pe,te,ee,se,we,re,le,me,rggee);
                        if(reet=="Data Successfully Inserted"){
                            Toast.makeText(studentActivity.this, "Your response has been recorded", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),homeActivity.class));
                        }
                        else{
                            Toast.makeText(studentActivity.this, "There was some error, Please try again", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
                startActivity(new Intent(getApplicationContext(),homeActivity.class));
            }
        });
    }

}