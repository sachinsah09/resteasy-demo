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
import com.axelor.db.Marksheet;
import com.axelor.service.MarksheetService;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Path("/")
@Singleton
public class MarksheetController{
  
	public MarksheetService marksheetservice;
	
	public MarksheetController() {}
  
  @Inject
  public MarksheetController(MarksheetService marksheetservice){  
      this.marksheetservice=marksheetservice;
  }      
  
  @GET
  @Path("/show")
  public void show(@Context HttpServletRequest req,@Context HttpServletResponse res) throws HttpException,IOException, ServletException {
	  int id=Integer.parseInt(req.getParameter("id"));
	  List<Marksheet> mrks1=marksheetservice.getRecordsMarksheet(id);
	  
	 req.setAttribute("id",id);
	 req.setAttribute("marksheetList", mrks1);
	 req.getRequestDispatcher("/showmarksheet.jsp").forward(req, res);
	}
  
  @POST
  @GET
  @Path("/updatemrk")
  public void updatemrk(@FormParam("id") int id,@FormParam("std") String std,@FormParam("mrkobt") int markobtain,@FormParam("totalmrk") int marksoutof,@Context HttpServletRequest req,@Context HttpServletResponse res) throws HttpException,IOException, ServletException {
	Marksheet mk=  marksheetservice.updateRecord(id, std, markobtain, marksoutof);      
	//  res.sendRedirect(req.getContextPath()/show?id=mk.getMid()"retrieve");
	  res.sendRedirect(req.getContextPath()+"/show?id="+mk.getStudent().getSid());
  }  
  
  @GET
  @Path("/deletemrk/{id}")
  public void deletemrk(@PathParam("id") int id,@Context HttpServletRequest req,@Context HttpServletResponse res) throws HttpException,IOException, ServletException {
	  marksheetservice.deleteRecord(id);
	  res.sendRedirect(req.getContextPath()+"/retrieve");

	// res.sendRedirect(req.getContextPath()+"/deletemrk");
	 }
  
  @POST
  @GET
  @Path("/searchmarksheet")
  public View searchmarksheet(@FormParam("std") String std,@Context HttpServletRequest req,@Context HttpServletResponse res) throws HttpException,IOException, ServletException {
	 List<Marksheet> mrk=marksheetservice.getSearchMarksheet(std);
	 //req.setAttribute("marksheet",mrks);    
	 //req.getRequestDispatcher("display.jsp").forward(req, res);
	 return new View("showmarksheet.jsp", mrk, "marksheetList");
  }
  
  @POST
  @GET
  @Path("/addmarksheet")
  public void addmarksheet(@FormParam("id") int id,@FormParam("std") String std,@FormParam("mrkobt") int markobtain,@FormParam("totalmrk") int marksoutof,@Context HttpServletRequest req,@Context HttpServletResponse res) throws HttpException,IOException, ServletException {
	 Marksheet mk= marksheetservice.add(id, std, markobtain,marksoutof);
	 //req.setAttribute("marksheet",mrks);    
	 //req.getRequestDispatcher("display.jsp").forward(req, res);
	  res.sendRedirect(req.getContextPath()+"/show?id="+mk.getStudent().getSid());
  }
}
