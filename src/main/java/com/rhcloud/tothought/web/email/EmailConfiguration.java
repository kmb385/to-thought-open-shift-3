package com.rhcloud.tothought.web.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailConfiguration {

	public static final boolean IS_EMAIL_ENABLED = false;
	
	public static final String DEV_ENVIRONMENT = "DEV";

	@Value("${tothought_env}")
	private String environment;
	
	@Value("${email_username}")
	private String username;
	
	@Value("${email_password}")
	private String password;
	
	@Value("${email_host}")
	private String host;
	
	@Value("${email_port}")
	private String port;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

}
