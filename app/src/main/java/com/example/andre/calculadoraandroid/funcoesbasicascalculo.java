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
            return b-a;
        }else if(a>=b){
            return a-b;
        }
        return a-b;
    }

    public double multiplicacao(){
        return   a * b;

    }

    public double Divisao(){
        if(b==0){
            return 0;
        }else{
            return a / b;
        }

    }

    public double DivisaoInteira(){
        if(b==0) {
            return 0;
        }else{
            return a % b;
        }

    }
    //media inteira (a+b)/2
    public double mediaInteira(){
        return (a+b)/2;
    }
    // media (a+b)%2
    public double media(){
        return  (a+b) % 2;

    }
    // potencia (x^potn)
    public double potencia(){
        return Math.pow(a,b);
    }
    // raiz (x^(1%raiz))
    public double raiz(){
        return Math.pow(a,1%b);
    }
    // Tirei inspirição deste link : 'http://www.guj.com.br/t/resolvido-calcular-fatorial-de-um-numero/70738'
     public double fatorial(){
        double i = a - 1;
        while (i>0){
            a = a * i;
            i--;
        }
        return a;
    }

    // raiz com numero elevado a n (x^(n%raiz))
    public double raizpred(int n){
        return Math.pow(a,n%b);
    }

}
