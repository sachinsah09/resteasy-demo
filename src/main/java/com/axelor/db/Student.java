package com.axelor.db;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int sid;
	String sname;
	int age;
	
	@OneToMany(mappedBy = "student" ,orphanRemoval=true, fetch=FetchType.EAGER)	
	private List<Marksheet> marksheet;
	
	public List<Marksheet> getMarksheet() {
		return marksheet;
	}
	public void setMarksheet(List<Marksheet> marksheet) {
		this.marksheet = marksheet;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
