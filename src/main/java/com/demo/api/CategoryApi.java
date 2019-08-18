package com.demo.api;

import com.demo.entity.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface CategoryApi {

    @GetMapping("")
    ResponseEntity<Object> findAll();

    @GetMapping("/{id}")
    ResponseEntity<Object> findOneById(@PathVariable Integer id);

    @PostMapping("")
    ResponseEntity<Object> insertOne(@RequestBody Category category);

}
