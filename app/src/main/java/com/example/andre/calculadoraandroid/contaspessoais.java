package com.example.andre.calculadoraandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class contaspessoais extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contaspessoais);

    }

    public void Combustivel(View view) {
        Intent intent = new Intent(this,Ativityrecicler.class);
        startActivity(intent);
    }

    public void gastosbens(View view) {
        Intent intent = new Intent(this, gastosbens.class);
        startActivity(intent);
    }

    public void vistageral(View view) {
        Intent intent = new Intent(this,Ativityrecicler.class);
        startActivity(intent);
    }
}
