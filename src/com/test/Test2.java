package com.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.entity.*;
import com.service.*;

public class Test2 {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 服务层 用 接口接收
		IDemoService ds = (IDemoService)ctx.getBean("demoService");
        
		Demo d2 = ds.selectByPrimaryKey(Integer.valueOf("1"));
      
		System.out.println(d2);
	}

}
