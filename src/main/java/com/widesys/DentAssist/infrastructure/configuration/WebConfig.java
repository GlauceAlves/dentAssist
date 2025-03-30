package com.widesys.DentAssist.infrastructure.configuration;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configurable
public class WebConfig extends WebMvcConfigurationSupport {
//	 @Override
//	    public void addCorsMappings(CorsRegistry registry) {
//	        registry.addMapping("/**").allowedOrigins("http://localhost:3309");
//	    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8081")  
                .allowedMethods("GET", "POST", "PUT", "DELETE")   
                .allowedHeaders("*")   
                .allowCredentials(true);  
    }	

}
