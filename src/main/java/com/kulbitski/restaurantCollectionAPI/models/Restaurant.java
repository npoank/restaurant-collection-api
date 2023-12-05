package com.kulbitski.restaurantCollectionAPI.models;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "city")
    private String city;

    @Column(name = "name")
    private String name;

    @Column(name = "estimated_cost")
    private int estimatedCost;

    @Column(name = "average_rating")
    private BigDecimal averageRating;

    @Column(name = "votes")
    private int votes;

    public Restaurant() {
    }

    public Restaurant(String city, String name,  BigDecimal averageRating, int estimatedCost, int votes) {
        this.city = city;
        this.name = name;
        this.estimatedCost = estimatedCost;
        this.averageRating = averageRating;
        this.votes = votes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(int estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public BigDecimal getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(BigDecimal averageRating) {
        this.averageRating = averageRating;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
