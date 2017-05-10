package com.hurenjieee.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.hurenjieee.entity.Admin;
import com.hurenjieee.entity.Branch;
import com.hurenjieee.entity.Collective;
import com.hurenjieee.entity.Major;
import com.hurenjieee.service.AdminService;
import com.hurenjieee.service.BranchService;
import com.hurenjieee.service.CollectiveService;
import com.hurenjieee.util.Md5AndSha;
import com.hurenjieee.util.Node;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "json") // Ӧ��ȫ�ְ�
@Scope("prototype")
@Namespace(value = "/admin")
@Action(results = { @Result(name = "json",type = "json",params = { "root", "resultMap" }) })
public class SchoolAction extends ActionSupport {

    Map<String, Object>       resultMap;

    private Branch            branch;

    private Major             major;

    @Autowired
    private BranchService     branchService;
    @Autowired
    private CollectiveService collectiveService;
    @Autowired
    private AdminService adminService;

    private String oldPassword;
    private String newPassword;
    private String confirmPassword;
    public String testJson(){
        resultMap = new HashMap<String, Object>();
        Admin admin = new Admin();
        admin.setAdmName("admin");
        admin.setAdmPicture("12333");
        resultMap.put("admin",admin);
        return "json";
    }

    public Map<String, Object> getResultMap(){
        return resultMap;
    }

    public void setResultMap(Map<String, Object> resultMap){
        this.resultMap = resultMap;
    }

    public Branch getBranch(){
        return branch;
    }

    public void setBranch(Branch branch){
        this.branch = branch;
    }

    public Major getMajor(){
        return major;
    }

    public void setMajor(Major major){
        this.major = major;
    }

    public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String listAll(){
        try {
            resultMap = new HashMap<>();
            List<Node> listNode = new ArrayList<Node>();
            //��ȡ�����з�Ժ��Ϣ�Լ���Ժ�µ�����רҵ
            List<Branch> branchs = branchService.getList();
            for ( Branch branch : branchs ) {
                Node node = new Node();
                node.setText(branch.getBraName());
                node.setId(branch.getBraId());
                List<Node> listNode2 = new ArrayList<Node>();
                for ( Major major : branch.getMajors() ) {
                    Node node2 = new Node();
                    node2.setText(major.getMajName());
                    node2.setId(major.getMajId());
                    // ��ȡ���÷�Ժ�µ����а༶
                    List<Collective> collectives = collectiveService.selectListByMajId(major.getMajId());
                    List<Node> listNode3 = new ArrayList<Node>();
                    for ( Collective collective : collectives ) {
                        boolean has = false;
                        // ѭ��node�ж��Ƿ��д���
                        for ( Node node3 : listNode3 ) {
                            if (node3.getText().equals(""+collective.getColYear())) {
                                Node node4 = new Node();
                                node4.setText(collective.getColName());
                                node4.setId(collective.getColId());
                                node3.getNodes().add(node4);
                                has = true;
                            }
                        }
                        // ��������������
                        if (has == false) {
                            Node node3 = new Node();
                            node3.setNodes(new ArrayList<Node>());
                            Node node4 = new Node();
                            node4.setText(collective.getColName());
                            node4.setId(collective.getColId());
                            node3.getNodes().add(node4);
                            node3.setText(collective.getColYear()+"");
                            listNode3.add(node3);
                        }
                    }
                    node2.setNodes(listNode3);
                    listNode2.add(node2);
                }
                node.setNodes(listNode2);
                listNode.add(node);
            }
            resultMap.put("result","succeess");
            resultMap.put("content",listNode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "json";
    }
	
	public String updatePassword(){
		try {
            resultMap = new HashMap<>();
	        ActionContext actionContext = ActionContext.getContext();
	        Map<String, Object> sessionMap = actionContext.getSession();
	        Admin admin = (Admin)sessionMap.get("admin");
			if(!Md5AndSha.convertMD5(oldPassword).equals(admin.getAdmPassword())){
	            resultMap.put("result","fail");
	            resultMap.put("reason","���������");
	    		return "json";
			}
			if(!newPassword.equals(confirmPassword)){
	            resultMap.put("result","fail");
	            resultMap.put("reason","��������ȷ�����벻һ��");
	    		return "json";
			}
			admin.setAdmPassword(Md5AndSha.convertMD5(newPassword));
			sessionMap.put("admin", admin);
			adminService.updatePassword(admin);
            resultMap.put("result","success");
            resultMap.put("reason","�ɹ�");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("result","fail");
            resultMap.put("reason","δ֪����");
		}
		return "json";
	}

}
