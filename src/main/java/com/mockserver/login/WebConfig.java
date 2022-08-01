package com.mockserver.login;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**")
                .allowedOrigins("http://localhost:8089", "https://app-api-stg-beborn-prod.apps.beborn-cluster.4p30.p1.openshiftapps.com", "https://211.192.187.70", "211.192.187.70", "http://211.192.187.70" )

                .allowedHeaders("*")
                .allowedMethods("GET", "POST")
                .allowCredentials(true) ;
    }
}
