package com.axelor.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.axelor.db.Marksheet;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

public class ServiceImpl implements Service {

  @Inject
  Provider<EntityManager> em;

  @Transactional
  @Override
  public void add(String sname, String percentage) {
      
    Marksheet ms1=new Marksheet();
    ms1.setSname(sname);
    ms1.setPercentage(percentage);      
    em.get().persist(ms1);
  }
  
  @Override
	@Transactional
	public List<Marksheet> getRecord() {
        Query q = em.get().createQuery(" FROM Marksheet");
        List<Marksheet> userList = q.getResultList();
        return userList;  
  }  
}
