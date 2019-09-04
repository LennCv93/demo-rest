package pe.demo.api.demorest.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.demo.api.demorest.business.RestaurantService;
import pe.demo.api.demorest.client.RestaurantRestTemplateService;
import pe.demo.api.demorest.model.api.PlanRestaurantRequest;
import pe.demo.api.demorest.model.api.PlanRestaurantResponse;
import pe.demo.api.demorest.model.api.RestaurantResponse;
import pe.demo.api.demorest.model.api.SearchResponse;
import pe.demo.api.demorest.model.entity.PlanRestaurant;
import pe.demo.api.demorest.repository.RestaurantRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

  @Autowired
  private RestaurantRestTemplateService restaurantRestTemplateService;

  @Autowired
  private RestaurantRepository restaurantRepository;

  @Override
  public SearchResponse searchRestaurants(String apikey, Double lat, Double lon, String cuisines, String category) {
    return this.restaurantRestTemplateService.searchRestaurants(apikey, lat, lon, cuisines, category);
  }

  @Override
  public void savePlanRestaurant(String apikey, PlanRestaurantRequest planRestaurantRequest) throws Exception {
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    RestaurantResponse restaurantResponse = this.restaurantRestTemplateService.getRestaurant(
      apikey, planRestaurantRequest.getIdRestaurant());
    if (restaurantResponse != null) {
      PlanRestaurant planRestaurant = PlanRestaurant.builder().idRestaurant(planRestaurantRequest.getIdRestaurant())
        .nameRestaurant(restaurantResponse.getName())
        .addressLocation(restaurantResponse.getLocation().getAddress())
        .locality(restaurantResponse.getLocation().getLocality())
        .city(restaurantResponse.getLocation().getCity())
        .timing(restaurantResponse.getTimings())
        .dateAssistance(format.parse(planRestaurantRequest.getDateAssistance()))
        .hourAssistance(planRestaurantRequest.getHourAssistance()).creationDate(new Date()).build();

      this.restaurantRepository.save(planRestaurant);
    }
  }

  @Override
  public List<PlanRestaurantResponse> findAllByDateAssistance(String dateAssistance) throws Exception {
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    List<PlanRestaurant> list = restaurantRepository.findAllByDateAssistance(format.parse(dateAssistance));

    if (list != null) {
      List<PlanRestaurantResponse> result = new ArrayList<>();
      for (PlanRestaurant entity : list) {
        PlanRestaurantResponse response = PlanRestaurantResponse.builder().idPlan(entity.getIdPlan())
          .idRestaurant(entity.getIdRestaurant()).nameRestaurant(entity.getNameRestaurant())
          .addressLocation(entity.getAddressLocation()).locality(entity.getLocality()).city(entity.getCity())
          .timing(entity.getTiming()).dateAssistance(entity.getDateAssistance())
          .hourAssistance(entity.getHourAssistance()).build();
        result.add(response);
      }
      return result;
    } else {
      return null;
    }
  }
}
