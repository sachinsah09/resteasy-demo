package com.axelor.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.axelor.db.Marksheet;
import com.axelor.db.Student;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

public class ServiceImpl implements Service {

  @Inject
  Provider<EntityManager> em;

  	@Transactional
	@Override
	public void add(String sname, int age, String std, int marksObtain, int marksOutOf) {
  	
  		int percentage1,percentage2,percentage3;
		  
  		Student student =new Student();
  		
  		Marksheet ms1=new Marksheet();
  		ms1.setStd(std);
  		ms1.setMarksObtain(marksObtain);
  		ms1.setMarksOutOf(marksOutOf);
  		percentage1=(marksObtain/marksOutOf)*100;
  		ms1.setPercentage(percentage1);
  		ms1.setStudent(student);
	
  		Marksheet ms2=new Marksheet();
  		ms2.setStd("9th");
  		ms2.setMarksObtain(600);
  		ms2.setMarksOutOf(1000);
  		percentage2=((600/1000)*100);
  		ms2.setPercentage(percentage2);
  		ms2.setStudent(student);
  		
  		Marksheet ms3=new Marksheet();
  		ms3.setStd("10th");
  		ms3.setMarksObtain(500);
  		ms3.setMarksOutOf(1000);
  		percentage3=((500/1000)*100);
  		ms3.setPercentage(percentage3);
  		ms3.setStudent(student);
  		
  		Set<Marksheet> mrSet=new HashSet<Marksheet>();
  		mrSet.add(ms3);
  		mrSet.add(ms2);
  		mrSet.add(ms1);
  	
  		student.setSname(sname);
  		student.setAge(age);
  		student.setMarksheet(mrSet);
  		
  		em.get().persist(student);
  	}

  	@Override
	@Transactional
	public List<Marksheet> getRecordsMarksheet() {
	          Query q = em.get().createQuery(" FROM Marksheet");
	          List<Marksheet> marksList = q.getResultList();
	          return marksList;  
	}
  	
  	@Transactional  	
	@Override
	public void deleteRecord(int id) {
		Student s= new Student();
		s= em.get().find(Student.class, id);
		em.get().remove(s);
	}

	@Override
	public void updateRecord(int id,String sname,int age) {
		Student student = em.get().find(Student.class, id);
  		student.setSname(sname);
  		student.setAge(age);
		 em.get().persist(student);
	}  
}
