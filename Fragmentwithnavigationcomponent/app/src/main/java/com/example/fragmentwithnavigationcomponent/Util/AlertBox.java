package com.example.fragmentwithnavigationcomponent.Util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.example.fragmentwithnavigationcomponent.Model.User;

public class AlertBox {
    User user;

    public void showAlert(Context context ,String Error ) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(""+Error);
        builder.setTitle("Information!");

        builder.setCancelable(false);

        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog,int which) {
                    dialog.cancel();
                }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
