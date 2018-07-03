package com.example.andre.calculadoraandroid;

/**
 * Created by Andre on 25-05-2018.
 */

public class funcoesbinariascalculo {
    private int a;
    private int b;
    private int n;

    public funcoesbinariascalculo(int a, int b){
        this.a = a;
        this.b = b;
    }
    public String conversaobinario(){
        String n = "";
        int resto;
        while(a>0){
            resto = a % 2 ;
            n = Integer.toString(resto) + n;
            a = a/2;
        }
        return n;
    }

    public String calculoBCDsoma(){
        String n = "";
        int resto;
        String o = "";
        int resto1;
        String res ="";
        if(a>=10||b>=10){
            return String.valueOf(0);
        }
        while(a>0&&b>0){
            resto1 = b % 2;
            resto = a % 2 ;
            n = Integer.toString(resto) + n;
            o = Integer.toString(resto1) + o;
            a = a/2;
            b = b / 2;
        }
        res = n + o;
        return res;
    }

}
