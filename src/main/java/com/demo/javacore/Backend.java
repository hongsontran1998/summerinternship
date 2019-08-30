package com.demo.javacore;

import com.demo.database.factory.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;

public class Backend {
    public static void main(String[] args) throws IOException {
        JsonNode nodeCategories = JsonFactory.getJsonNode("categories");
        System.out.println(nodeCategories.toString());

        ObjectMapper mapper = new ObjectMapper();
        ArrayList<String> categoryNames = mapper.readValue(nodeCategories.toString(), ArrayList.class);
        System.out.println(categoryNames);

        nodeCategories.forEach(item ->{
            System.out.println(item.asText());
            System.out.println(item.toString());
        });
    }
}
