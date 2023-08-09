package com.digitalhouse.wonders.api;

import com.digitalhouse.wonders.model.Accommodation;
import com.digitalhouse.wonders.model.Rating;
import com.digitalhouse.wonders.service.AccommodationService;
import lombok.Data;
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
@RequestMapping("/accommodations")
public class AccommodationController {

    private final AccommodationService accommodationService;

    @GetMapping
    public ResponseEntity<List<Accommodation>> getAccommodations(){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/accommodations/").toUriString());
        return ResponseEntity.created(uri).body(accommodationService.getAccommodations());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Accommodation> getById(@PathVariable Integer id){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/accommodations/{id}").toUriString());
        return ResponseEntity.created(uri).body(accommodationService.getAccommodation(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/accommodations/{id}").toUriString());
        accommodationService.deleteAccomodation(id);
        return ResponseEntity.created(uri).body(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/save")
    public ResponseEntity<Accommodation> saveAccommodation(@RequestBody AccommodationForm form) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/accommodations/save").toUriString());
        return ResponseEntity.created(uri).body(accommodationService.saveAccommodation(form.getCategoryName(), form.getCityName(), form.getAccommodation()));
    }

    @PostMapping("/rating/save")
    public ResponseEntity<Rating> saveRating(@RequestBody RatingForm form){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/rating/save").toUriString());
        return ResponseEntity.created(uri).body(accommodationService.saveRating(form.getUsername(), form.getRating(), form.getAccommodationId()));
    }


}

@Data
class AccommodationForm{
    private String categoryName;
    private String cityName;
    private Accommodation accommodation;
}

@Data
class RatingForm{
    private String username;
    private Integer accommodationId;
    private Rating rating;
}
