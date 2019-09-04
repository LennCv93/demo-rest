package pe.demo.api.demorest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.demo.api.demorest.model.entity.PlanRestaurant;

import java.util.Date;
import java.util.List;

public interface RestaurantRepository extends JpaRepository<PlanRestaurant, Integer> {
  List<PlanRestaurant> findAllByDateAssistance(Date dateAssistance);
}
