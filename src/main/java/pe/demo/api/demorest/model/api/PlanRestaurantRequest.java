package pe.demo.api.demorest.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanRestaurantRequest {
  @ApiModelProperty(
    value = "idRestaurant",
    name = "ID restaurant",
    example = "122331",
    dataType = "String",
    required = true,
    position = 1)
  @NotNull
  private Integer idRestaurant;

  @ApiModelProperty(
    value = "dateAssistance",
    name = "Date Assistance",
    example = "04/09/2019",
    dataType = "String",
    required = true,
    position = 2)
  @NotNull
  private String dateAssistance;

  @ApiModelProperty(
    value = "hourAssistance",
    name = "Hour Assistance",
    example = "15:00",
    dataType = "String",
    required = true,
    position = 3)
  @NotNull
  private String hourAssistance;
}
