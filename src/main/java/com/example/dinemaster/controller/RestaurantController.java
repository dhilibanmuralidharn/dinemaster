/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.ArrayList;
 * 
 */
package com.example.dinemaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.dinemaster.model.Restaurant;
import com.example.dinemaster.service.RestaurantJpaService;
import com.example.dinemaster.repository.RestaurantRepository;

@RestController
public class RestaurantController {

    @Autowired
    public com.example.dinemaster.service.RestaurantJpaService restaurantJpaService;

    @GetMapping("/restaurants")
    public ArrayList<Restaurant> getRestaurants() {
        return restaurantJpaService.getRestaurants();
    }

    @GetMapping("/restaurants/{restaurantId}")
    public Restaurant getRestaurantById(@PathVariable("restaurantId") int id) {
        return restaurantJpaService.getRestaurantById(id);
    }

    @PostMapping("/restaurants")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantJpaService.addRestaurant(restaurant);
    }

    @PutMapping("/restaurants/{restaurantId}")
    public Restaurant updateRestaurant(@PathVariable("restaurantId") int id, @RequestBody Restaurant restaurant) {
        return restaurantJpaService.updateRestaurant(id, restaurant);
    }

    @DeleteMapping("/restaurants/{restaurantId}")
    public void deleteRestaurant(@PathVariable("restaurantId") int id) {
        restaurantJpaService.deleteRestaurant(id);
    }
}
