package com.fundamentos.springboot.fundamentos.configuration;

import com.fundamentos.springboot.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {

    @Bean
    public MyBean beanOperation(){
        return new MyBeanImplement2();
    }

    @Bean
    public MyOperation beanOperationNumber(){
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWhitDependency beanOperationWhitDependency(MyOperation myOperation){
        return new MyBeanwhitDependencyImp(myOperation);
    }

    @Bean
    public MyInterfaseTest myInterfaseTest(){
        return new MyInterfaseTestImpl();
    }

    @Bean
    public TestDependency beanTestDependency(MyInterfaseTest myInterfaseTest){
        return new TestDependencyImpl(myInterfaseTest);
    }
}
