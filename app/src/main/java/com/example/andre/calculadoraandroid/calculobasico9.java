package com.example.andre.calculadoraandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class calculobasico9 extends AppCompatActivity {
    public static final double numMax = 999999999.99;
    public static final double numMin = -999999999.99;
    public static final String Numerobasico1 = "Numero1";
    public static final String Numerobasico2 = "Numero2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculobasico9);
    }

    public void calcularbasicofact(View view) {
        Intent intent = new Intent(this,Menuresultado10.class);
        EditText editTextnum1 = (EditText)findViewById(R.id.nbasico16);
        double num1;
        try {
            num1 = Double.parseDouble(editTextnum1.getText().toString());
        }catch (NumberFormatException e){
            editTextnum1.setError("Numero 1 Invalido!! Porfavor preencha.");
            editTextnum1.requestFocus();
            return;
        }

        if(num1>numMax){
            editTextnum1.setError("Numero 1 Invalido!! O limite máximo é 999999999.99");
            editTextnum1.requestFocus();
            return;
        } else if(num1<numMin){
            editTextnum1.setError("Numero 1 Invalido !! O limite mínimo é -999999999.99");
            editTextnum1.requestFocus();
            return;
        }

        intent.putExtra(Numerobasico1,num1);
        startActivity(intent);
    }
}
