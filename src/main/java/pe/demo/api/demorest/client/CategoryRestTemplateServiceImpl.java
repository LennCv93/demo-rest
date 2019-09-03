package pe.demo.api.demorest.client;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pe.demo.api.demorest.config.ApplicationConfig;
import pe.demo.api.demorest.model.api.CategoryResponse;

@Service
public class CategoryRestTemplateServiceImpl implements CategoryRestTemplateService {

  @Autowired
  private ApplicationConfig applicationConfig;

  @Override
  public CategoryResponse getCategories(String apikey) {
    final String URL = this.applicationConfig.getUrlZomato() + this.applicationConfig.getUriCommonCategories();
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.set("user-key", apikey);

    HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.GET, entity, String.class);

    String json = response.getBody();
    Gson gson = new Gson();
    CategoryResponse result = gson.fromJson(json, CategoryResponse.class);
    return result;
  }
}
