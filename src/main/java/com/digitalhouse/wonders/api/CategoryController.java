package com.digitalhouse.wonders.api;

import com.digitalhouse.wonders.model.Category;
import com.digitalhouse.wonders.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getCategories(){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/categories/").toUriString());
        return ResponseEntity.created(uri).body(categoryService.getCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable Integer id){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/categories/{id}").toUriString());
        return ResponseEntity.created(uri).body(categoryService.getByIdCategory(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Category> saveCategory(@RequestBody Category category){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/categories/save").toUriString());
        return ResponseEntity.created(uri).body(categoryService.saveCategory(category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer id){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").toUriString());
        categoryService.deleteCategory(id);
        return ResponseEntity.created(uri).body(HttpStatus.NO_CONTENT);
    }
}
