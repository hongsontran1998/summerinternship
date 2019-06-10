package com.demo.javacore;

import com.demo.entity.Category;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class Main {
    public static void main(String[] args) {
        //mapper trong jackson json
        /*ObjectMapper mapper = new ObjectMapper();
        try {
            //json to object
            Category category = mapper.readValue("{\"id\" : \"1\", \"name\" : \"name\"}", Category.class);
            System.out.println(category);
            //object to json
            String json = mapper.writeValueAsString(category);
            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        //reactive programming in java
        Observable<Integer> b = Observable.just(2, 5);
        final int c = 3;

        Consumer<Integer> consumer = new Consumer<Integer>() {

            int a = 0;

            public void accept(Integer number) throws Exception {
                a = number + c;
                System.out.println(a);
            }
        };

    }
}
