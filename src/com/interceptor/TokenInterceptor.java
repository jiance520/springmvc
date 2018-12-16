package com.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TokenInterceptor implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		
		if(arg2 instanceof HandlerMethod){ // �ǲ������󷽷�
			HandlerMethod hm = (HandlerMethod)arg2;
			Method md = hm.getMethod() ; // ȡ����
			Token tk = (Token)md.getAnnotation(Token.class) ;//ͨ������ȡע��
			if(tk != null){ // Ҫ��ע��
				boolean check = tk.remove() ; // ȡע�����Ե�ֵ
				if(check){ 
					System.out.println("----Ҫ�����ظ��ύ�ж�");
					//ȡ session
					HttpSession session = request.getSession();
					// �ж� 
					boolean ck = ifRepeat(request, session);
					//���session: ���۶Դ�Ҫ��� 
					session.removeAttribute("token");
					//== TRUE Ҫ��������
					if(ck){
						System.out.println("-----�����ظ��ύ������");
						response.sendRedirect("repeat.jsp");
						return false ; // ��ֹ ��ǰ���ʵ�·��
					}
				}
			}
		}
	
		return true;
	}

	// �ж��Ƿ��ظ��ύ��== TRUE Ҫ��������
	private boolean ifRepeat(HttpServletRequest request,HttpSession session){
		boolean check = true;
		// �õ� ҳ�洫��ֵ 
		String pages = request.getParameter("token"); 
		// �õ� session�е�ֵ
		Object sobj = session.getAttribute("token");
		
		if(pages !=null && sobj !=null && pages.equals(sobj)){
			check = false ; //�����ظ��ύ
		}
		
		return check ;
	}
}
