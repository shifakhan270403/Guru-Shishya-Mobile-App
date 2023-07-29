package com.example.gurushishyamobileapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapp extends RecyclerView.Adapter<adapp.viewholder> {
    ArrayList<modd> modobj;
    private Context ctx;
    dbhandlermain dataobj;

    public adapp(ArrayList<modd> modobj, Context ctx) {
        this.modobj = modobj;
        this.ctx = ctx;
    }


    @NonNull
    @Override
    public adapp.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.eachentry,parent,false);
        return new viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull adapp.viewholder holder, int position) {
        holder.n.setText(modobj.get(position).getF());
        holder.u.setText(modobj.get(position).getU());
        holder.p.setText(modobj.get(position).getP());
        holder.pw.setText(modobj.get(position).getPw());
        holder.pr.setText(modobj.get(position).getPr());

        holder.o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataobj=new dbhandlermain(ctx);
                PopupMenu p=new PopupMenu(ctx,holder.o);
                p.inflate(R.menu.options);
                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.delete:
                                dataobj.del(holder.n.getText().toString());
                                dataobj.delen(holder.u.getText().toString());
                                Toast.makeText(ctx, "User Deleted", Toast.LENGTH_SHORT).show();
                        }
                        return false;
                    }
                });
                p.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return modobj.size();
    }


    class viewholder extends RecyclerView.ViewHolder {
        TextView n,u,p,pw,pr,o;
        public viewholder(@NonNull View itemView) {
            super(itemView);

            n=(TextView) itemView.findViewById(R.id.n);
            u=(TextView) itemView.findViewById(R.id.u);
            p=(TextView) itemView.findViewById(R.id.p);
            pw=(TextView) itemView.findViewById(R.id.pw);
            pr=(TextView) itemView.findViewById(R.id.pr);
            o=(TextView) itemView.findViewById(R.id.op);
        }
    }
}
