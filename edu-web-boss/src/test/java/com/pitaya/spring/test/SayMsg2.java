
package com.pitaya.spring.test;

public class SayMsg2 {
    public static void main(String[] args) {
        /*ApplicationContext app = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld hw = (HelloWorld) app.getBean("sayBean");
        hw.say();*/
        
        MyClassPathXmlApplicationContext applicationContext = new MyClassPathXmlApplicationContext("spring-context-test.xml");
        HelloWorld hWorld = (HelloWorld) applicationContext.getBean("sayBean");
        hWorld.say();               
    }
}