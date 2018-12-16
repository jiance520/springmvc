package com.action;

import java.util.*;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.entity.*;
import com.service.*;

@Controller
public class FormController {

	private IDemoService ds ;

	public IDemoService getDs() {
		return ds;
	}

	@Autowired
	public void setDs(IDemoService ds) {
		this.ds = ds;
	}
	
	@RequestMapping("/form1")  // 如何接收不同名的参数
	public ModelAndView form1(ModelAndView mvo,@RequestParam(value="name") String ss,Integer id){
		System.out.println("--------form1");
		System.out.println(" ss = "+ss);
		System.out.println(" id = "+id);
		
		mvo.setViewName("success");
		return mvo ;
	}
	
	@RequestMapping("/form2")  // 如何接收多个同名的参数;默认用数组
	public ModelAndView form2(ModelAndView mvo,String[] names){
		System.out.println("--------form2");
		System.out.println(" names = "+Arrays.toString(names));
		
		mvo.setViewName("success");
		return mvo ;
	}
	
	@RequestMapping("/form3")  // 如何接收多个同名的参数;如果要用集合要加@RequestParam
	public ModelAndView form3(ModelAndView mvo, @RequestParam List<String> names){
		System.out.println("--------form3");
		System.out.println(" names = "+names);
		
		mvo.setViewName("success");
		return mvo ;
	}
	
	@RequestMapping("/form4")  // 没有同名的参数;可以用Map 要加@RequestParam
	public ModelAndView form4(ModelAndView mvo, @RequestParam Map<String,Object> mp){
		System.out.println("--------form4");
		System.out.println(" mp = "+mp);
		
		mvo.setViewName("success");
		return mvo ;
	}
	
	// 用对象接收参数 ；一定要和页面一致 
	@RequestMapping("/form5") 
	public ModelAndView form5(ModelAndView mvo,Demo d2){
		System.out.println("-----form5");
		System.out.println(" d2 = "+d2);
		
		mvo.setViewName("success");
		return mvo;
	}
	
	@RequestMapping("/form6") // 对象中的集合 
	public ModelAndView form6(ModelAndView mvo,TestEntity t2){
		System.out.println("-----form6");
		System.out.println(" t2 = "+t2);
		
		mvo.setViewName("success");
		return mvo;
	}
	
	@RequestMapping("/form7") // 对象中的对象
	public ModelAndView form7(ModelAndView mvo,TestEntity t2){
		System.out.println("-----form7");
		System.out.println(" t2  demo = "+t2.getDemo());
		
		mvo.setViewName("success");
		return mvo;
	}
	
	/*
	 *  springmvc 中 时间默认 是 yyyy/MM/dd 
	 *  
	 */
	@InitBinder  // 定义时间转化格式 yyyy-MM-dd
	public void binder(ServletRequestDataBinder bind){
		// 定义时间转化格式
		SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
		
		// 把类型和格式绑定
		bind.registerCustomEditor(Date.class, new CustomDateEditor(smf, true));
	}
	
}
