package com.axelor.module;

import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletContext;
import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;
import com.axelor.service.Service;
import com.axelor.service.ServiceImpl;
import com.axelor.web.Controller;
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
             bind(Controller.class);
             bind(Service.class).to(ServiceImpl.class);          
           }
      }
         );
     }
   
     @Override
     public void withInjector(Injector injector)
     {
         injector.getInstance(PersistService.class).start();
     }
  }

