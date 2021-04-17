package com.backend.valid.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Value("${valid-front-end-url}")
	private String frontEndUrl;
	
	public String getFrontEndUrl() {
		return frontEndUrl;
	}
	
	public void setFrontEndUrl(String frontEndUrl) {
		this.frontEndUrl = frontEndUrl;
	}

}
