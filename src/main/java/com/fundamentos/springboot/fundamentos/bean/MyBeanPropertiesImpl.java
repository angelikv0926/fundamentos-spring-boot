package com.fundamentos.springboot.fundamentos.bean;

public class MyBeanPropertiesImpl implements MyBeanProperties{

    private String nombre;
    private String apellido;

    public MyBeanPropertiesImpl(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String function() {
        return nombre + " - " + apellido;
    }
}
