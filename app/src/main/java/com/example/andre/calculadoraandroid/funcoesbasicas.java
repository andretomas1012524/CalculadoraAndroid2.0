package com.example.andre.calculadoraandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class funcoesbasicas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcoesbasicas);
    }

    public void csomabasica(View view) {
        Intent intent = new Intent(this,calculobasico.class);
        startActivity(intent);
    }

    public void csubbasica(View view) {
        Intent intent= new Intent(this,calculobasico1.class);
        startActivity(intent);
    }

    public void cmultbasica(View view) {
        Intent intent = new Intent(this,calculobasico2.class);
        startActivity(intent);
    }

    public void cdivbasica(View view) {
        Intent intent = new Intent(this,calculobasico3.class);
        startActivity(intent);
    }

    public void cdivibasica(View view) {
        Intent intent = new Intent(this,calculobasico4.class);
        startActivity(intent);
    }

    public void cmedbasica(View view) {
        Intent intent = new Intent(this,calculobasico5.class);
        startActivity(intent);
    }

    public void cmfuncbasica(View view) {
        Intent intent = new Intent(this,maisfuncoesbasica.class);
        startActivity(intent);
    }
}
