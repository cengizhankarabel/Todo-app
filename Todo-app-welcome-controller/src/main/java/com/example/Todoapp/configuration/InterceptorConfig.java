package com.example.Todoapp.configuration;

import com.example.Todoapp.intercetor.CustomRequestInterceptor;
import com.example.Todoapp.intercetor.WelcomeInterceptor;
import com.example.Todoapp.web.WelcomeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {


    @Autowired
    private CustomRequestInterceptor customRequestInterceptor;

    @Autowired
    private WelcomeInterceptor welcomeInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(customRequestInterceptor).addPathPatterns("/todos/**");
        registry.addInterceptor(welcomeInterceptor).addPathPatterns("/welcome");
    }
}
