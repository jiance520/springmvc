package com.action;

import java.io.*;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController implements ServletContextAware {

	private ServletContext application;
	
	//url��Ҫ���ļ���ͬ���������쳣
	@RequestMapping("/upload2")
	public String upload2(@RequestParam(required=false) MultipartFile[] files,String title) throws Exception{
		
		String path = application.getRealPath("upload")+File.separator;
		System.out.println(path+" \t title:"+title);
		
		for (MultipartFile file : files) {
			//�ж��ļ��ǿգ��ϴ�
			if(!file.isEmpty()){
				String type = file.getContentType();
				long size = file.getSize();
				System.out.println("�ļ����ͣ�"+type+"\t�ļ���С��"+size);
				
				//����ַ���
				String uuid = UUID.randomUUID().toString();
				System.out.println(" uuid = "+uuid);
				
				//�ļ�����
				String fname = file.getOriginalFilename();
				System.out.println("  name = "+fname);
				
				//Ŀ���ļ�
				File destFile = new File(path,uuid+fname);
				
				//�ϴ������ϴ��ļ���д��Ŀ���ļ�
				FileUtils.copyInputStreamToFile(file.getInputStream(), destFile);
			}
		}
		
		return "success";
	}

	@RequestMapping("/download")
	public void download(HttpServletRequest request, HttpServletResponse response,String realName) throws Exception{
		//����ContentType Ϊ��
		String contentType = "application/octet-stream";
		/*response.setContentType("text/html;charset=UTF-8");  
        request.setCharacterEncoding("UTF-8");  */
        BufferedInputStream bis = null;  
        BufferedOutputStream bos = null;  
 
        //Ĭ�ϵ��ļ��� /upload ��.
        String ctxPath = application.getRealPath("upload")+File.separator;  
        System.out.println(" ctxPath = "+ctxPath);
        
        String downLoadPath = ctxPath + realName; //Ҫ�����ļ��ľ��Ե�ַ 
  
        long fileLength = new File(downLoadPath).length();  
  
        //����ContentType
        response.setContentType(contentType);  
        response.setHeader("Content-disposition", "attachment; filename="  
                + new String(realName.getBytes("UTF-8"), "ISO-8859-1"));  
        response.setHeader("Content-Length", String.valueOf(fileLength));  
  
        bis = new BufferedInputStream(new FileInputStream(downLoadPath));  
        bos = new BufferedOutputStream(response.getOutputStream());  
        byte[] buff = new byte[2048];  
        
        int bytesRead=bis.read(buff);//��ȡ
        
        while (bytesRead != -1) {  
            bos.write(buff, 0, bytesRead);//д��  
            bytesRead=bis.read(buff);
        } 
        
        bis.close();  //�ر���
        bos.flush();
        bos.close();  
	}
	
	public void setServletContext(ServletContext servletContext) {
		
		this.application = servletContext;
	}
	
}
