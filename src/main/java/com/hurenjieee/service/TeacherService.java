package com.hurenjieee.service;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hurenjieee.entity.Student;
import com.hurenjieee.entity.Teacher;
import com.hurenjieee.util.BaseDao;
import com.hurenjieee.util.Md5AndSha;

@Service
@Transactional
public class TeacherService extends BaseService<Teacher, Long> {

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        BaseDao<Teacher, Long> dao = new BaseDao<Teacher, Long>();
        dao.setSessionFactory(sessionFactory);
        setDao(dao);
    }

    public Teacher getTeacherByUsernameAndPassword(String userName,String password){
        return getDao().getByHQL("from Teacher t where t.teaNo = '" + userName + "' and t.teaPassword = '" + password + "'");
    }
    
    public Teacher selectByBraId(Teacher teacher){
        return getDao().getByHQL("from Teacher t where t.teaId =  ? ",teacher.getTeaId());
    }
    
    public void saveOrUpdate(Teacher teacher){
    	if(teacher.getTeaId()==0 || "".equals(teacher.getTeaPassword()))
    		teacher.setTeaPassword(Md5AndSha.convertMD5("123456"));
        getDao().saveOrUpdate(teacher);
    }
}
