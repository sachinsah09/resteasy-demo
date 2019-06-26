package com.axelor.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Marksheet {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int sid;
    String sname;
    String percentage;

      public int getSid() {
      return sid;}
      public void setSid(int sid) {
      this.sid = sid;}
      public String getSname() {
      return sname;}
      public void setSname(String sname) {
      this.sname = sname;}
      public String getPercentage() {
      return percentage;}
      public void setPercentage(String percentage) {
      this.percentage = percentage;}
}

