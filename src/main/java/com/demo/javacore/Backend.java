package com.demo.javacore;

import com.demo.entity.Category;
import lombok.val;
import lombok.var;

import java.util.Optional;

public class Backend {
    public static void main(String[] args) {
        Category category = new Category();
        System.out.println(category.toString());
        val PI = 4;
        var k = 3;
        Optional a = Optional.empty();
        if (a.isPresent()) {
            System.out.println("present");
        }
    }
}
