package com.kulbitski.restaurantCollectionAPI.services;

import com.kulbitski.restaurantCollectionAPI.dto.requests.*;
import com.kulbitski.restaurantCollectionAPI.models.Restaurant;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface RestaurantsService {
    List<Restaurant> findAll();

    List<Restaurant> findAll(Sort sort);

    Restaurant findById(Integer id);

    List<Restaurant> findAllByCity(String city);

    void save(RestaurantCreateRequest createRequest);

    void update(Integer id, RestaurantUpdateRequest updateRequest);

    void delete(Integer id);
}
