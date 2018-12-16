package com.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.entity.*;

public class Test1 {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        TestEntity ts = (TestEntity)ctx.getBean("testEntity");
        
        ts.setName("¿œÕı");
        System.out.println(ts);
	}

}
