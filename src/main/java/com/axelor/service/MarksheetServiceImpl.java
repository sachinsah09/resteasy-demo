package com.axelor.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.axelor.db.Marksheet;
import com.axelor.db.Student;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

public class MarksheetServiceImpl implements MarksheetService{

	@Inject
	Provider<EntityManager> em;
	
	@Override
	@Transactional
	public List<Marksheet> getRecordsMarksheet(int id) {
		Student student = em.get().find(Student.class, id);
		List<Marksheet> marksList = student.getMarksheet();
		return marksList;
	}

	@Override
	@Transactional
	public void deleteRecord(int id) {
		Query query = em.get().createQuery("DELETE FROM Marksheet m WHERE m.id="+id);
		query.executeUpdate();
		
//		Marksheet m=new Marksheet();
//		m = em.get().find(Marksheet.class, id);
//		em.get().remove(m);	
	}
	
	@Override
	@Transactional
	public Marksheet updateRecord(int id, String std, int marksObtain, int marksOutOf) {
		Marksheet marksheet = em.get().find(Marksheet.class, id);
		marksheet.setStd(std);
		marksheet.setMarksObtain(marksObtain);
		marksheet.setMarksOutOf(marksOutOf);
		em.get().persist(marksheet);
		return marksheet;
	}

	@Override
	public List getSearchMarksheet(String std) {
		List list = em.get().createQuery("from Marksheet m where m.std LIKE '"+ std + "%'").getResultList();
		return list;
	}
	
	@Override
	@Transactional
	public Marksheet add(int id, String std, int marksObtain, int marksOutOf) {
		Student student = em.get().find(Student.class, id);
		Marksheet marksheet = new Marksheet();
		marksheet.setStd(std);
		marksheet.setMarksObtain(marksObtain);
		marksheet.setMarksOutOf(marksOutOf);
		int percentage2 = ((marksObtain / marksOutOf) * 100);
		marksheet.setPercentage(percentage2);
		marksheet.setStudent(student);
		
		em.get().persist(marksheet);
		return marksheet;
	}
}
