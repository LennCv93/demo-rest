package pe.demo.api.demorest.client;

import pe.demo.api.demorest.model.api.SearchResponse;

public interface RestaurantRestTemplateService {
  SearchResponse searchRestaurants(String apikey, Double lat, Double lon, String cuisines, String category);
}
