package com.example.gurushishyamobileapp;

import android.content.Context;
import android.content.SharedPreferences;

public class sharedpref {
    private static Context ctx;
    public static sharedpref ins;
    private static final String SH_PREF_N="mys1";
    private static final String F_NAME="fname";
    private static final String U_NAME="uname";
    private static final String PHONE="phn";
    private static final String PASSW="pass";
    private static final String WHO="who";
    private static final String UID="id";

    private sharedpref(Context con){ ctx=con;}

    public static synchronized sharedpref getInstance(Context context) {
        if (ins == null) {
            ins = new sharedpref(context);
        }
        return ins;
    }

    public String getU(){
        SharedPreferences sp=ctx.getSharedPreferences(SH_PREF_N,Context.MODE_PRIVATE);
        return sp.getString(U_NAME,null);
    }

    public boolean userlogin(String uname,String pas){
        SharedPreferences sp=ctx.getSharedPreferences(SH_PREF_N,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString(U_NAME,uname);
        editor.putString(PASSW,pas);
        editor.apply();
        return true;
    }

    public boolean isloggedin(){
        SharedPreferences sp=ctx.getSharedPreferences(SH_PREF_N,Context.MODE_PRIVATE);
        if(sp.getString(U_NAME,null) !=null){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean logout(){
        SharedPreferences sp=ctx.getSharedPreferences(SH_PREF_N,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.clear();
        editor.apply();
        return true;
    }
}
