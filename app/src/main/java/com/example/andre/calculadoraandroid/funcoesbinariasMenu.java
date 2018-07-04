package com.example.andre.calculadoraandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class funcoesbinariasMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcoesbinarias_menu);
    }

    public void adicao(View view) {
        Intent intent = new Intent(this,calculoBCD.class);
        startActivity(intent);
    }

    public void subtracao(View view) {
        Intent intent = new Intent(this,Menubin.class);
        startActivity(intent);
    }

    public void multiplicacao(View view) {
        Intent intent = new Intent(this,Menubin2.class);
        startActivity(intent);
    }


    public void divisao(View view) {
        Intent intent = new Intent(this,Menubin3.class);
        startActivity(intent);
    }
}
