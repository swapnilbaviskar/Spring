package com.scp.springcrudannotation.config;


import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.context.ApplicationListener;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
 
public class WebXmlInitialiser implements WebApplicationInitializer {
 
	static{
		System.out.println("inside WebAppInitializer");
	}
		public void onStartup(ServletContext container) {
          // Create the 'root' Spring application context
          AnnotationConfigWebApplicationContext rootContext =
            new AnnotationConfigWebApplicationContext();
          rootContext.register(SpringServletXml.class);

          // Manage the lifecycle of the root application context
          	container.addListener(new ContextLoaderListener(rootContext));



          // Create the dispatcher servlet's Spring application context
          AnnotationConfigWebApplicationContext dispatcherContext =
            new AnnotationConfigWebApplicationContext();
          dispatcherContext.register(SpringServletXml.class);

          // Register and map the dispatcher servlet
          ServletRegistration.Dynamic dispatcher =
            container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
          dispatcher.setLoadOnStartup(1);
          dispatcher.addMapping("/");
        }

     
 
 }
