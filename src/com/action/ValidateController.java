package com.action;

import javax.servlet.ServletContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ServletContextAware;
import com.entity.UsersVo;

@Controller
public class ValidateController implements ServletContextAware {

	private ServletContext application;
	
	@RequestMapping("/hello")
	public String hello(@Validated UsersVo uvo,BindingResult binder){
		System.out.println("   hello...  ");
		
		//验证失败
		if(binder.hasErrors()){
			System.out.println("----验证失败");
			System.out.println(binder.getFieldError().getDefaultMessage());
			System.out.println("----------------------------------------");
			return "forward:index.jsp";
		}
		
		return "success";
	}
	
	public void setServletContext(ServletContext servletContext) {
		
		this.application = servletContext;
	}
	
}
