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
		Query query = em.get().createQuery(" FROM Student");
		List<Student> marksList = query.getResultList();
		return marksList;
	}

	@Override
	@Transactional
	public void deleteRecord(int id) {
		Student student=new Student();
		student = em.get().find(Student.class, id);
		em.get().remove(student);
	}
	
	@Override
	@Transactional
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
			Marksheet marksheet = new Marksheet();
			marksheet.setStd(std);
			marksheet.setMarksObtain(marksObtain);
			marksheet.setMarksOutOf(marksOutOf);
			percentage = (marksObtain / marksOutOf) * 100;
			marksheet.setPercentage(percentage);
			marksheet.setStudent(student);

			List<Marksheet> marksheetList = new ArrayList<Marksheet>();
			marksheetList.add(marksheet);

			student.setSname(sname);
			student.setAge(age);
			student.setMarksheet(marksheetList);

			em.get().persist(student);
		} else {
			Student student = new Student();
			int id = (int) list.get(0);
			student = em.get().find(Student.class, id);

			Marksheet marksheet = new Marksheet();
			marksheet.setStd(std);
			marksheet.setMarksObtain(marksObtain);
			marksheet.setMarksOutOf(marksOutOf);
			int percentage2 = ((marksObtain / marksOutOf) * 100);
			marksheet.setPercentage(percentage2);
			marksheet.setStudent(student);

			em.get().persist(marksheet);
		}
	}
}