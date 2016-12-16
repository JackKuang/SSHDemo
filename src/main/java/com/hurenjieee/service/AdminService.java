package com.hurenjieee.service;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hurenjieee.entity.Admin;
import com.hurenjieee.util.BaseDao;

@Service
@Transactional
public class AdminService extends BaseService<Admin, String> {
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		BaseDao<Admin,String> dao = new BaseDao<Admin,String>();
		dao.setSessionFactory(sessionFactory);
		setDao(dao);
	}
	
	public Admin getAdminByUserNameAndPassword(String userName,String password){
		return getDao().getByHQL("from Admin a where a.admName = '" + userName + "' and a.admPassword = '" + password+"'");
	}
}