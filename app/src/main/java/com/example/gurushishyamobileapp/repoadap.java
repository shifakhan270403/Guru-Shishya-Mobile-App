package com.example.gurushishyamobileapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class repoadap extends RecyclerView.Adapter<repoadap.viewholder> {

    ArrayList<repomod> modobj;
    private Context ctx;
    dbhandlermain dataobj;

    public repoadap(ArrayList<repomod> modobj, Context ctx) {
        this.modobj = modobj;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ekreport,parent,false);
        return new viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.n.setText(modobj.get(position).getO());
        holder.u.setText(modobj.get(position).getI());
        holder.p.setText(modobj.get(position).getY());

    }

    @Override
    public int getItemCount() {
        return modobj.size();
    }

    class viewholder extends RecyclerView.ViewHolder{
        TextView n,u,p;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            n=(TextView) itemView.findViewById(R.id.n);
            u=(TextView) itemView.findViewById(R.id.u);
            p=(TextView) itemView.findViewById(R.id.p);
        }
    }
}
