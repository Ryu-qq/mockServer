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
                .allowedOrigins("https://3c4f-211-192-187-70.jp.ngrok.io")
                .allowedOrigins("http:localhost:8089")
                .allowedOrigins("https://app-api-stg-beborn-prod.apps.beborn-cluster.4p30.p1.openshiftapps.com")
                .allowCredentials(true)
                .allowedMethods("GET", "POST")
                .maxAge(3600);
    }
}
