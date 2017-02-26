package com.hurenjieee.util;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.CookiesAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.http.converter.feed.RssChannelHttpMessageConverter;
import org.springframework.web.context.ServletContextAware;

import com.hurenjieee.service.BaseService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public abstract class BaseAction<T,ID extends Serializable> extends ActionSupport implements ServletContextAware, ServletRequestAware,
		ServletResponseAware, ApplicationAware, SessionAware, CookiesAware {

	private static final long serialVersionUID = 1L;
	
	// ------------------BaseService ��  Object ��Ϊ������-------------------------
	public BaseService<T, ID> service;
	
	public T object;
	
	public abstract  BaseService<T, ID> getService();

	public abstract T getObject();

	// ------------------BaseService ��  Object ��Ϊ������-------------------------
	
	

	// -------------------------��Դ��������---------------------------------
	// request����
	private HttpServletRequest request;
	// request����
	private HttpServletResponse response;
	
	
	// ȫ��application,���������ϵͳ����
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

	// -----------------------ͨ�÷��ʲ���---------------------------
	private Map<String, Integer> intMap;

	private Map<String, String> strMap;

	private Map<String, Double> douMap;

	public Map<String, Integer> getIntMap() {
		return intMap;
	}

	public void setIntMap(Map<String, Integer> intMap) {
		this.intMap = intMap;
	}

	public Map<String, String> getStrMap() {
		return strMap;
	}

	public void setStrMap(Map<String, String> strMap) {
		this.strMap = strMap;
	}

	public Map<String, Double> getDouMap() {
		return douMap;
	}

	public void setDouMap(Map<String, Double> douMap) {
		this.douMap = douMap;
	}
	// -----------------------ͨ�÷��ʲ�������---------------------------
	
	//--------------ͨ�÷���----------------
	
	/**
	 * ֱ�ӷ���resMapde��JSON����
	 * @param resultMap ����Map
	 */
	protected void ResponseJson(Map<String,Object> resultMap) {

		//ͨ��json-lib����ʵ��MapתString
		JSONObject jsonMap = JSONObject.fromObject(resultMap);
		String jsonString = jsonMap.toString();
		
		response.setContentType("text/html; charset=utf-8"); // �ַ�����
		response.setHeader("pragma", "no-cache"); // ������
		response.setHeader("cache-control", "no-cache");
		
		try {
			response.getWriter().write(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//--------------ͨ�÷���----------------
	

	
	//---------------����Service�����������˶��ʹ��------------
	/**
	 * ��ȡ��ȫ����ʵ��
	 * @throws IOException
	 */
	public void getAllList() throws IOException{
		Map<String,Object> resultMap = new TreeMap<String,Object>();
		List<T> list = service.getList();
		resultMap.put("list", list);
		ResponseJson(resultMap);
	}
	
	/**
	 * ����ID��ȡ��ʵ��
	 * @param id
	 * @throws IOException
	 */
	public void getById(ID id) throws IOException{
		Map<String,Object> resultMap = new TreeMap<String,Object>();
		T result = getService().getById(id);
		resultMap.put("result", result);
		ResponseJson(resultMap);
		
	}
	
	//---------------����Service��������------------
}