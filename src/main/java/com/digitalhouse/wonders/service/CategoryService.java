package com.digitalhouse.wonders.service;

import com.digitalhouse.wonders.model.Category;
import com.digitalhouse.wonders.model.City;

import java.util.List;

public interface CategoryService {
    Category saveCategory(Category category);
    List<Category> getCategories();
    Category getByIdCategory(Integer id);
    void deleteCategory(Integer id);
    City saveCity(City city);
    City getByIdCity(Integer id);
    List<City> getCities();
    void deleteCity(Integer id);

    //void addCategoryToAccommodation(Integer accommodationId);
    //void addCityToAccommodation(Integer accommodationId);
}
