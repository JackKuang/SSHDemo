package com.hurenjieee.service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hurenjieee.entity.Dictionary;
import com.hurenjieee.util.BaseDao;

@Service
public class BaseService<T, ID extends Serializable>{
	private BaseDao<T, ID> dao;

	public BaseDao<T, ID> getDao() {
		return dao;
	}

	public void setDao(BaseDao<T, ID> dao) {
		this.dao = dao;
	}
	
	//-----------ֱ�ӵ���Dao  ��ʼ-----------------
	public Serializable save(T t){
		return getDao().save(t);
	}
	
	public void saveOrUpdate(T t){
		getDao().saveOrUpdate(t);
	}
	
	public T get(ID id) {
		return getDao().get(id);
	}

	public boolean contains(T t){
		return getDao().contains(t);
	}

	public void delete(T t){
		getDao().delete(t);
	}
	
	public void deleteById(ID id){
		getDao().deleteById(id);
	}
	
	public void DeleteAll(Collection<T> entities){
		getDao().deleteAll(entities);
	}
	
	public Serializable insert(T t){
		return getDao().save(t);		
	}
	
	public void update(T t){
		dao.update(t);
	}
	
	public T getById(ID id){
		return dao.get(id);
	}

	//-----------ֱ�ӵ���Dao  ����-----------------
	
	
	//-----------�Զ��巽��         ��ʼ-------------------
	@SuppressWarnings("unchecked")
	public List<Dictionary> getList(){
		
		Type type = getClass().getGenericSuperclass();  
        Type trueType = ((ParameterizedType) type).getActualTypeArguments()[0];  
        Class<T> entityClass=(Class<T>) trueType;
        String tName = entityClass.getSimpleName();
        
		return (List<Dictionary>) dao.getListByHQL("FROM "+tName+" WHERE 1=1");
	}

	//-----------�Զ��巽��         ����-------------------
}
