package com.axelor.web;

import java.io.IOException;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import org.apache.http.HttpException;
import org.jboss.resteasy.annotations.jaxrs.FormParam;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.axelor.db.Marksheet;
import com.axelor.service.Service;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Path("/")
@Singleton
public class Controller{
  
  public Service service;
  
  public Controller() {
  }
  
  @Inject
  public Controller(Service service){  
      this.service=service;
  }      
 
  @POST
  @Path("/insert")
  public void insert(@FormParam("sname") String sname,@FormParam("age") int age,@FormParam("std") String std,@FormParam("marksObtain") int marksObtain,@FormParam("marksOutOf") int marksOutOf,@Context HttpServletRequest req,@Context HttpServletResponse res) throws HttpException,IOException {
             service.add(sname,age,std,marksObtain,marksOutOf);
             res.getWriter().print("successfull");
  }
  
  @GET
  @Path("/retrieve")
  public void retrieve(@Context HttpServletRequest req,@Context HttpServletResponse res) throws HttpException,IOException, ServletException {
	 List<Marksheet> mrks=service.getRecordsMarksheet();
	 req.setAttribute("marksheet",mrks);    
	 req.getRequestDispatcher("display.jsp").forward(req, res);  
  }
  
  @GET
  @Path("/delete/{id}")
  public void delete(@PathParam("id") int id,@Context HttpServletRequest req,@Context HttpServletResponse res) throws HttpException,IOException, ServletException {
	 service.deleteRecord(id);      
  }
  
  @POST
  @Path("/update")
  public void update(@FormParam("id") int id,@FormParam("sname") String sname,@FormParam("age") int age,@Context HttpServletRequest req,@Context HttpServletResponse res) throws HttpException,IOException, ServletException {
	 service.updateRecord(id,sname,age);      
  }
}
