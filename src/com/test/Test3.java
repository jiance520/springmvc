package com.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.entity.*;
import com.service.*;
import java.util.*;

public class Test3 {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 服务层 用 接口接收
		IDemoService ds = (IDemoService)ctx.getBean("demoService");
        
		Demo d2 = new Demo();
		     d2.setTitle("小明");
		     d2.setDtime(new Date());
      
		int num = ds.insert(d2)   ;
		
		System.out.println(d2);
	}

}
