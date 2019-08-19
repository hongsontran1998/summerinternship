package com.demo.configuration;


import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoDbConfig {

    /*nếu không có thì lấy mặc định của spring boot: vì đã config trong file properties rồi*/
    /*@Bean
    public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory, MongoMappingContext context) {
        MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory), context);
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory, converter);
        return mongoTemplate;

    }*/

}
