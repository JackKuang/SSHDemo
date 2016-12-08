package com.hurenjieee.util;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.CookiesAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.web.context.ServletContextAware;

import com.hurenjieee.entity.Page;
import com.opensymphony.xwork2.ActionSupport;

public abstract class CRUDActionSupport<T> extends ActionSupport
		implements ServletContextAware, ServletRequestAware, ServletResponseAware, ApplicationAware, SessionAware, CookiesAware {

	private static final long serialVersionUID = 1L;

	// -------------------------��Դ��������---------------------------------
	// request����
	private HttpServletRequest request;
	// request����
	private HttpServletResponse response;
	// ȫ��application,���������ϵͳ����
	// ���ڷ������ˣ�������һ�㲻ֹͣ�����Ҫֹͣ�ʹ������ݿ⣬�������ڴ����ݿ�ȡ����
	private Map<String, Object> applicationMap;
	// session���ڷ������ˣ��ر����������ʧ��
	private Map<String, Object> sessionMap;
	// cookie���ڿͻ����У����̳־û�
	private Map<String, String> cookieMap;
	
	private ServletContext servletContext;

	@Override
	public void setApplication(Map<String, Object> application) {
		this.applicationMap = application;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// request.setCharacterEncoding("");
		this.request = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setCookiesMap(Map<String, String> cookies) {
		this.cookieMap = cookies;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.sessionMap = session;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public Map<String, Object> getApplicationMap() {
		return applicationMap;
	}

	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	public Map<String, String> getCookieMap() {
		return cookieMap;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	// -------------------------��Դ�������ý���-------------------------------


	// -------------------------ҳ����Ϣ����----------------------------------
	// ҳ�����
	private int pageNo;
	// ҳ���С
	private int pageSize;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	// ���÷�ҳ��Ϣ�������������������sql���þͿ���ִ�з�ҳ����
	public void setPageInfo(Page<T> page) {
		if (pageNo > 0) {
			page.setPageNo(pageNo);
		}
		if (pageSize > 0) {
			page.setDataSize(pageSize);
		}
	}
	// -------------------------ҳ����Ϣ���ý���-------------------------------

}
