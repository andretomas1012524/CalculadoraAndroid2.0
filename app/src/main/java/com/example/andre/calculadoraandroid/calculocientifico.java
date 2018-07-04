package com.example.andre.calculadoraandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class calculocientifico extends AppCompatActivity {
    public static final double numMinpos = 999999999.99;
    public static final double numMinneg = -999999999.99;
    public static final String Numerocient1 = "Numero1";
    public static final String Numerocient2 = "Numero2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculocientifico);
    }

    public void somacient(View view) {
        Intent intent = new Intent(this,Menuresultado11.class);

        EditText editTextnum1 = (EditText)findViewById(R.id.ncient1);
        EditText editTextnum2 = (EditText)findViewById(R.id.ncient2);

        double num1;
        double num2;

        try {
            num1 = Double.parseDouble(editTextnum1.getText().toString());
        }catch (NumberFormatException e){
            editTextnum1.setError("Numero 1 Invalido!! Porfavor preencha.");
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

        if(num1<numMinpos && num1>numMinneg){
            editTextnum1.setError("Numero 1 Invalido!! O limite mínimo positivo é 999999999.99");
            editTextnum1.requestFocus();
            return;
        }
        if(num2<numMinpos && num2>numMinneg){
            editTextnum2.setError("Numero 2 Invalido!! O limite mínimo posistivo é 999999999.99");
            editTextnum2.requestFocus();
            return;
        }
        intent.putExtra(Numerocient1,num1);
        intent.putExtra(Numerocient2,num2);
        startActivity(intent);
    }
}
