package com.action;

import java.io.PrintWriter;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.*;
import com.service.*;
import com.alibaba.fastjson.JSON;

@Controller
public class AjaxController {

	private IDemoService ds ;

	public IDemoService getDs() {
		return ds;
	}

	@Autowired
	public void setDs(IDemoService ds) {
		this.ds = ds;
	}
	
	// 用流的方式实现ajax
	@RequestMapping("/ajax1")
	public void ajax1(HttpServletResponse response,String user) throws Exception{
		System.out.println("--------------ajax1");
		System.out.println(" user = "+user);
		
		PrintWriter out = response.getWriter();
		
		Demo d2 = new Demo();
		     d2.setDid(Integer.valueOf("1"));
		     d2.setTitle("测试1");
		     d2.setDtime(new Date());
		
		// 转json
		String js = JSON.toJSONString(d2); 
		System.out.println(" json = "+js);
		
		// 输出给 页面
		out.print(js);
		
		out.flush();
		out.close();
	}
	
	// @ResponseBody 实现 ajax
	@RequestMapping(value="/ajax2",produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public Object ajax2(String user) throws Exception{
		System.out.println("--------------ajax2");
		System.out.println(" user = "+user);
		Demo d2 = new Demo();
		     d2.setDid(Integer.valueOf("1"));
		     d2.setTitle("测试1");
		     d2.setDtime(new Date());
		// 转json
		String js = JSON.toJSONString(d2); 
		System.out.println(" json = "+js);
		return js ;
	}
	
	@RequestMapping(value="/chart1",produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public Object chart1(String type) throws Exception{
		System.out.println("--------------chart1");
		System.out.println(" type = "+type);
		CuBean  c2 = new CuBean();
		//得到数据
		setCu(c2);
		// 转json
		String js = JSON.toJSONString(c2); 
		System.out.println(" json = "+js);
		return js ;
	}
	
	//得到数据
	private void setCu(CuBean c2){
		String s1 = "阿根庭,印尼,美国,印度,中国,世界人口(万)";
		String s2 = "18203, 23489, 29034, 104970, 131744, 630230";
		String s3 = "19325, 23438, 31000, 121594, 134141, 681807";
		//国家数据
		String[] arr1 = s1.split(",");
		for(String s :arr1){
			c2.getNames().add( s.trim() ) ;
		}
		// 2011
		String[] arr2 = s2.split(",");
		for(String s :arr2){
			Integer temp = Integer.valueOf(s.trim());
			c2.getYear11().add(temp);
		}
		// 2012
		String[] arr3 = s3.split(",");
		for(String s :arr3){
			Integer temp = Integer.valueOf(s.trim());
			c2.getYear12().add(temp);
		}
	}
}
