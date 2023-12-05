package com.kulbitski.restaurantCollectionAPI.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RestaurantUpdateRequest {
    @NotBlank(message = "Average Rating is required")
    private String averageRating;
    @NotEmpty(message = "Votes is required")
    private Integer votes;
}
