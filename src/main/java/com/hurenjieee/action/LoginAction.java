package com.hurenjieee.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.w3c.dom.css.ElementCSSInlineStyle;

import com.hurenjieee.entity.Admin;
import com.hurenjieee.entity.Student;
import com.hurenjieee.entity.Teacher;
import com.hurenjieee.service.AdminService;
import com.hurenjieee.service.LoginService;
import com.hurenjieee.service.StudentService;
import com.hurenjieee.service.TeacherService;
import com.hurenjieee.util.CRUDActionSupport;
import com.hurenjieee.util.GlobalUtil;

@ParentPackage(value = "all") // Ӧ��ȫ�ְ�
@Scope("prototype")
@Action(results = { @Result(name = "success-admin", location = "/WEB-INF/jsp/admin/index.jsp"),
		@Result(name = "success-teacher", location = "/WEB-INF/jsp/teacher/index.jsp"),
		@Result(name = "success-student", location = "/WEB-INF/jsp/student/index.jsp"),
		@Result(name = "toLogin", location = "/WEB-INF/jsp/login.jsp") })
public class LoginAction extends CRUDActionSupport<Object> {

	@Autowired
	AdminService adminService;

	@Autowired
	TeacherService teacherService;

	@Autowired
	StudentService studentService;
	private String userName;
	private String password;
	private String type;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String login() {
		String result = "toLogin";
		// ����Session
		getSessionMap().clear();
		// ѧ����¼
		if ("student".equals(type)) {
			Student student = studentService.getStudentByUsernameAndPassword(userName, password);
			if (student != null) {
				getSessionMap().put("type", "student");
				getSessionMap().put("student", student);
				result = "success-admin";
			} else {
				getRequest().setAttribute("wrong", 1);
				getRequest().setAttribute("type", type);
				result = "toLogin";
			}
		}
		// ��ʦ��¼
		else if ("teacher".equals(type)) {
			Teacher teacher = teacherService.getTeacherByUsernameAndPassword(userName, password);
			if (teacher != null) {
				getSessionMap().put("type", "teacher");
				getSessionMap().put("student", teacher);
				result = "success-admin";
			} else {
				getRequest().setAttribute("wrong", 1);
				getRequest().setAttribute("type", type);
				result = "toLogin";
			}
		}
		// ����Ա��¼
		else if ("admin".equals(type)) {
			Admin admin = adminService.getAdminByUserNameAndPassword(userName, password);
			if (admin != null) {
				getSessionMap().put("type", "admin");
				getSessionMap().put("admin", admin);
				result = "success-admin";
			} else {
				getRequest().setAttribute("wrong", 1);
				getRequest().setAttribute("type", type);
				result = "toLogin";
			}
		}
		return result;
	}

	public String toLogin() {
		return "toLogin";
	}
}
