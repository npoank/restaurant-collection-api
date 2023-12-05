package com.kulbitski.restaurantCollectionAPI.services.impl;

import com.kulbitski.restaurantCollectionAPI.dto.requests.RestaurantCreateRequest;
import com.kulbitski.restaurantCollectionAPI.dto.requests.RestaurantUpdateRequest;
import com.kulbitski.restaurantCollectionAPI.exceptions.RestaurantNotFoundException;
import com.kulbitski.restaurantCollectionAPI.models.Restaurant;
import com.kulbitski.restaurantCollectionAPI.repositories.RestaurantsRepository;
import com.kulbitski.restaurantCollectionAPI.services.RestaurantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class RestaurantsServiceImpl implements RestaurantsService {

    public final RestaurantsRepository restaurantsRepository;

    @Autowired
    public RestaurantsServiceImpl(RestaurantsRepository restaurantsRepository) {
        this.restaurantsRepository = restaurantsRepository;
    }

    public List<Restaurant> findAll() {
        return restaurantsRepository.findAll();
    }

    @Override
    public List<Restaurant> findAll(Sort sort) {
        return restaurantsRepository.findAll(sort);
    }

    @Override
    public Restaurant findById(Integer id) {
        return restaurantsRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant with id: " + id + " not found!"));
    }

    @Override
    public List<Restaurant> findAllByCity(String city) {
        return restaurantsRepository.findByCityIgnoreCase(city);
    }


    @Transactional
    @Override
    public void save(RestaurantCreateRequest createRequest) {
        BigDecimal averageRating = new BigDecimal(createRequest.getAverageRating());

        Restaurant newRestaurant = new Restaurant(
                createRequest.getCity(),
                createRequest.getName(),
                averageRating,
                createRequest.getEstimatedCost(),
                createRequest.getVotes()
        );
    }

    @Transactional
    @Override
    public void update(Integer id, RestaurantUpdateRequest updateRequest) {
        BigDecimal averageRating = new BigDecimal(updateRequest.getAverageRating());

        Restaurant storedRestaurant = findById(id);
        storedRestaurant.setAverageRating(averageRating);
        storedRestaurant.setVotes(updateRequest.getVotes());
        restaurantsRepository.save(storedRestaurant);
    }

    @Override
    public void delete(Integer id) {
        restaurantsRepository.deleteById(id);
    }
}
