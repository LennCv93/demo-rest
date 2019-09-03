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
import pe.demo.api.demorest.model.api.LocationResponse;

@Service
public class LocationRestTemplateServiceImpl implements LocationRestTemplateService {

  @Autowired
  private ApplicationConfig applicationConfig;

  @Override
  public LocationResponse getLocations(String apikey, String query, Double lat, Double lon) {
    final String URL = this.applicationConfig.getUrlZomato() + this.applicationConfig.getUriLocationLocations();
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.set("user-key", apikey);

    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL)
      .queryParam("query", query)
      .queryParam("lat", lat)
      .queryParam("lon", lon);

    HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response = restTemplate.exchange(
      builder.toUriString(), HttpMethod.GET, entity, String.class);

    String json = response.getBody();

    Gson gson = new Gson();
    LocationResponse result = gson.fromJson(json, LocationResponse.class);

    return result;
  }
}
