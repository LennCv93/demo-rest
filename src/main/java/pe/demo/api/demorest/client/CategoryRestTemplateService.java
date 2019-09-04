package pe.demo.api.demorest.client;

import pe.demo.api.demorest.model.api.CategoryResponse;

public interface CategoryRestTemplateService {
  CategoryResponse getCategories(String apikey);
}
