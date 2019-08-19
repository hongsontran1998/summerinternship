package com.demo.configuration;

import org.springframework.context.annotation.Configuration;

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