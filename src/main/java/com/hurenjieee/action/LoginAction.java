package com.hurenjieee.action;

import java.io.Serializable;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import com.hurenjieee.entity.Admin;
import com.hurenjieee.entity.Student;
import com.hurenjieee.entity.Teacher;
import com.hurenjieee.service.AdminService;
import com.hurenjieee.service.BaseService;
import com.hurenjieee.service.StudentService;
import com.hurenjieee.service.TeacherService;
import com.hurenjieee.util.BaseAction;

@ParentPackage(value = "all") // Ӧ��ȫ�ְ�
@Scope("prototype")
@Action(results = { @Result(name = "success-admin",type = "redirectAction",location = "admin/admin!index.action"),
        @Result(name = "success-teacher",type = "redirectAction",location = "teacher/teacher!index.action"),
        @Result(name = "success-student",type = "redirectAction",location = "student/student!index.action"),
        @Result(name = "toLogin",location = "/WEB-INF/jsp/login.jsp") })
public class LoginAction extends BaseAction<Object,Serializable> {

    @Override
    public BaseService<Object, Serializable> getService(){
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object getObject(){
        // TODO Auto-generated method stub
        return null;
    }

    @Autowired
    AdminService   adminService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    StudentService studentService;
    private String userName;
    private String password;
    private String userType;

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getUserType(){
        return userType;
    }

    public void setUserType(String userType){
        this.userType = userType;
    }

    public String login(){
        String result = "toLogin";
        // ����Session
        getSessionMap().clear();
        // ѧ����¼
        if ("student".equals(userType)) {
            Student student = studentService.getStudentByUsernameAndPassword(userName,password);
            if (student != null) {
                getSessionMap().put("userType","student");
                getSessionMap().put("student",student);
                result = "success-admin";
            } else {
                getRequest().setAttribute("wrong",1);
                getRequest().setAttribute("userType",userType);
                result = "toLogin";
            }
        }
        // ��ʦ��¼
        else if ("teacher".equals(userType)) {
            Teacher teacher = teacherService.getTeacherByUsernameAndPassword(userName,password);
            if (teacher != null) {
                getSessionMap().put("userType","teacher");
                getSessionMap().put("student",teacher);
                result = "success-admin";
            } else {
                getRequest().setAttribute("wrong",1);
                getRequest().setAttribute("type",userType);
                result = "toLogin";
            }
        }
        // ����Ա��¼
        else if ("admin".equals(userType)) {
            Admin admin = adminService.getAdminByUserNameAndPassword(userName,password);
            if (admin != null) {
                getSessionMap().put("userType","admin");
                getSessionMap().put("admin",admin);
                result = "success-admin";
            } else {
                getRequest().setAttribute("wrong",1);
                getRequest().setAttribute("type",userType);
                result = "toLogin";
            }
        }
        return result;
    }

    public String toLogin(){
        return "toLogin";
    }
}
