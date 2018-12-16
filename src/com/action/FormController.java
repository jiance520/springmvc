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
	
	@RequestMapping("/form1")  // ��ν��ղ�ͬ���Ĳ���
	public ModelAndView form1(ModelAndView mvo,@RequestParam(value="name") String ss,Integer id){
		System.out.println("--------form1");
		System.out.println(" ss = "+ss);
		System.out.println(" id = "+id);
		
		mvo.setViewName("success");
		return mvo ;
	}
	
	@RequestMapping("/form2")  // ��ν��ն��ͬ���Ĳ���;Ĭ��������
	public ModelAndView form2(ModelAndView mvo,String[] names){
		System.out.println("--------form2");
		System.out.println(" names = "+Arrays.toString(names));
		
		mvo.setViewName("success");
		return mvo ;
	}
	
	@RequestMapping("/form3")  // ��ν��ն��ͬ���Ĳ���;���Ҫ�ü���Ҫ��@RequestParam
	public ModelAndView form3(ModelAndView mvo, @RequestParam List<String> names){
		System.out.println("--------form3");
		System.out.println(" names = "+names);
		
		mvo.setViewName("success");
		return mvo ;
	}
	
	@RequestMapping("/form4")  // û��ͬ���Ĳ���;������Map Ҫ��@RequestParam
	public ModelAndView form4(ModelAndView mvo, @RequestParam Map<String,Object> mp){
		System.out.println("--------form4");
		System.out.println(" mp = "+mp);
		
		mvo.setViewName("success");
		return mvo ;
	}
	
	// �ö�����ղ��� ��һ��Ҫ��ҳ��һ�� 
	@RequestMapping("/form5") 
	public ModelAndView form5(ModelAndView mvo,Demo d2){
		System.out.println("-----form5");
		System.out.println(" d2 = "+d2);
		
		mvo.setViewName("success");
		return mvo;
	}
	
	@RequestMapping("/form6") // �����еļ��� 
	public ModelAndView form6(ModelAndView mvo,TestEntity t2){
		System.out.println("-----form6");
		System.out.println(" t2 = "+t2);
		
		mvo.setViewName("success");
		return mvo;
	}
	
	@RequestMapping("/form7") // �����еĶ���
	public ModelAndView form7(ModelAndView mvo,TestEntity t2){
		System.out.println("-----form7");
		System.out.println(" t2  demo = "+t2.getDemo());
		
		mvo.setViewName("success");
		return mvo;
	}
	
	/*
	 *  springmvc �� ʱ��Ĭ�� �� yyyy/MM/dd 
	 *  
	 */
	@InitBinder  // ����ʱ��ת����ʽ yyyy-MM-dd
	public void binder(ServletRequestDataBinder bind){
		// ����ʱ��ת����ʽ
		SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
		
		// �����ͺ͸�ʽ��
		bind.registerCustomEditor(Date.class, new CustomDateEditor(smf, true));
	}
	
}
