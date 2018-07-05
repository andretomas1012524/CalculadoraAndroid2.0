package com.example.andre.calculadoraandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Menubinpred3 extends AppCompatActivity {
    public static double numMax = 256;
    public static double numMin = -256;
    public static final String Numerobasico1 = "Numero1";
    public static final String Numerobasico2 = "Numero2";
    public static final String N ="N";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menubinpred3);
    }

    public void calbinmultpred(View view) {
        Intent intent = new Intent(this,Menuresbinpred3.class);
        EditText editTextnum1 = (EditText)findViewById(R.id.editText16);
        EditText editTextnum2 = (EditText)findViewById(R.id.editText17);
        EditText editTextnum3 = (EditText)findViewById(R.id.editText18);
        double num1;
        double num2;
        double n=1;


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
            editTextnum2.setError("Numero 2 Invalido!! Porfavor preencha.");
            editTextnum2.requestFocus();
            return;
        }

        if(num2>numMax){
            editTextnum2.setError("Numero 2 Invalido!! O limite maximo é 4 bits * 2^numero de bits colocado");
            editTextnum2.requestFocus();
            return;
        } else if(num2<numMin){
            editTextnum2.setError("Numero 2 Invalido !! O limite minimo é 4 bits * 2^numero de bits colocado");
            editTextnum2.requestFocus();
            return;
        }
        intent.putExtra(Numerobasico1,num1);
        intent.putExtra(Numerobasico2,num2);
        intent.putExtra(N,n);


        startActivity(intent);
    }
}
