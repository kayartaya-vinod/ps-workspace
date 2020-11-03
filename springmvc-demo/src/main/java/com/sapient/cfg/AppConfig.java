package com.sapient.cfg;

import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sapient.entity.Employee;


/*
 * @ComponentScan scans all specified package and sub packages and loads instances of 
 * class annotated with @Controller, @Service, @Repository, @Component, @RestController, @Configuration
 */
@Configuration
@ComponentScan(basePackages = {"com.sapient.web", "com.sapient.dao"})
@EnableWebMvc
@PropertySource("classpath:db.properties")
public class AppConfig implements WebApplicationInitializer, WebMvcConfigurer{
	
	@Value("${jdbc.driverClassName}")
	private String driverClassName;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	
	// connection pool
	@Bean DataSource dataSource() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName(this.driverClassName);
		bds.setUrl(this.url);
		bds.setUsername(this.username);
		bds.setPassword(this.password);
		return bds;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource ds) { // dependency injection
		LocalSessionFactoryBean lsfb=new LocalSessionFactoryBean();
		lsfb.setDataSource(ds); // manual wiring
		lsfb.setAnnotatedClasses(Employee.class);
		
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.format_sql", "true");
		
		lsfb.setHibernateProperties(props);
		
		return lsfb;
	}
	
	@Bean
	public HibernateTemplate template(SessionFactory factory) {
		return new HibernateTemplate(factory);
	}
	
	
	// requests unknown to dispatcher-servlet/handler-mapping are now
	// delegated web container (ex: tomcat)
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver irvr = new InternalResourceViewResolver();
		irvr.setPrefix("/WEB-INF/views/");
		irvr.setSuffix(".jsp");
		return irvr;
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// on startup of your application, do the following:
		// 1. create a spring web container, and load all beans from AppConfig
		// 2. create the front-controller, dispatcher-servlet and 
		// 3. register the spring container with front controller
		AnnotationConfigWebApplicationContext ctx;
		ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(AppConfig.class);
		
		Dynamic ds = servletContext.addServlet("ds", new DispatcherServlet(ctx));
		ds.addMapping("/"); // handle all requests
		ds.setLoadOnStartup(1);
	}

}
