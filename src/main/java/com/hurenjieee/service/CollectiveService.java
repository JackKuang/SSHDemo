package com.hurenjieee.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hurenjieee.entity.Collective;
import com.hurenjieee.util.BaseDao;

@Service
@Transactional
public class CollectiveService extends BaseService<Collective, Long> {

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        BaseDao<Collective, Long> dao = new BaseDao<Collective, Long>();
        dao.setSessionFactory(sessionFactory);
        setDao(dao);
    }
    
    public List<Collective> selectListByMajId(Long colMajId){
        return getDao().getListByHQL("from Collective c where c.colMajId = ? order by c.colYear desc",colMajId);
    }
}
