package com.example.ecommerceapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;

import androidx.appcompat.app.AlertDialog;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (!isNetworkAvailable(context)){
            showNoInternetDialog(context);
        }
    }

    private boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    private void showNoInternetDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(R.layout.dailougebox);  // Set custom layout
        builder.setCancelable(false);  // Prevent dismissing by tapping outside

        final AlertDialog dialog = builder.create();
        dialog.show();

        dialog.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNetworkAvailable(context)) {
                    dialog.dismiss();
                }
            }
        });
//        AlertDialog dialog = builder.create();
//        dialog.show();
    }
}
