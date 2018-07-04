package com.example.andre.calculadoraandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Menuresultado11 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuresultado11);
        Intent intent = getIntent();

        long num1 = (long) intent.getDoubleExtra(calculocientifico.Numerocient1,0.00);
        long num2 = (long) intent.getDoubleExtra(calculocientifico.Numerocient2,0.00);


        if(num1 == 0.00 || num2 == 0.00){
            finish();
            return;
        }
        funcoescientificascalculo funcoescientificascalculo = new funcoescientificascalculo(num1,num2);

        TextView textViewres = (TextView)findViewById(R.id.textRes11);
        TextView textViewcient = (TextView)findViewById(R.id.textpartecientifica);
        double res = funcoescientificascalculo.soma();
        int index = (int) funcoescientificascalculo.contardigitos();
        if (res<999999999.99 && res>-999999999.99){
            textViewres.setText("Não foi possivel calcular, o resultado tem mais de dez digitos inteiros");
        }else {
            textViewres.setText(String.format("parte normal:%.2f", res));
        }
        textViewcient.setText(String.format("parte cientifica: parte normal(n,dd) * 10 ^ %d",index));

    }

    public void agredecimento(View view) {
        Intent intent = new Intent(this, MenuAgredicento.class);
        startActivity(intent);
    }
}
