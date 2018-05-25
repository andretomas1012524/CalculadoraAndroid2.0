/**
 * Created by Andre on 25-05-2018.
 */

public class funcoesbasicas {
    public double resultado=0.2f;

    // ------------ Definir números -------------- //
    private double getDoubleA(){
        double a = 0.2f;
        return a;
    }

    private double getDoubleB(){
        double b = 0.2f;
        return b;
    }

    // ----------------- Operações / Funcões ---------------- //
    public double soma(){
        double a,b;
        a=getDoubleA();
        b=getDoubleB();
        resultado = a + b;
        return resultado;
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
        return resultado;
    }

    public double multiplicacao(){
        double a,b;
        a=getDoubleA();
        b=getDoubleB();
        resultado = a * b;
        return resultado;
    }

    public double DivisaoInteira(){
        double a,b;
        a=getDoubleA();
        b=getDoubleB();
        resultado = a /b;
        return resultado;
    }

    public double Divisao(){
        double a,b;
        a=getDoubleA();
        b=getDoubleB();
        resultado = a % b;
        return resultado;
    }

    public double mediaInteira(){
        double a,b;
        a=getDoubleA();
        b=getDoubleB();
        resultado = (a+b)/2;
        return resultado;
    }

    public double media(){
        double a,b;
        a= getDoubleA();
        b=getDoubleB();
        resultado = (a+b) % 2;
        return resultado;
    }
    
}
