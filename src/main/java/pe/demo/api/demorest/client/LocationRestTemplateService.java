package pe.demo.api.demorest.client;

import pe.demo.api.demorest.model.api.LocationResponse;

public interface LocationRestTemplateService {
  LocationResponse getLocations(String apikey, String query, Double lat, Double lon);
}
