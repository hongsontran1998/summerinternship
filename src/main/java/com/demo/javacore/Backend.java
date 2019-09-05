package com.demo.javacore;

import com.demo.database.factory.JsonFactory;
import com.demo.entity.Article;
import com.demo.repository.specification.CategorySpecificationsBuilder;
import com.demo.util.SlugUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.github.javafaker.Faker;
//import org.apache.axis.encoding.Base64;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
//        Faker faker = new Faker(new Locale("vi"));
//        for (int i = 0; i < 10; i++) {
//            System.out.println(faker.animal().name());
//            System.out.println(faker.cat().name());
//            System.out.println(faker.internet().emailAddress());
//            System.out.println(faker.internet().domainName());
//            System.out.println(faker.internet().ipV4Address());
//            System.out.println(faker.internet().avatar());
//            System.out.println(faker.internet().password());
//            System.out.println(faker.book().author());
//            System.out.println(faker.color().name());
//            System.out.println("=================");
//        }
//        String encode = Base64.encode(("Một ví dụ sử dụng thư viện Apache Axis để mã hóa (encode) " +
//                "và giải mã (decode) một đoạn văn bản:").getBytes("UTF-8"));
//        System.out.println(encode);
//
//        byte[] bytes = Base64.decode(encode);
//        String decode = new String(bytes, "UTF-8");
//        System.out.println(decode);

//        String str = null;
//        System.out.println(StringUtils.isEmpty(str));
//        System.out.println(StringUtils.isNotBlank("         "));
//        System.out.println(StringUtils.isNumeric("111.11"));
//        List<String> names = Arrays.asList("Arnie", "Lucy", "Beth", "Amir");
//        System.out.println(StringUtils.join(names, ";"));
//
//
//        String sentence = "The cat leapt over the big brown dog. hello";
//        // The cat leapt...
//        String abbreviated = StringUtils.abbreviate(sentence, 20);
//        System.out.println(abbreviated);
//        System.out.println(StringUtils.capitalize(sentence));
//        JsonNode nodeCategories = JsonFactory.getJsonNode("articles");
//        List<Article> articles = new ArrayList<>();
//        nodeCategories.forEach(jsonNode -> {
//            String name = jsonNode.get("name").asText();
//            String description = jsonNode.get("description").asText();
//            String detail = jsonNode.get("detail").asText();
//            String slug = SlugUtil.makeSlug(name);
//            articles.add(new Article(null, null, name, description, detail, slug));
//        });
        System.out.println();

    }
}
