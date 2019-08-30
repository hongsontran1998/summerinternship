package com.demo.javacore;

import com.demo.database.factory.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class Backend {
    public static void main(String[] args) throws IOException {
//        JsonNode nodeCategories = JsonFactory.getJsonNode("categories");
//        System.out.println(nodeCategories.toString());
//
//        ObjectMapper mapper = new ObjectMapper();
//        ArrayList<String> categoryNames = mapper.readValue(nodeCategories.toString(), ArrayList.class);
//        System.out.println(categoryNames);
//
//        nodeCategories.forEach(item ->{
//            System.out.println(item.asText());
//            System.out.println(item.toString());
//        });
        Faker faker = new Faker(new Locale("vi"));
        for (int i = 0; i < 10; i++) {
            System.out.println(faker.animal().name());
            System.out.println(faker.cat().name());
            System.out.println(faker.internet().emailAddress());
            System.out.println(faker.internet().domainName());
            System.out.println(faker.internet().ipV4Address());
            System.out.println(faker.internet().avatar());
            System.out.println(faker.internet().password());
            System.out.println(faker.book().author());
            System.out.println(faker.color().name());
            System.out.println("=================");
        }
    }
}
