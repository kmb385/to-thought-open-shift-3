package com.rhcloud.tothought;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityFilterAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ImportResource({ "classpath:/META-INF/application-context.xml"})
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, SecurityFilterAutoConfiguration.class,
		SecurityAutoConfiguration.class, MongoAutoConfiguration.class })
@ComponentScan("com.rhcloud.tothought")
@Configuration
public class BlogEmbeddedApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BlogEmbeddedApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BlogEmbeddedApplication.class);
	}

	@Bean
	public Filter openSessionInView() {
		return new OpenEntityManagerInViewFilter();
	}
/*
	@Bean
	public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
		ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
		registration.addUrlMappings("/*");
		return registration;
	}
	*/
}
