package com.fundamentos.springboot.fundamentos.bean;

public class TestDependencyImpl implements TestDependency{

    private MyInterfaseTest myInterfaseTest;

    public TestDependencyImpl(MyInterfaseTest myInterfaseTest) {
        this.myInterfaseTest = myInterfaseTest;
    }

    @Override
    public void print() {
        int a = 9;
        int b = 100;
        myInterfaseTest.mayorMenor(a, b);
    }
}
