
package com.pitaya.spring.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SayMsg {
	@Autowired
	private static SayMsg sayMsg;
	
	@Autowired
	private  HelloWorld sayBean; 
    
	public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("spring-context-test.xml");
        HelloWorld hw = (HelloWorld) app.getBean("sayBean");
        hw.say();
        hw.setMsg("123");
        
        SayMsg sm = (SayMsg) app.getBean(SayMsg.class);
        sm.mysay();
        
    }

	private void mysay() {
		sayBean.say();		
	}
	
	
	
}