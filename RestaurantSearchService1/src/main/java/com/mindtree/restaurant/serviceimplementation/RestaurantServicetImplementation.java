package com.mindtree.restaurant.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.restaurant.entity.Restaurant;
import com.mindtree.restaurant.repository.RestaurantRepository;
import com.mindtree.restaurant.service.RestaurantService;

@Service
public class RestaurantServicetImplementation implements RestaurantService
{
	@Autowired
	RestaurantRepository restaurantRepo;

	@Override
	public Restaurant createRestaurant(Restaurant restaurent) 
	{
		return restaurantRepo.save(restaurent);
	}

	@Override
	public List<Restaurant> getRestaurentByName(String name) {
		
		List<Restaurant> restaurant=restaurantRepo.findByName(name);
		return restaurant;
	}

	@Override
	public List<Restaurant> getRestaurentByLocation(String location) {
		
		List<Restaurant> restaurant=restaurantRepo.findByLocation(location);
		return restaurant;
	}

	@Override
	public List<Restaurant> getRestaurentByDistance(int distance) {
		
		List<Restaurant> restaurant=restaurantRepo.findByDistance(distance);
		return restaurant;
	}

	@Override
	public List<Restaurant> getRestaurentByCuisine(String cusine) {
		
		List<Restaurant> restaurant=restaurantRepo.findByCusine(cusine);
		return restaurant;
	}

	@Override
	public List<Restaurant> getRestaurentByBudget(int budget) {
		List<Restaurant> restaurant=restaurantRepo.findByBudget(budget);		
		return restaurant;
	}

	@Override
	public List<Restaurant> getRestaurentByRating(double rating) {
		
		List<Restaurant> restaurant=restaurantRepo.findByRating(rating);		
		return restaurant;
	}
	
	
//    public User getUser(String userId) {
//        //get user from database with the help  of user repository
//        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !! : " + userId));
//        // fetch rating of the above  user from RATING SERVICE
//        //http://localhost:8083/ratings/users/47e38dac-c7d0-4c40-8582-11d15f185fad
//
//        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserId(), Rating[].class);
//        logger.info("{} ", ratingsOfUser);
//        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
//        List<Rating> ratingList = ratings.stream().map(rating -> {
//            //api call to hotel service to get the hotel
//            //http://localhost:8082/hotels/1cbaf36d-0b28-4173-b5ea-f1cb0bc0a791
//            //ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
//            Hotel hotel = hotelService.getHotel(rating.getHotelId());
//            // logger.info("response status code: {} ",forEntity.getStatusCode());
//            //set the hotel to rating
//            rating.setHotel(hotel);
//            //return the rating
//            return rating;
//        }).collect(Collectors.toList());
//
//        user.setRatings(ratingList);
//
//        return user;
//    }
	

}
