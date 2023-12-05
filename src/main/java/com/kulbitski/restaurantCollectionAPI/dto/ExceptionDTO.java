package com.kulbitski.restaurantCollectionAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionDTO {
    private String message;
    private String type;
}
