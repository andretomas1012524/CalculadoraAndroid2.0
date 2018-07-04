package com.example.andre.calculadoraandroid;

/**
 * Created by Andre on 25-05-2018.
 */

public class funcoescientificascalculo {
    public double resultado;
    private long a;
    private long b;

    // ------- Declarar variaveis -------- \\
    public funcoescientificascalculo(long a, long b){
        this.a = a;
        this.b = b;
    }
    public int contardigitos(){
        String resultados = String.valueOf(resultado);
        int nres = resultados.length();
        int i;
        int count=0;
        for (i = 1; i <nres-3 ; i++) {
            count++;
        }
        return count;

    }
    //-------- Operações e funções ------- \\
    public double soma(){
        resultado = a + b;
        return resultado;
    }
    public double subtracao(){
        if (a<b) {
            resultado = b-a;
        }else{
            resultado = a - b;
        }
        return resultado;
    }
    public double multiplicacao(){
        resultado = a * b;
        return resultado;
    }
    public double divisao(){
        if (b == 0){
            return 0;
        }
        resultado = a /b;
        return resultado;
    }
    public double divisaointeira(){
        if (b == 0){
            return 0;
        }
        resultado = a % b;
        return resultado;
    }
}
