package com.hurenjieee.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class RoleForJsonInterceptor implements Interceptor {

    @Override
    public void destroy(){

    }

    @Override
    public void init(){

    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception{
        // ���ӷ��ؽ��ǰ�¼���ʵ�ʿ��������п��Բ鿴��Ϣ
        // ȡ��������ص�ActionContextʵ��
        ActionContext actionContext = invocation.getInvocationContext();
        Map<String, Object> session = actionContext.getSession();
        String userType = (String) session.get("userType");
        HttpServletRequest httpServletRequest = (HttpServletRequest) actionContext.get(ServletActionContext.HTTP_REQUEST);
        HttpServletResponse httpServletResponse = (HttpServletResponse) actionContext.get(ServletActionContext.HTTP_RESPONSE);
        httpServletRequest.getServletPath();
        // "/admin/admin!index.action"
        // System.out.println(path);
        String servletPath = httpServletRequest.getServletPath();
        String loginUserType = servletPath.split("/")[1];
        // ȥ������Ҫ���˵���ַ
        if ("resource".equals(loginUserType) || loginUserType.equals(userType) || "/login!login.action".equals(servletPath) || "/login!toLogin.action".equals(servletPath)) {
            // ����Servlet����
            return invocation.invoke();
        }
        session.clear();
        httpServletResponse.setContentType("text/html; charset=utf-8"); // �ַ�����
        httpServletResponse.setHeader("pragma","no-cache"); // ������
        httpServletResponse.setHeader("cache-control","no-cache");
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("result","01");
        JSONObject jsonMap = JSONObject.fromObject(resultMap);
        String jsonString = jsonMap.toString();
        httpServletResponse.getWriter().write(jsonString);
        httpServletResponse.getWriter().close();
        return null;
    }

}
