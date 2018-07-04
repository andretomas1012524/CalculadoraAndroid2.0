package com.example.andre.calculadoraandroid;

/**
 * Created by Andre on 25-05-2018.
 */

public class funcoesbinariascalculo {
    private int a;
    private int b;
    private int n;
    String conv;
    int convA;
    int convB;
    int resultado;

    public funcoesbinariascalculo(int a, int b){
        this.a = a;
        this.b = b;
    }
    public String conversaobinario(int n){
        conv = Integer.toString(n,2);
        return conv;
    }
    private int conversaoA(){
        convA = Integer.parseInt(Integer.toBinaryString(a));
        return convA;
    }
    private int conversaoB(){
        convB = Integer.parseInt(Integer.toBinaryString(b));
        return convB;
    }

    public int calculoBCDsoma(){
       resultado = convA + convB;
       resultado = Integer.parseInt(Integer.toBinaryString(resultado));
       return resultado;
    }
    public int calculoBCDsub(){
        resultado = convA - convB;
        resultado = Integer.parseInt(Integer.toBinaryString(resultado));
        return resultado;
    }
    public int calculoBCDmult(){
        resultado = convA * convB;
        resultado = Integer.parseInt(Integer.toBinaryString(resultado));
        return resultado;
    }
    public int calculoBCDdiv(){
        resultado = convA / convB;
        resultado = Integer.parseInt(Integer.toBinaryString(resultado));
        return resultado;
    }
    public int calculoBCDdivi(){
        resultado = convA % convB;
        resultado = Integer.parseInt(Integer.toBinaryString(resultado));
        return resultado;
    }
}
