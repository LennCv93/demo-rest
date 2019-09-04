package pe.demo.api.demorest.business;

import pe.demo.api.demorest.model.api.CuisinesResponse;

public interface CuisinesService {
  CuisinesResponse getCuisines(String apikey, Integer cityId, Double lat, Double lon);
}
