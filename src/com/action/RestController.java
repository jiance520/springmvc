package com.action;

import java.io.*;

import javax.servlet.http.*;

import net.sf.json.JSONArray;

import com.alibaba.fastjson.JSON;
import com.entity.*;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestController {
	
	//restful·ç¸ñ
	@RequestMapping("/admin/{id}/{name}/abc")
	public String restful(@PathVariable int id,@PathVariable String name){
		System.out.println("RestContoller restful......");
		
		System.out.println(id+"\t"+name);
		
		return "success";
	}
	
	@RequestMapping("/admin/**/abc??")
	public String ant3(){
		System.out.println("RestContoller ant3......");
		return "success";
	}
	
	@RequestMapping("/admin/**/abc")
	public String ant2(){
		System.out.println("RestContoller ant2......");
		return "success";
	}
	
	@RequestMapping("/admin/*/abc")
	public String ant1(){
		System.out.println("RestContoller ant1......");
		return "success";
	}
	
}
