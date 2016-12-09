package com.hurenjieee.action;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.hurenjieee.entity.Userr;
import com.hurenjieee.service.LoginService;
import com.hurenjieee.util.CRUDActionSupport;
import com.opensymphony.xwork2.ActionContext;

@ParentPackage(value = "all")//Ӧ��ȫ�ְ� 
@Scope("prototype")
@Action(
		results={
		@Result(name = "success", location = "/WEB-INF/jsp/success.jsp"),
		@Result(name = "error", location = "/WEB-INF/jsp/error.jsp"),
		@Result(name = "download", type = "stream", params = {  
				"contentType", "application/octet-stream",  
                "inputName", "inputStream",  
                "contentDisposition", "attachment;filename=\"${fileName}\"",  
                "bufferSize", "4096"})
		}
)
public class LoginAction extends CRUDActionSupport<Userr>{ 
    
    private static final long serialVersionUID = 1L;

    @Autowired
    private LoginService loginService;
          
    private String userName;  
    private String passWord;
    private File file;
    private String fileFileName;
    
    private String fileName;
    private InputStream inputStream;
    
    
    public String getFileName() {  
        return fileName;  
    }  
  
    public void setFileName(String fileName) {  
        this.fileName = fileName;
    }
    
    
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getUserName() {  
        return userName;  
    }  
    public String getPassWord() {  
        return passWord;  
    }  
    public void setUserName(String userName) {  
        this.userName = userName;  
    }  
    public void setPassWord(String passWord) {  
        this.passWord = passWord;  
    }
    
	public String login() throws Exception{
		
		 ServletContext servletContext = getServletContext();
		 Map<String,String> map=(Map<String, String>) servletContext.getAttribute("applicationMap");
		 System.out.println(map.get("key1"));
		 System.out.println(map.get("key2"));
    	 String realpath = getServletContext().getRealPath("/img");
    	 System.out.println("realpath: "+realpath);
    	 
         if (file != null) {
             File savefile = new File(new File(realpath), fileFileName);
             if (!savefile.getParentFile().exists())
                 savefile.getParentFile().mkdirs();
             FileUtils.copyFile(file, savefile);
             ActionContext.getContext().put("message", "�ļ��ϴ��ɹ�");
         }
        if(loginService.login(userName, passWord)!=null){
               return SUCCESS;
          }else{  
               return ERROR;  
            }  
    }
	public String download(){
		String filePath = getServletContext().getRealPath("/img")+"/text.txt";  
        try {  
            setFileName(new String("�Ź�������ͼƬ.txt".getBytes(), "iso8859-1"));  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        } 
        try {  
            inputStream= new FileInputStream(filePath);  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        }  
		return "download";
	}

}
