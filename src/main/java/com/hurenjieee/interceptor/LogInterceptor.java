package com.hurenjieee.interceptor;

import java.io.InputStream;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.interceptor.PreResultListener;

@SuppressWarnings("serial")
public class LogInterceptor implements Interceptor {
	private static Logger log = Logger.getLogger(LogInterceptor.class);

	@Override
	public void destroy() {

	}

	@Override
	public void init() {

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//���ӷ��ؽ��ǰ�¼���ʵ�ʿ��������п��Բ鿴��Ϣ��
		invocation.addPreResultListener(new PreResultListener() {

			@Override
			public void beforeResult(ActionInvocation invocation, String resultCode) {
				StringBuffer sb = new StringBuffer();
				Map<String, Object> sessionMap = invocation.getInvocationContext().getSession();
				String name = (String) sessionMap.get("name");
				if (name != null) {
					sb.append("[" + name + "]");
				} else {
					sb.append("[anonymous]");
				}
				sb.append("visited[" + invocation.getAction().getClass().getSimpleName() + "."
						+ invocation.getInvocationContext().getName() + "]with{");
				Map<String, Object> map = invocation.getInvocationContext().getParameters();
				Set<String> keys = map.keySet();
				for (String key : keys) {
					sb.append(key + "==>[" + ((Object[]) map.get(key))[0] + "]");
				}
				sb.append("}result==>[" + invocation.getResultCode() + "]");
				//�ɿ���̨��ӡ�Լ��ļ���ӡ���������ÿ�log4j.properties
				//2016-11-30 10:34:16 [INFO] -[anonymous]visited[LoginAction.login]with{login==>[�ύ]passWord==>[123]userName==>[admin]}result==>[success]
				log.info(sb);
			}
		});
		return invocation.invoke();
	}

}
