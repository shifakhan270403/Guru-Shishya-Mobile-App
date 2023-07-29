package com.example.gurushishyamobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class registerActivity extends AppCompatActivity {

    private ProgressBar pbar;
    private Button btn;
    private TextView signHereTxt;
    private EditText fname,uname,phone,passw;
    private RadioButton t,s;
    private String whois;
    private RadioGroup grp;
    private ProgressDialog pd;
    dbhandlermain db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fname = (EditText) findViewById(R.id.editTextPhone2);
        uname = (EditText) findViewById(R.id.editTextPhone3);
        passw = (EditText) findViewById(R.id.editTextTextPassword3);
        phone = (EditText) findViewById(R.id.editTextTextPassword2);
        pbar = (ProgressBar) findViewById(R.id.progressBar);
        btn = (Button) findViewById(R.id.button4);
        signHereTxt = (TextView) findViewById(R.id.textView5);
        t=(RadioButton) findViewById(R.id.radioButton);
        s=(RadioButton) findViewById(R.id.radioButton1);
        grp=(RadioGroup) findViewById(R.id.radioGroup);
        pd= new ProgressDialog(this);
        db=new dbhandlermain(this);


        signHereTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(registerActivity.this,loginActivity.class);
                startActivity(i);
                finish();
                Toast.makeText(registerActivity.this, "Loading Login Page", Toast.LENGTH_SHORT).show();
                pbar.setVisibility(View.INVISIBLE);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String f=fname.getText().toString();
                String u=uname.getText().toString();
                String ph=phone.getText().toString();
                String pw=passw.getText().toString();
                int selectedId = grp.getCheckedRadioButtonId();

                pbar.setVisibility(View.VISIBLE);
                if(selectedId==R.id.radioButton) {
                    whois = "teacher";
                }else{
                    whois="student";
                }
                if(f.isEmpty() && u.isEmpty() && ph.isEmpty() && pw.isEmpty()){
                    Toast.makeText(getApplicationContext(),"ALL FIELDS ARE REQUIRED !",Toast.LENGTH_SHORT).show();
                }
                else{
                    processInsert(f,u,ph,pw,whois);
                }
            }
        });
    }

    private void processInsert(String f, String u, String ph, String pw, String wh) {
        pd.setMessage("REGISTERING USER");
        pd.show();
        String r=db.addr(f,u,ph,pw,wh);
        if(r=="Data Successfully Inserted"){
            pd.hide();
            fname.setText("");
            uname.setText("");
            phone.setText("");
            passw.setText("");
            pbar.setVisibility(View.INVISIBLE);
            t.setChecked(false);
            s.setChecked(false);
            Toast.makeText(this, r, Toast.LENGTH_SHORT).show();
            Intent i= new Intent(this,loginActivity.class);
            startActivity(i);
        }

    }
}