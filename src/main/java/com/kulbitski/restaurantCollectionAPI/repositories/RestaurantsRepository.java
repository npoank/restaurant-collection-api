package com.kulbitski.restaurantCollectionAPI.repositories;

import com.kulbitski.restaurantCollectionAPI.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantsRepository extends JpaRepository<Restaurant, Integer> {
    List<Restaurant> findByCityIgnoreCase(String city);

    List<Restaurant> findByOrderByAverageRatingDesc();
}
