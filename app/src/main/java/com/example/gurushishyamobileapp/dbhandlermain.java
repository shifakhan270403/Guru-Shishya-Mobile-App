package com.example.gurushishyamobileapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbhandlermain extends SQLiteOpenHelper {
    private static final String DB_N="guruShishyaDatabase";
    private static final String TB_N="log";
    private static final String E_TB="etab";
    private static final String R_TB="rtab";
    public dbhandlermain(@Nullable Context context) {
        super(context, DB_N, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String q="create table "+TB_N+" (id integer primary key autoincrement,fname text,uname text,phn text,pass text,who text)";
        sqLiteDatabase.execSQL(q);
        String qu="create table "+E_TB+" (id integer primary key autoincrement,nam text,phn text,title text,email text,edu text,exp text,req text,lang text,me text,rg text)";
        sqLiteDatabase.execSQL(qu);
        String que="create table "+R_TB+" (id integer primary key autoincrement,kon text,kisse text,kyu text)";
        sqLiteDatabase.execSQL(que);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String q="drop table if exists "+TB_N;
        sqLiteDatabase.execSQL(q);
        String qu="drop table if exists "+E_TB;
        sqLiteDatabase.execSQL(qu);
        String que="drop table if exists "+R_TB;
        sqLiteDatabase.execSQL(que);
        onCreate(sqLiteDatabase);
    }
    public String addr(String f,String u,String p,String ps,String w){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("fname",f);
        cv.put("uname",u);
        cv.put("phn",p);
        cv.put("pass",ps);
        cv.put("who",w);
        Float res =Float.valueOf(db.insert(TB_N,null,cv)) ;
        if(res==-1){
            return "Insertion Failed";
        }else{
            return "Data Successfully Inserted";
        }
    }
    public Boolean searchu(String u,String p){
        String[] col={"id"};
        String sel ="uname = ? AND pass = ?";
        String[] args={u,p};
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c= db.query(TB_N,col,sel,args,null,null,null);
        int count=c.getCount();
        c.close();
        if(count>0){
            return true;
        }else{
            return false;
        }
    }
    public Cursor indacc(String n){
        String[] col={"*"};
        String sel ="nam = ?";
        String[] args={n};
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c= db.rawQuery("select * from "+E_TB+" where nam = ?",args);
        return c;
    }
    public Cursor searcheng(String n){
        String[] col={"*"};
        String sel ="nam=?";
        String[] args={n};
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c= db.query(E_TB,col,sel,args,null,null,null);
        return c;
    }
    public Cursor readdata(){
        SQLiteDatabase db=this.getWritableDatabase();
        String query="select * from "+TB_N+" order by id desc";
        Cursor c=db.rawQuery(query,null);
        return c;
    }
    public void del(String n){
        SQLiteDatabase db= this.getWritableDatabase();
        db.delete(TB_N,"fname=?",new String[]{n});
    }
    public String addEnr(String n,String p,String t,String e,String s,String w,String r,String l,String m,String rg){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nam",n);
        cv.put("phn",p);
        cv.put("title",t);
        cv.put("email",e);
        cv.put("edu",s);
        cv.put("exp",w);
        cv.put("req",r);
        cv.put("lang",l);
        cv.put("me",m);
        cv.put("rg",rg);
        Float res =Float.valueOf(db.insert(E_TB,null,cv)) ;
        if(res==-1){
            return "Insertion Failed";
        }else{
            return "Data Successfully Inserted";
        }
    }
    public Cursor readEndata(){
        SQLiteDatabase db=this.getWritableDatabase();
        String query="select * from "+E_TB+" order by id desc";
        Cursor c=db.rawQuery(query,null);
        return c;
    }
    public void delen(String n){
        SQLiteDatabase db= this.getWritableDatabase();
        db.delete(E_TB,"nam=?",new String[]{n});
    }
    public String addrepo(String o,String i,String y){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("kon",o);
        cv.put("kisse",i);
        cv.put("kyu",y);
        Float res =Float.valueOf(db.insert(R_TB,null,cv)) ;
        if(res==-1){
            return "Insertion Failed";
        }else{
            return "Data Successfully Inserted";
        }
    }
    public Cursor readrepo(){
        SQLiteDatabase db=this.getWritableDatabase();
        String query="select * from "+R_TB+" order by id desc";
        Cursor c=db.rawQuery(query,null);
        return c;
    }
}
