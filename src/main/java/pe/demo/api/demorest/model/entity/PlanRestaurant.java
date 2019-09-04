package pe.demo.api.demorest.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "planrestaurant", schema = "dbo")
public class PlanRestaurant {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_plan", updatable = false, nullable = false)
  private Integer idPlan;
  @Column(name = "id_restaurant")
  private Integer idRestaurant;
  @Column(name = "name_restaurant")
  private String nameRestaurant;
  @Column(name = "address_location")
  private String addressLocation;
  @Column(name = "locality")
  private String locality;
  @Column(name = "city")
  private String city;
  @Column(name = "timing")
  private String timing;
  @Column(name = "date_assistance")
  private Date dateAssistance;
  @Column(name = "hour_assistance")
  private String hourAssistance;
  @Column(name = "creation_date")
  private Date creationDate;
}
