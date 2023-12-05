package com.kulbitski.restaurantCollectionAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDTO {
    private Integer id;
    private String city;
    private String name;
    private String averageRating;
    private int estimatedCost;
    private int votes;
}
