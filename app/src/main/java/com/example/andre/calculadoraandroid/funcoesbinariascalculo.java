package com.example.andre.calculadoraandroid;

/**
 * Created by Andre on 25-05-2018.
 */

public class funcoesbinariascalculo {
    private int a;
    private int b;
    private int n;
    String conv;
    String convA;
    String convB;
    String resultado;

    public funcoesbinariascalculo(int a, int b){
        this.a = a;
        this.b = b;
    }
    public String conversaobinario(String n){
        conv = Integer.toString(Integer.parseInt(n),2);
        return conv;
    }
    /*private String conversaoA(){
        //convA = Integer.toString(a,2);
        return convA;
    }
    private String conversaoB(){
        //convB = Integer.toString(b,2);
        return convB;
    }*/

    public String calculoBCDsoma(){
        resultado = String.valueOf(a + b);
        String c = Integer.toString(Integer.parseInt(resultado),2);
        return c;
    }
   public String calculoBCDsub(){
       resultado = String.valueOf(a - b);
       String c = Integer.toString(Integer.parseInt(resultado),2);
       return c;
   }
    public String calculoBCDmult(){
        resultado = String.valueOf(a * b);
        String c = Integer.toString(Integer.parseInt(resultado),2);
        return c;
    }
   public String calculoBCDdiv(){
       resultado = String.valueOf(a / b);
       String c = Integer.toString(Integer.parseInt(resultado),2);
       return c;
    }
    /*public String calculoBCDdivi(){
        resultado = String.valueOf(convA % convB);
        resultado = conversaobinario(Integer.parseInt(resultado));
        return resultado;
    }*/
}
