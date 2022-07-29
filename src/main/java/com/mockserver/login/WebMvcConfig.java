package com.mockserver.login;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("https://app-api-stg-beborn-prod.apps.beborn-cluster.4p30.p1.openshiftapps.com")
                .allowedMethods("GET,POST,PUT,DELETE,OPTIONS")
                .maxAge(3600);
    }
}
