package com.example.andre.calculadoraandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Menuresultado13 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuresultado13);
        Intent intent = getIntent();

        long num1 = (long) intent.getDoubleExtra(calculocientifco3.Numerocient1,0.00);
        long num2 = (long) intent.getDoubleExtra(calculocientifco3.Numerocient2,0.00);


        if(num1 == 0.00 || num2 == 0.00){
            finish();
            return;
        }
        funcoescientificascalculo funcoescientificascalculo = new funcoescientificascalculo(num1,num2);

        TextView textViewres = (TextView)findViewById(R.id.textRes12);
        TextView textViewcient = (TextView)findViewById(R.id.textpartecientifica2);
        double res = funcoescientificascalculo.multiplicacao();
        int index = (int) funcoescientificascalculo.contardigitos();
        if (res<999999999.99 && res>-999999999.99){
            textViewres.setText("Não foi possivel calcular, o resultado tem menos de dez digitos inteiros");
        }else {
            textViewres.setText(String.format("parte normal:%.2f", res));
        }
        textViewcient.setText(String.format("parte cientifica: parte normal(n,dd) * 10 ^ %d",index));

    }

    public void agredecimento(View view) {
        Intent intent = new Intent(this,MenuAgredicento.class);
        startActivity(intent);
    }
}
