package com.scp.springcrudannotation.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/*
 * 
 * Spring-servlet

*/
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
//@PropertySource("classpath:message.properties")
@ComponentScan(basePackages = { "com.scp" })
public class SpringServletXml extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	//using properties file 
	@Bean
	   public static PropertySourcesPlaceholderConfigurer
	     propertySourcesPlaceholderConfigurer() {
	      return new PropertySourcesPlaceholderConfigurer();
	   }
	
	
	
	
	/*
	 * <Bean>
	 * 
	 * @bean
	 * 
	 * @componenent
	 * 
	 * @Service
	 * 
	 * @repository
	 * 
	 * @Controller
	 * 
	 * new Object
	 * 
	 * <beans:bean
	 * class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	 * <beans:property name="prefix" value="/WEB-INF/views/" /> <beans:property
	 * name="suffix" value=".jsp" /> </beans:bean>
	 */


    @Autowired
    private Environment environment;
	
	//datasource
    @Bean
    public DriverManagerDataSource configureDatabase(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("url"));
        dataSource.setUsername(environment.getRequiredProperty("username"));
        dataSource.setPassword(environment.getRequiredProperty("password"));
    	return dataSource;
    }
    //hibernate session factory
    @Bean
    public LocalSessionFactoryBean hibernateConfig(){
    	LocalSessionFactoryBean localSessionFactory = new LocalSessionFactoryBean();
    	
    	localSessionFactory.setDataSource(configureDatabase());
    	
    	Properties properties = new Properties();
    	properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
    	properties.setProperty("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto") );
    	localSessionFactory.setHibernateProperties(properties);
    
    	localSessionFactory.setPackagesToScan(new String[] {"com.demo"});
    	
    	return localSessionFactory;
    	
    }
	//transaction
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(s);
       return txManager;
    }
	@Bean
	public InternalResourceViewResolver jspViewResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		return bean;
	}

	/*
	 * @Bean(name = "multipartResolver") public CommonsMultipartResolver
	 * getMultipartResolver() { return new CommonsMultipartResolver(); }
	 */

	@Bean(name = "messageSource")
	public ReloadableResourceBundleMessageSource getMessageSource() {
		ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
		resource.setBasename("classpath:messages");
		resource.setDefaultEncoding("UTF-8");
		return resource;
	}

	/**
	 * <beans:bean id="messageSource" class=
	 * "org.springframework.context.support.ReloadableResourceBundleMessageSource">
	 * <beans:property name="basename" value="classpath:message" />
	 * <beans:property name="defaultEncoding" value="UTF-8" /> </beans:bean>
	 * 
	 * 
	 */

}