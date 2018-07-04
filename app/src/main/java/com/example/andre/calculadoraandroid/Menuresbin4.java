package com.example.andre.calculadoraandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Menuresbin4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuresbin4);
        Intent intent = getIntent();

        int num1 = (int) intent.getDoubleExtra(Menubin3.Numerobasico1,0.00);
        int num2 = (int) intent.getDoubleExtra(Menubin3.Numerobasico2,0.00);


        if(num1 == 0.00 || num2 == 0 ){
            finish();
            return;
        }
        funcoesbinariascalculo funcoesbinariascalculo = new funcoesbinariascalculo(num1,num2);
        String res = funcoesbinariascalculo.calculoBCDdiv();
        TextView textViewres = (TextView)findViewById(R.id.textRes19);
        textViewres.setText(" " + res);
    }

    public void agredecimento(View view) {
        Intent intent = new Intent(this,MenuAgredicento.class);
        startActivity(intent);
    }
}
