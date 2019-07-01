package com.axelor.service;

import java.util.ArrayList;
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
		Marksheet ms = new Marksheet();
		ms.setStd(std);
		ms.setMarksObtain(marksObtain);
		ms.setMarksOutOf(marksOutOf);
		int percentage2 = ((marksObtain / marksOutOf) * 100);
		ms.setPercentage(percentage2);
		ms.setStudent(student);
		
		em.get().persist(ms);
		return ms;
	}
}
