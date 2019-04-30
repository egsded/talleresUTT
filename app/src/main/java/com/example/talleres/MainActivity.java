package com.example.talleres;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConnectivityManager ConnectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = ConnectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()){
            new CountDownTimer(5000,1000){
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {
                    Intent A = new Intent(MainActivity.this,iniciosesion.class);
                    startActivity(A);
                    finish();
                }
            }.start();
        }else{
            Toast.makeText(MainActivity.this,"Revisa tu conección a internet...",Toast.LENGTH_SHORT).show();
            new CountDownTimer(5000,1000){
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {
                    finishAffinity();
                }
            }.start();
        }
    }
}
