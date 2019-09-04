package pe.demo.api.demorest.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
public class ApplicationConfig {
  @Value("${application.http-client.zomato.url}")
  private String urlZomato;
  @Value("${application.http-client.zomato.common-categories.uri}")
  private String uriCommonCategories;
  @Value("${application.http-client.zomato.common-cuisines.uri}")
  private String uriCommonCuisines;
  @Value("${application.http-client.zomato.location-locations.uri}")
  private String uriLocationLocations;
  @Value("${application.http-client.zomato.restaurant-search.uri}")
  private String uriRestaurantSearch;
  @Value("${application.http-client.zomato.restaurant-restaurant.uri}")
  private String uriRestaurantRestaurant;
}
