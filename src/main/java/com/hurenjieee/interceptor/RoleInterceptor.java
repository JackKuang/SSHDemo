package com.hurenjieee.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hurenjieee.entity.Admin;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

@SuppressWarnings("serial")
public class RoleInterceptor implements Interceptor {

	@Override
	public void destroy() {

	}

	@Override
	public void init() {

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// ���ӷ��ؽ��ǰ�¼���ʵ�ʿ��������п��Բ鿴��Ϣ
		// ȡ��������ص�ActionContextʵ��  
		ActionContext actionContext = invocation.getInvocationContext();  
        Map<String,Object> session = actionContext.getSession();
        String userType = (String) session.get("userType");
        HttpServletRequest httpServletRequest =  (HttpServletRequest)actionContext.get(ServletActionContext.HTTP_REQUEST);
        String path = httpServletRequest.getContextPath();
        System.out.println("11111111111111"+path);
        String servletPath = httpServletRequest.getServletPath();
        //ȥ������Ҫ���˵���ַ
        if("/login!login.action".equals(servletPath)
        		|| "login!toLogin.action".equals(servletPath)){
    		return invocation.invoke();        	
        }
        return Action.LOGIN;
	}

}
