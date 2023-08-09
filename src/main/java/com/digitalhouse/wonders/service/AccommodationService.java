package com.digitalhouse.wonders.service;

import com.digitalhouse.wonders.model.Accommodation;
import com.digitalhouse.wonders.model.Image;
import com.digitalhouse.wonders.model.Rating;

import java.util.List;


public interface AccommodationService {
    Accommodation saveAccommodation(String categoryName, String cityName, Accommodation accommodation);
    Accommodation getAccommodation(Integer id);
    List<Accommodation> getAccommodations();
    void deleteAccomodation(Integer id);
    Image saveImage(Image image);

    Rating saveRating(String username, Rating rating, Integer accommodationId);
    void updateRatingAvg(Integer id);

}
