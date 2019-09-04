package pe.demo.api.demorest.client;

import pe.demo.api.demorest.model.api.CuisinesResponse;

public interface CuisinesRestTemplateService {
  CuisinesResponse getCuisines(String apikey, Integer cityId, Double lat, Double lon);
}
