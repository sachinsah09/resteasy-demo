package com.axelor.service;

import java.util.List;
import com.axelor.db.Marksheet;
import com.axelor.db.Student;

public interface Service {
	  public void add(String sname,int age,String std,int marksObtain,int marksOutOf);
      public List<Marksheet> getRecordsMarksheet();
      public void deleteRecord(int id);
      public void updateRecord(int id,String name,int age);
}
