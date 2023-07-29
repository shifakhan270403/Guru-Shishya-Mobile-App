package com.example.gurushishyamobileapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link samorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class samorFragment extends Fragment {
    LinearLayout el,ml,sl,vl,xl,al;
    View view;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public samorFragment() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment samorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static samorFragment newInstance(String param1, String param2) {
        samorFragment fragment = new samorFragment();
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
        view= inflater.inflate(R.layout.fragment_samor, container, false);
        el=(LinearLayout) view.findViewById(R.id.engclass);
        ml=(LinearLayout) view.findViewById(R.id.mathclass);
        sl=(LinearLayout) view.findViewById(R.id.sciclass);
        vl=(LinearLayout) view.findViewById(R.id.vxclass);
        xl=(LinearLayout) view.findViewById(R.id.exclass);
        al=(LinearLayout) view.findViewById(R.id.artclass);
        el.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),searchmedikhnewalaActivity.class));
            }
        });
        ml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),searchmedikhnewalaActivity.class));
            }
        });
        sl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),searchmedikhnewalaActivity.class));
            }
        });
        vl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),searchmedikhnewalaActivity.class));
            }
        });
        xl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),searchmedikhnewalaActivity.class));
            }
        });
        al.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),searchmedikhnewalaActivity.class));
            }
        });
        return view;

    }
}