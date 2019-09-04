package pe.demo.api.demorest.client;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pe.demo.api.demorest.config.ApplicationConfig;
import pe.demo.api.demorest.model.api.RestaurantResponse;
import pe.demo.api.demorest.model.api.SearchResponse;

@Service
public class RestaurantRestTemplateServiceImpl implements RestaurantRestTemplateService {

  @Autowired
  private ApplicationConfig applicationConfig;

  @Override
  public SearchResponse searchRestaurants(String apikey, Double lat, Double lon, String cuisines, String category) {
    final String URL = this.applicationConfig.getUrlZomato() + this.applicationConfig.getUriRestaurantSearch();
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.set("user-key", apikey);

    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL)
      .queryParam("lat", lat)
      .queryParam("lon", lon)
      .queryParam("cuisines", cuisines)
      .queryParam("category", category);

    HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response = restTemplate.exchange(
      builder.toUriString(), HttpMethod.GET, entity, String.class);

    String json = response.getBody();

    Gson gson = new Gson();
    SearchResponse result = gson.fromJson(json, SearchResponse.class);
    return result;
  }

  @Override
  public RestaurantResponse getRestaurant(String apikey, Integer resId) {
    final String URL = this.applicationConfig.getUrlZomato() + this.applicationConfig.getUriRestaurantRestaurant();
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.set("user-key", apikey);

    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL)
      .queryParam("res_id", resId);

    HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response = restTemplate.exchange(
      builder.toUriString(), HttpMethod.GET, entity, String.class);

    String json = response.getBody();

    Gson gson = new Gson();
    RestaurantResponse result = gson.fromJson(json, RestaurantResponse.class);
    return result;
  }
}
