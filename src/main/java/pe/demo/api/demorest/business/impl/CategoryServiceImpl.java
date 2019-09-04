package pe.demo.api.demorest.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.demo.api.demorest.business.CategoryService;
import pe.demo.api.demorest.client.CategoryRestTemplateService;
import pe.demo.api.demorest.model.api.CategoryResponse;

@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  private CategoryRestTemplateService categoryRestTemplateService;

  @Override
  public CategoryResponse getCategories(String apikey) {
    return this.categoryRestTemplateService.getCategories(apikey);
  }
}
