package pe.demo.api.demorest.business;

import pe.demo.api.demorest.model.api.SearchResponse;

public interface RestaurantService {
  SearchResponse searchRestaurants(String apikey, Double lat, Double lon, String cuisines, String category);
}
