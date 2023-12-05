package com.kulbitski.restaurantCollectionAPI.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RestaurantCreateRequest {
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "City is required")
    private String city;
    @NotBlank(message = "Average Rating is required")
    private String averageRating;
    @NotEmpty(message = "EstimatedCost is required")
    private Integer estimatedCost;
    @NotEmpty(message = "Votes is required")
    private Integer votes;
}
