package com.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.entity.*;
import com.service.*;

@Controller
public class DemoController {

	private IDemoService ds;

	public IDemoService getDs() {
		return ds;
	}

	@Autowired
	public void setDs(IDemoService ds) {
		this.ds = ds;
	}
	
	@RequestMapping("/allDemo")
	public ModelAndView allDemo(ModelAndView mvo){
		
		List<Demo> list = ds.selectAll();
		
		mvo.addObject("list", list);
		mvo.setViewName("demo");
		return mvo;
	}
	
	// @ResponseBody ʵ�� ajax
	@RequestMapping(value="/allDemo2",produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public Object allDemo2(String page,String rows,String sort,String order){
		
		System.out.println(" page = "+page);//�ڼ�ҳ
		System.out.println(" rows = "+rows);//һҳ����
		System.out.println(" sort = "+sort);//���ĸ��ֶ���
		System.out.println(" order = "+order);// �����Ƿ���
		
		List<Demo> list = ds.selectAll();
	
		DemoData dt = new DemoData();
		dt.setTotal(list.size());// ����Ƿ�ҳҪ���ܼ�¼��
		dt.setRows(list);
		
		String json = JSON.toJSONString(dt);
		System.out.println(" json = "+json);
		
		return json;
	}
	
	@RequestMapping("/insertDemo")
	public ModelAndView insertDemo(ModelAndView mvo,Demo demo){
		
		int num = ds.insert(demo);
		
		mvo.setViewName("redirect:/allDemo");
		return mvo;
	}
	
	@RequestMapping("/delDemo")
	public void delDemo(HttpServletResponse response,Integer did) throws Exception{
		PrintWriter out = response.getWriter();
		
		int num = ds.deleteByPrimaryKey(did);
		
		if(num > 0){
			out.print("true");
		}else{
			out.print("false");
		}
		
		out.flush();
		out.close();
	}
	
	@RequestMapping("/updateDemo")
	public void updateDemo(HttpServletResponse response,Demo d2) throws Exception{
		PrintWriter out = response.getWriter();
		
		int num = ds.updateByPrimaryKey(d2);
		
		if(num > 0){
			out.print("true");
		}else{
			out.print("false");
		}
		
		out.flush();
		out.close();
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
