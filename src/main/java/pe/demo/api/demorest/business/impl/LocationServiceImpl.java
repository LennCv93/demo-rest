package pe.demo.api.demorest.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.demo.api.demorest.business.LocationService;
import pe.demo.api.demorest.client.LocationRestTemplateService;
import pe.demo.api.demorest.model.api.LocationResponse;

@Service
public class LocationServiceImpl implements LocationService {

  @Autowired
  private LocationRestTemplateService locationRestTemplateService;

  @Override
  public LocationResponse getLocations(String apikey, String query, Double lat, Double lon) {
    return this.locationRestTemplateService.getLocations(apikey, query, lat, lon);
  }
}
