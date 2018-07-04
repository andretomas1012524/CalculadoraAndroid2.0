package com.example.andre.calculadoraandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Menubinpred extends AppCompatActivity {
    public static double numMax = 8;
    public static double numMin = -8;
    public static final String Numerobasico1 = "Numero1";
    public static final String Numerobasico2 = "Numero2";
    public static final String N ="N";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menubinpred);
    }

    public void calbinsomapred(View view) {
        Intent intent = new Intent(this,Menuresbinpred.class);
        EditText editTextnum1 = (EditText)findViewById(R.id.editText10);
        EditText editTextnum2 = (EditText)findViewById(R.id.editText11);
        EditText editTextnum3 = (EditText)findViewById(R.id.editText12);
        double num1;
        double num2;
        double n = 0;
        try {
            num1 = Double.parseDouble(editTextnum1.getText().toString());
        }catch (NumberFormatException e){
            editTextnum1.setError("Numero 1 Invalido!! Porfavor preencha.");
            editTextnum1.requestFocus();
            return;
        }

        if(num1>numMax){
            editTextnum1.setError("Numero 1 Invalido!! O limite maximo é 4 bits * 2^numero de bits colocado");
            editTextnum1.requestFocus();
            return;
        } else if(num1<numMin){
            editTextnum1.setError("Numero 1 Invalido !! O limite minimo é 4 bits * 2^numero de bits colocado");
            editTextnum1.requestFocus();
            return;
        }
        try {
            num2 = Double.parseDouble(editTextnum2.getText().toString());
        }catch (NumberFormatException e){
            editTextnum2.setError("Numero 1 Invalido!! Porfavor preencha.");
            editTextnum2.requestFocus();
            return;
        }

        if(num2>numMax){
            editTextnum2.setError("Numero 1 Invalido!! O limite maximo é 4 bits * 2^numero de bits colocado");
            editTextnum2.requestFocus();
            return;
        } else if(num2<numMin){
            editTextnum2.setError("Numero 1 Invalido !! O limite minimo é 4 bits * 2^numero de bits colocado");
            editTextnum2.requestFocus();
            return;
        }
        numMax = numMax * Math.pow(2,n);
        numMin = -numMin * Math.pow(2,n);
        intent.putExtra(Numerobasico1,num1);
        intent.putExtra(Numerobasico2,num2);
        intent.putExtra(N,n);

        if(num1 - num2 > numMax || num1 - num2 <-numMin){
            Toast.makeText(this, "O resultado vai ser maior ou menor do colocado", Toast.LENGTH_LONG).show();
            return;
        }
        startActivity(intent);
    }
}
