package com.mockserver.login;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedHeaders("Access-Control-Request-Method","Access-Control-Request-Headers","token","Content-Type","X-Requested-With","accept,Origin")
                .allowedOriginPatterns("*");

    }
}
