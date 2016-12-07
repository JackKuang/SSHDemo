package com.hurenjieee.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "userr")
public class Userr implements Serializable{
//	��������£�ʵ�������Ҫ���л�
//	
//	@Id
//	@Column(name="userId")
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Integer userId;
//	�ۺϿ���֮�£�ѡ����ʹ��uuid��Ϊ����
	
	@Id	
	@GenericGenerator(name="systemUUID",strategy="uuid")
	@GeneratedValue(generator="systemUUID")
	@Column(name="uuid")
	private String uuid;
	
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "passWord")
	private String passWord;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	
}
