package pe.demo.api.demorest.business;

import pe.demo.api.demorest.model.api.PlanRestaurantRequest;
import pe.demo.api.demorest.model.api.PlanRestaurantResponse;
import pe.demo.api.demorest.model.api.SearchResponse;

import java.util.List;

public interface RestaurantService {
  SearchResponse searchRestaurants(String apikey, Double lat, Double lon, String cuisines, String category);

  void savePlanRestaurant(String apikey, PlanRestaurantRequest planRestaurantRequest) throws Exception;

  List<PlanRestaurantResponse> findAllByDateAssistance(String dateAssistance) throws Exception;
}
