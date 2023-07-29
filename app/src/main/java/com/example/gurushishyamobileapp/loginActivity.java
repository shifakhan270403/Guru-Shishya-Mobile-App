package com.example.gurushishyamobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class loginActivity extends AppCompatActivity {

    private EditText user,pass;
    private TextView loghere;
    private Button logBtn;
    private ProgressBar lbar;
    private TextView admintxt;
    private ProgressDialog pd;
    private String noom;
    dbhandlermain db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if(sharedpref.getInstance(this).isloggedin()){
            finish();
            Intent i=new Intent(this,homeActivity.class);
            startActivity(i);
            return;
        }

        user = (EditText) findViewById(R.id.editTextPhone3);
        pass = (EditText) findViewById(R.id.editTextTextPassword3);
        loghere = (TextView) findViewById(R.id.textView5);
        logBtn = (Button) findViewById(R.id.button4);
        lbar = (ProgressBar) findViewById(R.id.progressBar);
        admintxt =(TextView) findViewById(R.id.textView);
        pd =new ProgressDialog(this);
        pd.setMessage("Please Wait.....");
        db=new dbhandlermain(this);

        loghere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent is = new Intent(loginActivity.this,registerActivity.class);
                startActivity(is);
                Toast.makeText(loginActivity.this, "Loading Sign In Page", Toast.LENGTH_SHORT).show();
                lbar.setVisibility(View.INVISIBLE);
            }
        });

        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lbar.setVisibility(View.VISIBLE);
                userlogin();
            }
        });

        admintxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(loginActivity.this,loginActivity.class);
                startActivity(i);
            }
        });
    }

    private void userlogin() {
        String u = user.getText().toString();
        String p = pass.getText().toString();
        if(u.equals("admin") & p.equals("admin")){
            startActivity(new Intent(this,adminActivity.class));

        }
        else{
            Boolean res=db.searchu(u,p);
            if(res == true){
                Toast.makeText(this, "Login Successfull", Toast.LENGTH_SHORT).show();
                sharedpref.getInstance(getApplicationContext())
                        .userlogin(u,p);

                startActivity(new Intent(this,studentActivity.class));
            }else{
                Toast.makeText(this, "No such user exists, Please Sign in first", Toast.LENGTH_SHORT).show();
            }
        }

    }
}