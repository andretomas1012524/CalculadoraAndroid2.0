package com.example.andre.calculadoraandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Funcoesbinariaspred extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcoesbinariaspred);
    }

    public void adicaobinpred(View view) {
        Intent intent = new Intent(this,Menubinpred.class);
        startActivity(intent);
    }

    public void subtracaobinpred(View view) {
        Intent intent = new Intent(this,Menubinpred2.class);
        startActivity(intent);
    }

    public void multiplicacaobinpred(View view) {
        Intent intent = new Intent(this,Menubinpred3.class);
        startActivity(intent);
    }

    public void divisaobinpred(View view) {
        Intent intent = new Intent(this,Menubinpred4.class);
        startActivity(intent);
    }
}
