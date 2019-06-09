package com.demo.javacore;

import com.demo.entity.Category;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            //json to object
            Category category = mapper.readValue("{\"id\" : \"1\", \"name\" : \"name\"}", Category.class);
            System.out.println(category);
            //object to json
            String json = mapper.writeValueAsString(category);
            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
