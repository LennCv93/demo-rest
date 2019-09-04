package pe.demo.api.demorest.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestaurantResponse {
  private R R;
  private String apikey;
  private String id;
  private String name;
  private String url;
  private Location location;
  private float switch_to_order_menu;
  private String cuisines;
  private String timings;
  private float average_cost_for_two;
  private float price_range;
  private String currency;
  private ArrayList<Object> highlights;
  private ArrayList<Object> offers;
  private float opentable_support;
  private float is_zomato_book_res;
  private String mezzo_provider;
  private float is_book_form_web_view;
  private String book_form_web_view_url;
  private String book_again_url;
  private String thumb;
  private User_rating user_rating;
  private float all_reviews_count;
  private String photos_url;
  private float photo_count;
  private ArrayList<Object> photos;
  private String menu_url;
  private String featured_image;
  private float has_online_delivery;
  private float is_delivering_now;
  private boolean include_bogo_offers;
  private String deeplink;
  private float is_table_reservation_supported;
  private float has_table_booking;
  private String events_url;
  private String phone_numbers;
  private All_reviews all_reviews;
  private ArrayList<Object> establishment;

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  @JsonIgnoreProperties(ignoreUnknown = true)
  public class All_reviews {
    private ArrayList<Object> reviews;
  }

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  @JsonIgnoreProperties(ignoreUnknown = true)
  public class User_rating {
    private String aggregate_rating;
    private String rating_text;
    private String rating_color;
    private Rating_obj rating_obj;
    private String votes;
  }

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  @JsonIgnoreProperties(ignoreUnknown = true)
  public class Rating_obj {
    private Title TitleObject;
    private Bg_color Bg_colorObject;
  }

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  @JsonIgnoreProperties(ignoreUnknown = true)
  public class Bg_color {
    private String type;
    private String tint;
  }

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  @JsonIgnoreProperties(ignoreUnknown = true)
  public class Title {
    private String text;
  }

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  @JsonIgnoreProperties(ignoreUnknown = true)
  public class Location {
    private String address;
    private String locality;
    private String city;
    private float city_id;
    private String latitude;
    private String longitude;
    private String zipcode;
    private float country_id;
    private String locality_verbose;
  }

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  @JsonIgnoreProperties(ignoreUnknown = true)
  public class R {
    private Has_menu_status has_menu_status;
    private float res_id;
  }

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  @JsonIgnoreProperties(ignoreUnknown = true)
  public class Has_menu_status {
    private float delivery;
    private float takeaway;
  }
}
