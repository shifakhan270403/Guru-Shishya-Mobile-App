package com.example.gurushishyamobileapp;

import android.content.Context;
import android.content.SharedPreferences;

public class sharedprefforacc {

    private static sharedprefforacc instance;
    private static Context ctx;
    private static  final String SHARED_PREF_NAME="accinfo";
    private static final String NAM="nam";
    private static final String PHN="phn";
    private static final String TIT="title";
    private static final String EM="email";
    private static final String EDU="edu";
    private static final String EXP="exp";
    private static final String REQ="req";
    private static final String LANG="lang";
    private static final String ME="me";
    private static final String RG="rg";
    private sharedprefforacc(Context context) {
        ctx = context;
    }

    public static synchronized sharedprefforacc getInstance(Context context) {
        if (instance == null) {
            instance = new sharedprefforacc(context);
        }
        return instance;
    }

    public boolean detbharo(String n,String p,String t,String e,String s,String w,String r,String l,String m,String rg){
        SharedPreferences sp=ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString(NAM,n);
        editor.putString(PHN,p);
        editor.putString(TIT,t);
        editor.putString(EM,e);
        editor.putString(EDU,s);
        editor.putString(EXP,w);
        editor.putString(REQ,r);
        editor.putString(LANG,l);
        editor.putString(ME,m);
        editor.putString(RG,rg);
        editor.apply();
        return true;
    }


    public String getNam(){
        SharedPreferences sp=ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sp.getString(NAM,null);
    }

    public String getPhn(){
        SharedPreferences sp=ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sp.getString(PHN,null);
    }

    public String getTit(){
        SharedPreferences sp=ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sp.getString(TIT,null);
    }

    public String getEm(){
        SharedPreferences sp=ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sp.getString(EM,null);
    }
    public String getEdu(){
        SharedPreferences sp=ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sp.getString(EDU,null);
    }
    public String getExp(){
        SharedPreferences sp=ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sp.getString(EXP,null);
    }
    public String getReq(){
        SharedPreferences sp=ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sp.getString(REQ,null);
    }
    public String getLang(){
        SharedPreferences sp=ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sp.getString(LANG,null);
    }
    public String getMe(){
        SharedPreferences sp=ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sp.getString(ME,null);
    }
    public String getRg(){
        SharedPreferences sp=ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sp.getString(RG,null);
    }
}

