package com.axelor.module;

import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletContext;
import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;
import com.axelor.service.MarksheetService;
import com.axelor.service.MarksheetServiceImpl;
import com.axelor.service.StudentService;
import com.axelor.service.StudentServiceImpl;
import com.axelor.web.MarksheetController;
import com.axelor.web.StudentController;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;

public class Listener extends GuiceResteasyBootstrapServletContextListener{
  
  @Override
  protected List<? extends Module> getModules(ServletContext context){
         return Arrays.asList(new JpaPersistModule("persist"), new AbstractModule() {
           protected void configure() {
             bind(StudentController.class);
             bind(MarksheetController.class);
             bind(StudentService.class).to(StudentServiceImpl.class);
             bind(MarksheetService.class).to(MarksheetServiceImpl.class);
           }
      });
     }
   
     @Override
     public void withInjector(Injector injector)
     {
         injector.getInstance(PersistService.class).start();
     }
  }

