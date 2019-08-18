package com.demo.configuration;

import freemarker.template.TemplateException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

import java.io.IOException;

@Configuration
public class FreemarkerConfig {
    /*spring lo rồi không cần tạo bean nữa*/
   /*@Bean
    public freemarker.template.Configuration getFreeMarkerConfiguration() throws IOException, TemplateException {
        FreeMarkerConfigurationFactoryBean bean = new FreeMarkerConfigurationFactoryBean();
        bean.setTemplateLoaderPath("/templates/");
        return bean.createConfiguration();
    }*/
}