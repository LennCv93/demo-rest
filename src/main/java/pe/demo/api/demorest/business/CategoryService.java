package pe.demo.api.demorest.business;

import pe.demo.api.demorest.model.api.CategoryResponse;

public interface CategoryService {

  CategoryResponse getCategories(String apikey);

}
