package com.example.andre.calculadoraandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Menubin extends AppCompatActivity {
    public static final double numMax = 9;
    public static final double numMin = -9;
    public static final String Numerobasico1 = "Numero1";
    public static final String Numerobasico2 = "Numero2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menubin);
    }

    public void calbinsub(View view) {
        Intent intent = new Intent(this,Menuresbin2.class);
        EditText editTextnum1 = (EditText)findViewById(R.id.editText);
        EditText editTextnum2 = (EditText)findViewById(R.id.editText2);
        double num1;
        double num2;
        try {
            num1 = Double.parseDouble(editTextnum1.getText().toString());
        }catch (NumberFormatException e){
            editTextnum1.setError("Numero 1 Invalido!! Porfavor preencha.");
            editTextnum1.requestFocus();
            return;
        }

        if(num1>numMax){
            editTextnum1.setError("Numero 1 Invalido!! O limite máximo é 9");
            editTextnum1.requestFocus();
            return;
        } else if(num1<numMin){
            editTextnum1.setError("Numero 1 Invalido !! O limite mínimo é -9");
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
            editTextnum2.setError("Numero 1 Invalido!! O limite máximo é 9");
            editTextnum2.requestFocus();
            return;
        } else if(num2<numMin){
            editTextnum2.setError("Numero 1 Invalido !! O limite mínimo é -9");
            editTextnum2.requestFocus();
            return;
        }
        intent.putExtra(Numerobasico1,num1);
        intent.putExtra(Numerobasico2,num2);
        if (num1 ==9 && num2==1){
            Toast.makeText(this, "O resultado vai ser maior ou igual do que dez", Toast.LENGTH_LONG).show();
            return;
        }else if (num1 ==-9 && num2==-1){
            Toast.makeText(this, "O resultado vai ser menor ou igual do que dez negativo", Toast.LENGTH_LONG).show();
            return;
        }else if (num1==1 && num2 == 9){
            Toast.makeText(this, "O resultado vai ser maior ou igual do que dez", Toast.LENGTH_LONG).show();
            return;
        }else if(num1==8 && num2==2 || num1 ==2 && num2 == 8){
            Toast.makeText(this, "O resultado vai ser maior ou igual do que dez", Toast.LENGTH_LONG).show();
            return;
        }else if (num1 == -8 && num2 == -2 || num1 == -2 && num2 == -8 || num1==-3 && num2 ==-7 || num1 ==-7 && num2==-3){
            Toast.makeText(this, "O resultado vai ser menor ou igual do que dez negativo", Toast.LENGTH_LONG).show();
            return;
        }else if(num1== 7 && num2== 3 || num1 == 3 && num2 == 7 || num1 == 6 && num2 ==4 || num1 == 4 && num2 ==6){
            Toast.makeText(this, "O resultado vai ser maior ou igual do que dez", Toast.LENGTH_LONG).show();
            return;
        }else if(num1 == -6 && num2 ==-4 || num1 ==-4 && num2 ==-6 || num1 ==-5 && num2 ==-5){
            Toast.makeText(this, "O resultado vai ser menor ou igual do que dez negativo", Toast.LENGTH_LONG).show();
            return;
        }else if (num1 == 5 && num2 ==5){
            Toast.makeText(this, "O resultado vai ser maior ou igual do que dez", Toast.LENGTH_LONG).show();
            return;
        }
        startActivity(intent);
    }
}
