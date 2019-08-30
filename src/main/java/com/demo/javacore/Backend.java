package com.demo.javacore;

import com.demo.database.factory.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;

public class Backend {
    public static void main(String[] args) {
        JsonNode nodeCategories = JsonFactory.getJsonNode("categories");
        nodeCategories.forEach(item ->{
            System.out.println(item.asText());
            System.out.println(item.toString());
        });
    }
}
