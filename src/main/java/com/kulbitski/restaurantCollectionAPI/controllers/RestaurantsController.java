package com.kulbitski.restaurantCollectionAPI.controllers;

import com.kulbitski.restaurantCollectionAPI.converters.RestaurantConverter;
import com.kulbitski.restaurantCollectionAPI.dto.RestaurantDTO;
import com.kulbitski.restaurantCollectionAPI.dto.requests.RestaurantCreateRequest;
import com.kulbitski.restaurantCollectionAPI.dto.requests.RestaurantUpdateRequest;
import com.kulbitski.restaurantCollectionAPI.services.impl.RestaurantsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/restaurant")
public class RestaurantsController {

    private final RestaurantsServiceImpl restaurantsService;
    private final RestaurantConverter restaurantConverter;

    @Autowired
    public RestaurantsController(RestaurantsServiceImpl restaurantsService, RestaurantConverter restaurantConverter) {
        this.restaurantsService = restaurantsService;
        this.restaurantConverter = restaurantConverter;
    }

    @GetMapping
    public List<RestaurantDTO> getAllRestaurants() {
        return restaurantsService.findAll().stream()
                .map(restaurant -> restaurantConverter.convertToDTO(restaurant))
                .collect(Collectors.toList());
    }


    @GetMapping(value = "/query", params = "city")
    public List<RestaurantDTO> getRestaurantsByCity(@RequestParam(value = "city", required = true) String city) {
        return restaurantsService.findAllByCity(city).stream()
                .map(restaurant -> restaurantConverter.convertToDTO(restaurant))
                .collect(Collectors.toList());
    }


    @GetMapping(value = "/query", params = "id")
    public RestaurantDTO getRestaurantById(@RequestParam(value = "id", required = true) int id) {
        return restaurantConverter.convertToDTO(restaurantsService.findById(id));
    }


    @GetMapping("/sort")
    public List<RestaurantDTO> getAllSortedByRating() {
        Sort sort = Sort.by(Sort.Direction.DESC, "averageRating");
        return restaurantsService.findAll(sort).stream()
                .map(restaurant -> restaurantConverter.convertToDTO(restaurant)).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody RestaurantCreateRequest restaurantCreateRequest) {
        restaurantsService.save(restaurantCreateRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@RequestBody RestaurantUpdateRequest restaurantUpdateRequest, @PathVariable int id) {
        restaurantsService.update(id, restaurantUpdateRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable int id) {
        restaurantsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
