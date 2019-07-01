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

public class StudentServiceImpl implements StudentService{
	
	@Inject
	Provider<EntityManager> em;
	
	@Override
	@Transactional
	public List<Student> getRecordsStudent() {
		Query q = em.get().createQuery(" FROM Student");
		List<Student> marksList = q.getResultList();
		return marksList;
	}

	@Transactional
	@Override
	public void deleteRecord(int id) {
		Student s;
		s = em.get().find(Student.class, id);
		em.get().remove(s);
	}

	@Transactional
	@Override
	public void updateRecord(int id, String sname, int age) {
		Student student = em.get().find(Student.class, id);
		student.setSname(sname);
		student.setAge(age);
		em.get().persist(student);
	}

	@Override
	public List getSearchRecord(String sname) {
		List list = em.get().createQuery("from Student p where p.sname LIKE '"+ sname + "%'").getResultList();
		return list;
	}
	

	@Transactional
	@Override
	public void add(String sname, int age, String std, int marksObtain, int marksOutOf) {

		List list = em.get().createQuery("select id from Student p where p.sname='" + sname + "'").getResultList();
		System.out.println(list);
		if (list.isEmpty()) {
			int percentage;

			Student student = new Student();
			Marksheet ms = new Marksheet();
			ms.setStd(std);
			ms.setMarksObtain(marksObtain);
			ms.setMarksOutOf(marksOutOf);
			percentage = (marksObtain / marksOutOf) * 100;
			ms.setPercentage(percentage);
			ms.setStudent(student);

			List<Marksheet> mrSet = new ArrayList<Marksheet>();
			mrSet.add(ms);

			student.setSname(sname);
			student.setAge(age);
			student.setMarksheet(mrSet);

			em.get().persist(student);
		} else {
			Student student = new Student();
			int id = (int) list.get(0);
			student = em.get().find(Student.class, id);

			Marksheet ms2 = new Marksheet();
			ms2.setStd(std);
			ms2.setMarksObtain(marksObtain);
			ms2.setMarksOutOf(marksOutOf);
			int percentage2 = ((marksObtain / marksOutOf) * 100);
			ms2.setPercentage(percentage2);
			ms2.setStudent(student);

			em.get().persist(ms2);
		}
	}
}