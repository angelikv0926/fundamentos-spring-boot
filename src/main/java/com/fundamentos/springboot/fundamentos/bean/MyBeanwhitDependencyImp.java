package com.fundamentos.springboot.fundamentos.bean;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class MyBeanwhitDependencyImp implements MyBeanWhitDependency{

    //Log LOGGER_ = LogFactory.getLog(MyBeanwhitDependencyImp.class);

    private MyOperation myOperation;

    public MyBeanwhitDependencyImp(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWhitDependency() {
        //LOGGER_.info("Ingresando al metodo printWhitDependency");
        int numero = 9;
        //LOGGER_.debug("El numero enviado como parametro es: "+numero);
        System.out.println(myOperation.suma(numero));
        System.out.println("Hola desde la implementacion de un bean con dependencia");
    }
}
