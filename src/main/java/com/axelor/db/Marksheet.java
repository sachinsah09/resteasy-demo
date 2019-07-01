package com.axelor.db;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Marksheet {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int mid;
    String std;
    int marksObtain;
    int marksOutOf;
    int percentage;
  
    @ManyToOne
    private Student student;
  
    public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	
	public int getPercentage() {
		return percentage;
	}
	public int getMarksOutOf() {
		return marksOutOf;
	}
	public void setMarksOutOf(int marksOutOf) {
		this.marksOutOf = marksOutOf;
	}
	public int getMarksObtain() {
		return marksObtain;
	}
	public void setMarksObtain(int marksObtain) {
		this.marksObtain = marksObtain;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	public String getStd() {
		return std;
	}
	public void setStd(String std) {
		this.std = std;
	}
}