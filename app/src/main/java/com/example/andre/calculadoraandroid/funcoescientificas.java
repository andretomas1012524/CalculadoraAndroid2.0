package com.example.andre.calculadoraandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class funcoescientificas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcoescientificas);
    }

    public void scient(View view) {
        Intent intent = new Intent(this,calculocientifico.class);
        startActivity(intent);
    }

    public void subcient(View view) {
        Intent intent = new Intent(this,calculocientifico2.class);
        startActivity(intent);
    }

    public void multcient(View view) {
        Intent intent = new Intent(this,calculocientifco3.class);
        startActivity(intent);
    }

    public void divcient(View view) {
        Intent intent = new Intent(this,calculocientifico4.class);
        startActivity(intent);
    }

    public void divIcient(View view) {
        Intent intent = new Intent(this,calculocientifico5.class);
        startActivity(intent);
    }
}
