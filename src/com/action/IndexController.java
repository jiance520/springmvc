package com.action;

import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

// һ��Ҫ�� servlet.ModelAndView
import org.springframework.web.servlet.ModelAndView;

import com.entity.*;
import com.interceptor.Token;
import com.service.*;

@Controller   // action ��ע��
public class IndexController {

	private IDemoService ds ;

	public IDemoService getDs() {
		return ds;
	}

	// @Resource(name="demoService") 
	@Autowired
	public void setDs(IDemoService ds) {
		this.ds = ds;
	}
	
	@RequestMapping("/IndexAction")
	public String index(){
		Demo d2 = ds.selectByPrimaryKey(Integer.valueOf("1"));
		
		System.out.println(" d2 = "+d2);
		
		//return "forward:/main.jsp";
		//return "redirect:/main.jsp" ;
		return "index" ;  // Ĭ����ת�� 
		//return "redirect:/main" ;
	}
	
	@RequestMapping("/main")
	public String main(){
		System.out.println("-----------main");
		
		return "main" ;
	}
	
	@RequestMapping("/test")
	public String test(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		request.setAttribute("rnum", 12);
		session.setAttribute("snum", 20);
		System.out.println(" response = "+response);
		
		return "test" ;
	}
	
	@RequestMapping("/test2")
	public ModelAndView test2(ModelAndView mvo,String name,Integer age,String sex){
		System.out.println(" name = "+name);
		System.out.println(" age = "+age);
		System.out.println(" sex = "+sex);
		
		//mvo.addObject("rnum", 24) ; // �� request�д� ����ֵ
		// �� request�д� ���ֵ
		Map<String,Object> mp = new HashMap<String, Object>();
		mp.put("rnum", 24);
		mp.put("name", name);
		mvo.addAllObjects(mp);
		
		mvo.setViewName("test"); // ָ����ͼ
		return mvo ;
	}
	
	@Token(remove=true)   // Ҫ�����ظ��ύ�ж� 
	@RequestMapping("/login")
	public ModelAndView login(ModelAndView mvo,String user,String password,HttpSession session){
		System.out.println("---------login");
		
		session.setAttribute("userinfo", user);
		
		mvo.setViewName("success");
		return mvo;
	}
	
}
