package com.axelor.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import org.apache.http.HttpException;
import org.jboss.resteasy.annotations.jaxrs.FormParam;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.plugins.providers.html.View;
import com.axelor.db.Student;
import com.axelor.service.StudentService;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Path("/")
@Singleton
public class StudentController {
  
  public StudentService studentservice;
  public StudentController() {}
  
  @Inject
  public StudentController(StudentService studentservice){  
      this.studentservice=studentservice;
  }      
 
  @POST
  @Path("/insert")
  public void insert(@FormParam("sname") String sname,@FormParam("age") int age,@FormParam("std") String std,@FormParam("marksObtain") int marksObtain,@FormParam("marksOutOf") int marksOutOf,@Context HttpServletRequest req,@Context HttpServletResponse res) throws HttpException,IOException {
            studentservice.add(sname,age,std,marksObtain,marksOutOf);
             res.getWriter().print("successfull");
             res.sendRedirect("retrieve");
  }
  
  @POST
  @GET
  @Path("/retrieve")
  public View retrieve(@Context HttpServletRequest req,@Context HttpServletResponse res) throws HttpException,IOException, ServletException {
	 List<Student> stud=studentservice.getRecordsStudent();
	 //req.setAttribute("marksheet",mrks);    
	 //req.getRequestDispatcher("display.jsp").forward(req, res);
	 return new View("showstudent.jsp", stud, "studentList");
  }
  
  @GET
  @Path("/delete/{id}")
  public void delete(@PathParam("id") int id,@Context HttpServletRequest req,@Context HttpServletResponse res) throws HttpException,IOException, ServletException {
	 studentservice.deleteRecord(id);
	 res.sendRedirect(req.getContextPath()+"/retrieve");
	 }
  
  @POST
  @GET
  @Path("/update")
  public void update(@FormParam("id") int id,@FormParam("sname") String sname,@FormParam("age") int age,@Context HttpServletRequest req,@Context HttpServletResponse res) throws HttpException,IOException, ServletException {
	  studentservice.updateRecord(id,sname,age);      
	  res.sendRedirect("retrieve");
  }
  
  @POST
  @GET
  @Path("/searchstudent")
  public View searchstudent(@FormParam("sname") String sname,@Context HttpServletRequest req,@Context HttpServletResponse res) throws HttpException,IOException, ServletException {
	 List<Student> stud=studentservice.getSearchRecord(sname);
	 //req.setAttribute("marksheet",mrks);    
	 //req.getRequestDispatcher("display.jsp").forward(req, res);
	 return new View("showstudent.jsp", stud, "studentList");
  }
}
