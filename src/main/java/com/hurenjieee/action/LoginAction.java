package com.hurenjieee.action;


import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.hurenjieee.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "all")//Ӧ��ȫ�ְ�  
@Action(
		results={
		@Result(name = "success", location = "/WEB-INF/jsp/success.jsp"),
		@Result(name = "error", location = "/WEB-INF/jsp/error.jsp")
		}
)
public class LoginAction extends ActionSupport{  
    
    private static final long serialVersionUID = 1L;       
          
    private String userName;  
    private String passWord; 
    
    //@Autowired����Ҫgetter()��setter()����
    @Autowired
    private LoginService loginService;
    
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
    public String execute() throws Exception{  
        if(loginService.login(userName, passWord)){  
               return SUCCESS;  
          }else{  
               return ERROR;  
            }  
    }

}
