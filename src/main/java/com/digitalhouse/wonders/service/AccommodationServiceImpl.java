package com.digitalhouse.wonders.service;

import com.digitalhouse.wonders.model.*;
import com.digitalhouse.wonders.repo.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class AccommodationServiceImpl implements AccommodationService{

    private final AccommodationRepo accommodationRepo;
    private final CityRepo cityRepo;
    private final CategoryRepo categoryRepo;
    private final ImageRepo imageRepo;
    private final RatingRepo ratingRepo;
    private final UserRepo userRepo;

    @Override
    public Accommodation saveAccommodation(String categoryName, String cityName, Accommodation accommodation){
        log.info("Saving new accommodation to the database, with title: {}", accommodation.getName());
        City city = cityRepo.findByName(cityName);
        Category category = categoryRepo.findByName(categoryName);
        accommodationRepo.save(accommodation);
        category.getAccommodations().add(accommodation);
        city.getAccommodations().add(accommodation);
        return accommodation;
    }
    @Override
    public Accommodation getAccommodation(Integer id){
        log.info("Fetching accommodation with id: {}", id);
        return accommodationRepo.findById(id).orElse(null);}
    @Override
    public List<Accommodation> getAccommodations(){
        log.info("Fetching all accommodations");
        return accommodationRepo.findAll();}
    @Override
    public void deleteAccomodation(Integer id){
        log.info("Deleting accommodation with id: {}", id);
        accommodationRepo.deleteById(id);
    }
    @Override
    public Image saveImage(Image image){
        log.info("Saving set of images to the database");
        return imageRepo.save(image);};

    @Override
    public Rating saveRating(String username, Rating rating, Integer accommodationId) {
        AppUser user = userRepo.findByUsername(username);
        Accommodation accommodation = accommodationRepo.findById(accommodationId).orElse(null);
        rating.setAccommodation(accommodation);
        rating.setUser(user);
        rating.setUsername(user.getName());
        ratingRepo.save(rating);
        updateRatingAvg(accommodationId);
        return rating;
    }

    @Override
    public void updateRatingAvg(Integer id) {
        Double average = ratingRepo.ratingAverage(id);
        Accommodation accommodation = accommodationRepo.findById(id).orElse(null);
        accommodation.setRate(average);
    }
}
