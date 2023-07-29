package com.example.gurushishyamobileapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class inddadapp extends RecyclerView.Adapter<inddadapp.viewholder> {
    ArrayList<indmodd> modob;
    private Context ctx;
    dbhandlermain dobj;
    LinearLayout l;
    TextView u;

    public inddadapp(ArrayList<indmodd> modob, Context ctx) {
        this.modob=modob;
        this.ctx = ctx;
    }


    public void setfilteredlist(ArrayList<indmodd> fl){
        this.modob=fl;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public inddadapp.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.searchind,parent,false);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ctx.getApplicationContext(),userprofActivity.class);
                u=(TextView) v.findViewById(R.id.pr);
                String ss=u.getText().toString();
                i.putExtra("nome",ss);
                ctx.startActivity(i);
            }
        });
        return new viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull inddadapp.viewholder holder, int position) {
        indmodd m=modob.get(position);
        holder.pr.setText(m.getN());
        holder.u.setText(m.getT());
        holder.ed.setText(m.getS());

    }

    @Override
    public int getItemCount() {
        return modob.size();
    }

    /*@Override
    public Filter getFilter() {
        return newfilter;
    }
    private final Filter newfilter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            ArrayList<indmodd> filterednewlist=new ArrayList<>();
            if(charSequence == null || charSequence.length() == 0){
                filterednewlist.addAll(modob);
            }else{
                String filterpattern = charSequence.toString().toLowerCase().trim();
                for(indmodd additem : modob){
                    if(additem.getN().toLowerCase().contains(filterpattern))
                        filterednewlist.add(additem);
                }
            }
            FilterResults results=new FilterResults();
            results.values=filterednewlist;
            results.count=filterednewlist.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults results) {
            modobFilterone.clear();
            modobFilterone.addAll((ArrayList)results.values);
            notifyDataSetChanged();
        }
    };*/

    class viewholder extends RecyclerView.ViewHolder {
        TextView u,pr,ed;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            u=(TextView) itemView.findViewById(R.id.u);
            pr=(TextView) itemView.findViewById(R.id.pr);
            ed=(TextView) itemView.findViewById(R.id.ed);

        }
    }
}
