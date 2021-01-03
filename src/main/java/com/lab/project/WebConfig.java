package com.lab.project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import java.util.Locale;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    //resolve static files
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/files/**") //path that is entered int url
                .addResourceLocations("/WEB-INF/pdf/"); //where to look for static file


//      First time i used index.html it would throw an error after refresh, this code fixed the issue but for
//      some reason it is not necessary anymore after I restarted the computer. Because of that i commented it out
//      but I didn't delete it.

//        registry.addResourceHandler("/**")
//                .addResourceLocations("classpath:/static/");
//                .resourceChain(true)
//                .addResolver(new PathResourceResolver() {
//                    @Override
//                    protected Resource getResource(String resourcePath, Resource location) throws IOException {
//                        Resource requestedResource = location.createRelative(resourcePath);
//                        return requestedResource.exists() && requestedResource.isReadable() ? requestedResource : new ClassPathResource("/static/index.html");
//                    }
//                });


    }



}