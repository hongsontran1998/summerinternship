package com.demo.configuration;


import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Properties;

@Configuration
public class EmailConfig {
    @Bean
    public VelocityEngine velocityEngine() throws IOException {
        VelocityEngine velocityEngine = new VelocityEngine();
        Properties props = new Properties();
        props.put("resource.loader", "class");
        props.put("class.resource.loader.class",
                    "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        velocityEngine.setProperties(props);
        return velocityEngine;
    }

}
