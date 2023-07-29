package com.example.gurushishyamobileapp;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link accFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class accFragment extends Fragment {

    TextView t1,t2,t3,t4,t5,t6,t7,t8;
    View view;
    Button btn;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public accFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment accFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static accFragment newInstance(String param1, String param2) {
        accFragment fragment = new accFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_acc, container, false);

        dbhandlermain dd=new dbhandlermain(getActivity().getApplicationContext());
        Cursor roo= dd.indacc(sharedpref.getInstance(getActivity().getApplicationContext()).getU());
        ArrayList<indmodd> m=new ArrayList<>();
         while(roo.moveToNext()){
            indmodd obj=new indmodd(roo.getString(1),roo.getString(2),roo.getString(3),roo.getString(4),roo.getString(5),roo.getString(6),roo.getString(7),roo.getString(8),roo.getString(9),roo.getString(10));
            m.add(obj);
        }

        t1=(TextView) view.findViewById(R.id.naamkyahai);
        t2=(TextView) view.findViewById(R.id.konhaitu);
        t3=(TextView) view.findViewById(R.id.aboutme);
        t4=(TextView) view.findViewById(R.id.kyadhundrahehai);
        t5=(TextView) view.findViewById(R.id.kyaatahai);
        t6=(TextView) view.findViewById(R.id.experiencebata);
        t7=(TextView) view.findViewById(R.id.kyamangtahai);
        t8=(TextView) view.findViewById(R.id.lang);
        //btn=(Button) view.findViewById(R.id.button);

        /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String no=m.get(0).getP();
                String wpurl="https://wa.me/+91"+no+"?text=Helloo?";
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(wpurl));
                startActivity(i);
            }
        });*/

        t1.setText(m.get(0).getN());
        t2.setText(m.get(0).getT());
        t3.setText(m.get(0).getM());
        t4.setText(m.get(0).getS());
        t5.setText(m.get(0).getW());
        t6.setText(m.get(0).getRg());
        t7.setText(m.get(0).getR());
        t8.setText(m.get(0).getL());
        return view;
    }
}