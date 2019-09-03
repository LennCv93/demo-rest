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
import pe.demo.api.demorest.model.api.CuisinesResponse;

@Service
public class CuisinesRestTemplateServiceImpl implements CuisinesRestTemplateService {

  @Autowired
  private ApplicationConfig applicationConfig;

  @Override
  public CuisinesResponse getCuisines(String apikey, Integer cityId, Double lat, Double lon) {
    final String URL = this.applicationConfig.getUrlZomato() + this.applicationConfig.getUriCommonCuisines();
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.set("user-key", apikey);

    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL)
      .queryParam("city_id", cityId)
      .queryParam("lat", lat)
      .queryParam("lon", lon);

    HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response = restTemplate.exchange(
      builder.toUriString(), HttpMethod.GET, entity, String.class);

    String json = response.getBody();

    Gson gson = new Gson();
    CuisinesResponse result = gson.fromJson(json, CuisinesResponse.class);

    return result;
  }
}
