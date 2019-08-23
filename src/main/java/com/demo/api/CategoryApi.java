package com.demo.api;

import com.demo.entity.Category;
import com.demo.service.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/category")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface CategoryApi {

    @GetMapping("")
    ResponseEntity<Result> findAllOrFilter(
            @RequestParam(name = "q", required = false) String searchingText,
            @RequestParam(name = "offset", required = false) Integer offset,
            @RequestParam(name = "limit", required = false) Integer limit,
            @RequestParam(name = "sort_by", required = false) String sortBy,
            @RequestParam(name = "direction", required = false) String direction);

    @GetMapping("{id}")
    ResponseEntity<Result> findOneById(@PathVariable Integer id);

    @PostMapping("")
    ResponseEntity<Result> insertOne(@Valid @RequestBody Category category, BindingResult br);

    @PutMapping("")
    ResponseEntity<Result> updateOne(@Valid @RequestBody Category category, BindingResult br);

    @DeleteMapping("{id}")
    ResponseEntity<Result> deleteOneById(@PathVariable Integer id);

}
