package com.example.andre.calculadoraandroid;

/**
 * Created by Andre on 25-05-2018.
 */

public class funcoesbasicascalculo {
    public double resultado=0.2f;
    public int resultadoI = 0;
    public double resultadoang  = 0.2f;

    // ------------ Definir números e operações privadas-------------- //
    private double getDoubleA(){
        double a = 0.2f;
        return a;
    }

    private double getDoubleB(){
        double b = 0.2f;
        return b;
    }

    private int getINTA(){
        int a=0;
        return a;
    }

    private int getPOT(){
        int potn = 0 ;
        return potn;
    }

    private int getRAIZ(){
        int raiz = 0;
        return raiz;
    }
    // ----------------- Operações / Funcões ---------------- //
    public double soma(){
        double a,b;
        a=getDoubleA();
        b=getDoubleB();
        resultado = a + b;
        if (resultado > 999999999.99){
            return 0;
        }else if (resultado<-999999999.99){
            return 0;
        }else {
            return resultado;
        }
    }

    public double subtracao(){
        double a ;
        a = getDoubleA();
        double b;
        b=getDoubleB();
        if(a<b){
            resultado = b-a;
        }else{
            resultado = a-b;
        }
        if (resultado > 999999999.99){
            return 0;
        }else if (resultado<-999999999.99){
            return 0;
        }else {
            return resultado;
        }

    }

    public double multiplicacao(){
        double a,b;
        a=getDoubleA();
        b=getDoubleB();
        resultado = a * b;
        if (resultado > 999999999.99){
            return 0;
        }else if (resultado<-999999999.99){
            return 0;
        }else {
            return resultado;
        }
    }

    public double DivisaoInteira(){
        double a,b;
        a=getDoubleA();
        b=getDoubleB();
        resultado = a / b;
        if (resultado > 999999999){
            return 0;
        }else if (resultado<-999999999){
            return 0;
        }else {
            return resultado;
        }
    }

    public double Divisao(){
        double a,b;
        a=getDoubleA();
        b=getDoubleB();
        resultado = a % b;
        if (resultado > 999999999.99){
            return 0;
        }else if (resultado<-999999999.99){
            return 0;
        }else {
            return resultado;
        }
    }

    public double mediaInteira(){
        double a,b;
        a=getDoubleA();
        b=getDoubleB();
        resultado = (a+b)/2;
        if (resultado > 999999999){
            return 0;
        }else if (resultado<-999999999){
            return 0;
        }else {
            return resultado;
        }
    }

    public double media(){
        double a,b;
        a= getDoubleA();
        b=getDoubleB();
        resultado = (a+b) % 2;
        if (resultado > 999999999.99){
            return 0;
        }else if (resultado<-999999999.99){
            return 0;
        }else {
            return resultado;
        }
    }

    public int potencia(){
        int a;
        a = getINTA();
        int potn;
        potn = getPOT();
        resultado = Math.pow(a,potn);
        if (resultadoI > 999999999){
            return 0;
        }else if (resultadoI<-999999999){
            return 0;
        }else {
            return resultadoI;
        }
    }

    public double raiz(){
        int a = getINTA();
        int raiz = getRAIZ();
        resultado = Math.pow(a,1%raiz);
        if (resultado > 999999999.99){
            return 0;
        }else if (resultado<-999999999.99){
            return 0;
        }else {
            return resultado;
        }
    }

     public int fatorial(){
        int a = getINTA();
        int i = 0 ;
        for (i=0;i<=a;i++){
            resultadoI = a * a-i;
        }
        return resultadoI;
    }

    //------------- Ainda falta material ---------------//
}
