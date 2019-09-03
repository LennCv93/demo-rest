package pe.demo.api.demorest.expose.web;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.demo.api.demorest.business.CategoryService;
import pe.demo.api.demorest.business.CuisinesService;
import pe.demo.api.demorest.business.LocationService;
import pe.demo.api.demorest.model.api.CategoryResponse;
import pe.demo.api.demorest.model.api.CuisinesResponse;
import pe.demo.api.demorest.model.api.LocationResponse;

@Api(value="Demo API Rest")
@RestController
@RequestMapping("/demo/api/v1")
@Slf4j
public class DemoController {

  @Autowired
  private CategoryService categoryService;
  @Autowired
  private CuisinesService cuisinesService;
  @Autowired
  private LocationService locationService;

  @GetMapping(
    value = "/categories",
    produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(
    value = "Get Categories",
    produces = MediaType.APPLICATION_JSON_VALUE,
    httpMethod = "GET",
    response = CategoryResponse.class)
  @ApiResponses({
    @ApiResponse(code = 200, message = "Process Successful"),
    @ApiResponse(code = 401, message = "Not Authorized"),
    @ApiResponse(code = 403, message = "Forbidden"),
    @ApiResponse(code = 404, message = "Not found resource")
  })
  public CategoryResponse getCategories(@RequestHeader(value = "api-key", required = true) final String apikey){
    log.info("Enter endpoint-> /getCategories - GET");
    CategoryResponse result = this.categoryService.getCategories(apikey);
    log.info("End endpoint-> /getCategories - GET");
    return result;
  }

  @GetMapping(
    value = "/cuisines",
    produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(
    value = "Get Cuisines",
    produces = MediaType.APPLICATION_JSON_VALUE,
    httpMethod = "GET",
    response = CuisinesResponse.class)
  @ApiResponses({
    @ApiResponse(code = 200, message = "Process Successful"),
    @ApiResponse(code = 401, message = "Not Authorized"),
    @ApiResponse(code = 403, message = "Forbidden"),
    @ApiResponse(code = 404, message = "Not found resource")
  })
  public CuisinesResponse getCuisines(@RequestHeader(value = "api-key", required = true) final String apikey,
                                      @ApiParam(value = "City Identificator", example =  "280", required = true)
                                      @RequestParam(value = "city_id") Integer cityId,
                                      @ApiParam(value = "Latitude", example = "00.00000")
                                      @RequestParam(value = "lat", required = false) Double lat,
                                      @ApiParam(value = "Longitude", example = "00.00000")
                                      @RequestParam(value = "lon", required = false) Double lon){
    log.info("Enter endpoint-> /cuisines - GET");
    CuisinesResponse result = this.cuisinesService.getCuisines(apikey, cityId, lat, lon);
    log.info("End endpoint-> /cuisines - GET");
    return result;
  }

  @GetMapping(
    value = "/locations",
    produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(
    value = "Get Locations",
    produces = MediaType.APPLICATION_JSON_VALUE,
    httpMethod = "GET",
    response = LocationResponse.class)
  @ApiResponses({
    @ApiResponse(code = 200, message = "Process Successful"),
    @ApiResponse(code = 401, message = "Not Authorized"),
    @ApiResponse(code = 403, message = "Forbidden"),
    @ApiResponse(code = 404, message = "Not found resource")
  })
  public LocationResponse geLocations(@RequestHeader(value = "api-key", required = true) final String apikey,
                                      @ApiParam(value = "Location Name", example =  "New York", required = true)
                                      @RequestParam("query") String query,
                                      @ApiParam(value = "Latitude", example = "00.00000")
                                      @RequestParam(value = "lat", required = false) Double lat,
                                      @ApiParam(value = "Longitude", example = "00.00000")
                                      @RequestParam(value = "lon", required = false) Double lon){
    log.info("Enter endpoint-> /locations - GET");
    LocationResponse result = this.locationService.getLocations(apikey, query, lat, lon);
    log.info("End endpoint-> /locations - GET");
    return result;
  }

}
