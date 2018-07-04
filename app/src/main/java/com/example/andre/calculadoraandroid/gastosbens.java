package com.example.andre.calculadoraandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class gastosbens extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gastosbens);
    }

    public void Propinas(View view) {
        Intent intent = new Intent(this,Ativityrecicler.class);
        startActivity(intent);
    }

    public void IVA(View view) {
        Intent intent = new Intent(this,Ativityrecicler.class);
        startActivity(intent);
    }

    public void Gas(View view) {
        Intent intent = new Intent(this,Ativityrecicler.class);
        startActivity(intent);
    }

    public void Luz(View view) {
        Intent intent = new Intent(this,Ativityrecicler.class);
        startActivity(intent);
    }

    public void Agua(View view) {
        Intent intent = new Intent(this,Ativityrecicler.class);
        startActivity(intent);
    }

    public void IMI(View view) {
        Intent intent = new Intent(this,Ativityrecicler.class);
        startActivity(intent);
    }
}
