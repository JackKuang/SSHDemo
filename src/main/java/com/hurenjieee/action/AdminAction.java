package com.hurenjieee.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.hurenjieee.entity.Branch;
import com.hurenjieee.service.BranchService;
import com.hurenjieee.service.MajorService;
import com.opensymphony.xwork2.ActionSupport;

// ������඼��action��ת
@ParentPackage(value = "all") // Ӧ��ȫ�ְ�
@Scope("prototype")
@Namespace(value = "/admin")
@Action(results = { @Result(name = "index",location = "/WEB-INF/jsp/admin/index.jsp"),
        @Result(name = "systemDetail",location = "/WEB-INF/jsp/admin/systemDetail.jsp"),
        @Result(name = "systemConfig",location = "/WEB-INF/jsp/admin/systemConfig.jsp"),
        @Result(name = "teacherManager",location = "/WEB-INF/jsp/admin/teacherManager.jsp"),
        @Result(name = "studentManager",location = "/WEB-INF/jsp/admin/studentManager.jsp"),
        @Result(name = "detail",location = "/WEB-INF/jsp/admin/detail.jsp") })
public class AdminAction extends ActionSupport {

    String flag;
    
    @Autowired
    BranchService branchService;
    @Autowired
    MajorService majorService;
    
    private List<Branch> branchList;
    
    public String index(){
        return "index";
    }

    public String redirectPage(){
        //ϵͳ��Ϣ
        if ("systemDetail".equals(flag)) {
            //ϵͳ��Ϣ
            return "systemDetail";
        } else if ("systemConfig".equals(flag)) {
            //ϵͳ�������
            systemConfig();
            return "systemConfig";
        } else if ("teacherManager".equals(flag)) {
            //��ʦ����
            systemConfig();
            return "teacherManager";
        } else if ("studentManager".equals(flag)) {
           //ѧ������
            systemConfig();
            return "studentManager";
        } else {
            return "detail";
        }
    }
    
    public void systemConfig(){
        branchList = branchService.getList();
    }
    
    public String getFlag(){
        return flag;
    }

    public void setFlag(String flag){
        this.flag = flag;
    }

    public List<Branch> getBranchList(){
        return branchList;
    }

    
    public void setBranchList(List<Branch> branchList){
        this.branchList = branchList;
    }
    
    
    
}
