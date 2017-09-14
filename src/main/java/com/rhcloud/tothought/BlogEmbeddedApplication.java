package com.rhcloud.tothought;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityFilterAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;

@SpringBootApplication
@ImportResource({ "classpath:/META-INF/application-context.xml", "classpath:/META-INF/servlet-context.xml" })
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, WebMvcAutoConfiguration.class,
		SecurityFilterAutoConfiguration.class,SecurityAutoConfiguration.class })
@Configuration
public class BlogEmbeddedApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogEmbeddedApplication.class, args);
	}

	@Bean
	public Filter openSessionInView() {
		return new OpenEntityManagerInViewFilter();
	}

}
