package pe.demo.api.demorest.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanRestaurantResponse {

  private Integer idPlan;
  private Integer idRestaurant;
  private String nameRestaurant;
  private String addressLocation;
  private String locality;
  private String city;
  private String timing;
  private Date dateAssistance;
  private String hourAssistance;

}
