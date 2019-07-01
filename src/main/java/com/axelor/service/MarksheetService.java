package com.axelor.service;

import java.util.List;
import com.axelor.db.Marksheet;

public interface MarksheetService {
	public List<Marksheet> getRecordsMarksheet(int id);
	public void deleteRecord(int id);
    public Marksheet updateRecord(int id,String std,int markobtain,int marksoutof);
	public List getSearchMarksheet(String std);
	public Marksheet add(int id, String std, int marksObtain, int marksOutOf);
}
