package com.axelor.service;

import java.util.List;
import com.axelor.db.Student;

public interface StudentService {
	  public List<Student> getRecordsStudent();
      public void deleteRecord(int id);
      public void updateRecord(int id,String name,int age);
      public List getSearchRecord(String sname);
      public void add(String sname,int age,String std,int marksObtain,int marksOutOf);
}
