package pe.demo.api.demorest.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.demo.api.demorest.business.RestaurantService;
import pe.demo.api.demorest.client.RestaurantRestTemplateService;
import pe.demo.api.demorest.model.api.SearchResponse;

@Service
public class RestaurantServiceImpl implements RestaurantService {

  @Autowired
  private RestaurantRestTemplateService restaurantRestTemplateService;

  @Override
  public SearchResponse searchRestaurants(String apikey, Double lat, Double lon, String cuisines, String category) {
    return this.restaurantRestTemplateService.searchRestaurants(apikey, lat, lon, cuisines, category);
  }
}
