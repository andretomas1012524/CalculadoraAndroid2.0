package com.example.andre.calculadoraandroid;

/**
 * Created by Andre on 25-05-2018.
 */

public class funcoesbasicascalculo {
    public double resultado;
    public int resultadoI;
    private double a;
    private double b;
    public funcoesbasicascalculo (double a ,double b){
        this.a = a;
        this.b = b;
    }
    { /*public double A = 0.2f;
    public double B = 0.2f;
    public int AI = 0;
    public int potn = 0;
    public int raiz = 0;
    public int n = 0;

    // ------------ Definir números e operações privadas-------------- //
    private double getDoubleA(){
        return A;
    }

    private double getDoubleB(){
        return B;
    }

    private int getINTA(){
        return AI;
    }

    private int getPOT(){
        return potn;
    }

    private int getRAIZ(){
        return raiz;
    }

    private void setIntA(int ai){
         this.AI=ai;
    }

    private void setDoubleA(double a){
        this.A=a;
    }

    private void setDoubleB(double b){
        this.B = b;
    }

    private void setPotn(int potn){
        this.potn=potn;
    }

    private void setRaiz(int raiz){
        this.raiz=raiz;
    }

    private void setN(int n){
        this.n = n ;
    }

    private int getN(){
        return n;
    }*/}
    // ----------------- Operações / Funcões ---------------- //
    public double soma(){

        if (a > 999999999.99 || b > 999999999.99){
            return 0;
        }else if (a<-999999999.99||b<-999999999.99){
            return 0;
        }else {
            return a+b;
        }
    }

    public double subtracao(){
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
        if(b==0){
            return 0;
        }
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
        if(b==0) {
            return 0;
        }
        resultado = a % b;
        if (resultado > 999999999.99){
            return 0;
        }else if (resultado<-999999999.99){
            return 0;
        }else {
            return resultado;
        }
    }
    //media inteira (a+b)/2
    public double mediaInteira(){
        resultado = (a+b)/2;
        if (resultado > 999999999){
            return 0;
        }else if (resultado<-999999999){
            return 0;
        }else {
            return resultado;
        }
    }
    // media (a+b)%2
    public double media(){
        resultado = (a+b) % 2;
        if (resultado > 999999999.99){
            return 0;
        }else if (resultado<-999999999.99){
            return 0;
        }else {
            return resultado;
        }
    }
    // potencia (x^potn)
    public double potencia(){
        resultado = Math.pow(a,b);
        if (resultado > 999999999){
            return 0;
        }else if (resultado<-999999999){
            return 0;
        }else {
            return resultado;
        }
    }
    // raiz (x^(1%raiz))
    public double raiz(double a,int raiz){
        resultado = Math.pow(a,1%raiz);
        if (resultado > 999999999.99){
            return 0;
        }else if (resultado<-999999999.99){
            return 0;
        }else {
            return resultado;
        }
    }

    /* public int fatorial(int a, int i){
        for (i=0;i<=a;i++){
            resultadoI = a * a-i;
        }
        return resultadoI;
    }*/

    // raiz com numero elevado a n (x^(n%raiz))
    public double raizpred(double a,int raiz,int n){
        resultado = Math.pow(a,n%raiz);
        if (resultado > 999999999.99){
            return 0;
        }else if (resultado<-999999999.99){
            return 0;
        }else {
            return resultado;
        }
    }

}
