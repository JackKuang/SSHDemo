package com.hurenjieee.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hurenjieee.dao.LoginDao;
import com.hurenjieee.entity.Userr;
import com.hurenjieee.util.BaseDao;

@Service
public class LoginService {
	
	@Autowired
	LoginDao loginDao;
	
	
	/*
	 * �⴮�������ʵ��Service��Dao���������һ��,��Dao��Ĵ�������Service�С�
	 * ��Ϊ�Զ����DaoҲ�Ǽ̳���BaseDao��
	 * ���Ǹ���ʵ��ҵ���߼�������ѡ����Dao��Service����
	 * 
	private BaseDao<Userr,Integer> loginDao = new BaseDao<Userr,Integer>();
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		loginDao.setSessionFactory(sessionFactory);
	}
	*/
	
	public Userr login(String name,String password){
		return loginDao.selectByNameAndPassword(name, password);
	}
}
