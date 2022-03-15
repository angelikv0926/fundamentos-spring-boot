package com.fundamentos.springboot.fundamentos.bean;

public class MyInterfaseTestImpl implements MyInterfaseTest{

    @Override
    public void mayorMenor(int a, int b) {
        if(a > b){
            System.out.println("El numero "+ a +" es mayor que "+b);
        } else if(b > a) {
            System.out.println("El numero "+ b +" es mayor que "+a);
        } else {
            System.out.println("Los numeros "+ a +" y "+ b +" son iguales");
        }
    }
}
