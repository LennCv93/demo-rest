package pe.demo.api.demorest.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.demo.api.demorest.business.CuisinesService;
import pe.demo.api.demorest.client.CuisinesRestTemplateService;
import pe.demo.api.demorest.model.api.CuisinesResponse;

@Service
public class CuisinesServiceImpl implements CuisinesService {

  @Autowired
  private CuisinesRestTemplateService cuisinesRestTemplateService;

  @Override
  public CuisinesResponse getCuisines(String apikey, Integer cityId, Double lat, Double lon) {
    return this.cuisinesRestTemplateService.getCuisines(apikey, cityId, lat, lon);
  }
}
