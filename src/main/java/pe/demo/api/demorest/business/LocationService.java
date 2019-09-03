package pe.demo.api.demorest.business;

import pe.demo.api.demorest.model.api.LocationResponse;

public interface LocationService {
  LocationResponse getLocations(String apikey, String query, Double lat, Double lon);
}
