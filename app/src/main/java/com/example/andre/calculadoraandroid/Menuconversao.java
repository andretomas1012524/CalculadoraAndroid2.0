package com.example.andre.calculadoraandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Menuconversao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuconversao);
        Intent intent = getIntent();

        int num1 = (int) intent.getDoubleExtra(ConversaoBinario.Numerobasico1,0.00);
        long num2 = (long) intent.getDoubleExtra(ConversaoBinario.Numerobasico2,0.00);


        if(num1 == 0.00 ){
            finish();
            return;
        }
        funcoesbinariascalculo funcoesbinariascalculo = new funcoesbinariascalculo(num1, (int) num2);
        String res = funcoesbinariascalculo.conversaobinario(num1);
        TextView textViewres = (TextView)findViewById(R.id.textView11);
        textViewres.setText(" " + res);

    }

    public void agredecimento(View view) {
        Intent intent = new Intent(this,MenuAgredicento.class);
        startActivity(intent);
    }
}
