package com.example.andre.calculadoraandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Menuresultado10 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuresultado10);
        Intent intent = getIntent();

        double num1 = intent.getDoubleExtra(calculobasico9.Numerobasico1,0.00);
        double num2 = intent.getDoubleExtra(calculobasico9.Numerobasico2,0.00);


        if(num1 == 0.00){
            finish();
            return;
        }
        funcoesbasicascalculo Funcoesbasicas = new funcoesbasicascalculo(num1,num2);

        TextView textViewres = (TextView)findViewById(R.id.textRes10);
        double res = Funcoesbasicas.fatorial();
        if (res>999999999.99 || res<-999999999.99){
            textViewres.setText("Não foi possivel calcular, o resultado tem mais de dez digitos inteiros");
        }else {
            textViewres.setText(String.format("%.2f", res));
        }
    }

    public void agredecimento(View view) {
        Intent intent = new Intent(this,MenuAgredicento.class);
        startActivity(intent);
    }
}
