package com.digitalhouse.wonders.service;

import com.digitalhouse.wonders.model.Accommodation;
import com.digitalhouse.wonders.model.Category;
import com.digitalhouse.wonders.model.City;
import com.digitalhouse.wonders.repo.AccommodationRepo;
import com.digitalhouse.wonders.repo.CategoryRepo;
import com.digitalhouse.wonders.repo.CityRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;
    private final CityRepo cityRepo;
    private final AccommodationRepo accommodationRepo;

    @Override
    public Category saveCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public City saveCity(City city) {
        return cityRepo.save(city);
    }

    @Override
    public List<City> getCities() {
        return cityRepo.findAll();
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepo.deleteById(id);
    }

    @Override
    public void deleteCity(Integer id) {
        cityRepo.deleteById(id);
    }

    @Override
    public Category getByIdCategory(Integer id) {
        return categoryRepo.findById(id).orElse(null);
    }

    @Override
    public City getByIdCity(Integer id) {
        return cityRepo.findById(id).orElse(null);
    }
}
