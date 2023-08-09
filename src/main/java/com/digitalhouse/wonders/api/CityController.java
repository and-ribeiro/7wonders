package com.digitalhouse.wonders.api;


import com.digitalhouse.wonders.model.City;
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
@RequestMapping("/cities")
public class CityController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<City>> getCategories(){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/cities/").toUriString());
        return ResponseEntity.created(uri).body(categoryService.getCities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getById(@PathVariable Integer id){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/cities/{id}").toUriString());
        return ResponseEntity.created(uri).body(categoryService.getByIdCity(id));
    }

    @PostMapping("/save")
    public ResponseEntity<City> saveCategory(@RequestBody City city){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/cities/save").toUriString());
        return ResponseEntity.created(uri).body(categoryService.saveCity(city));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer id){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").toUriString());
        categoryService.deleteCity(id);
        return ResponseEntity.created(uri).body(HttpStatus.NO_CONTENT);
    }
}
