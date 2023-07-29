package com.example.gurushishyamobileapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class createDialog extends AppCompatDialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        /*View v= new View(getActivity().getApplicationContext());
        RatingBar rb=(RatingBar) v.findViewById(R.id.ratingBar);*/
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("Rate user").setView(R.layout.ratedia).setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //RatingBar rb=(RatingBar) builder.findViewById(R.id.ratingBar);
                Toast.makeText(getActivity().getApplicationContext(), "Rate recorded", Toast.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }

}
